package com.woniuxy.web.websocket;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.woniuxy.domain.Collect;
import com.woniuxy.domain.Goods;
import com.woniuxy.domain.User;
import com.woniuxy.service.ICollectService;
import com.woniuxy.service.IGoodsService;
import com.woniuxy.service.IUserService;

@ServerEndpoint("/msg/{uid}")
@Component
public class MsgWebSocket implements Runnable {

	private static IUserService userService;

	private static IGoodsService goodsService;

	private static ICollectService collectsService;
	
	public static Map<String, Session> map = new ConcurrentHashMap<>();
	//通知过的用户 key uid value 通知过的收藏商品
	public static Map<String, HashSet> noticedMap = new ConcurrentHashMap<>();

	static {
		MsgWebSocket msg = new MsgWebSocket();
		Thread t1 = new Thread(msg);
		t1.start();
	}

	@Autowired
	public void setIUserService(IUserService iUserService) {
		MsgWebSocket.userService = iUserService;
	}

	@Autowired
	public void setIGoodsService(IGoodsService iGoodsService) {
		MsgWebSocket.goodsService = iGoodsService;
	}

	@Autowired
	public void setICollectService(ICollectService iCollectService) {
		MsgWebSocket.collectsService = iCollectService;
	}


	
	

	@OnOpen
	public void connect(@PathParam("uid") String uid, Session session) throws Exception {
		System.out.println(uid + "   已连接");
		if (!map.containsKey(uid)) {
			session.getBasicRemote().sendText("系统消息:您收藏的拍品在结束拍卖前一小时会弹框提醒");
			map.put(uid, session);
		}
		if (noticedMap.containsKey(uid)) {
			noticedMap.remove(uid);
		}
	}

	@OnClose
	public void disConnect(@PathParam("uid") String uid, Session session) {
		System.out.println(uid + "   已退出");
		if (map.containsKey(uid)) {
			map.remove(uid);
		}
	}

	@OnMessage
	public void receiveMsg(@PathParam("uid") String uid, String msg, Session session) throws Exception {

	}

	// 目前先使用轮播提醒 我太难了我尽力了..
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		// 五秒一次轮播
		Set<Entry<String, Session>> entrySet = null;
		List<Collect> collects = null;

		while (true) {
			//究极暴力try catch
			System.out.println("轮播查询"+new Date());
			try {
				try {
					Thread.currentThread().sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 查找所有收藏
				collects = collectsService.findAll();
				entrySet = map.entrySet();
				if (entrySet == null || collects == null || collectsService == null || userService == null
						|| goodsService == null) {
					System.out.println("没有用户或service为空");
					continue;
				}
				// 所有用户session的集合
				Iterator<Entry<String, Session>> it = entrySet.iterator();
				// 用户循环
				while (it.hasNext()) {
					Entry<String, Session> next = it.next();
					// 一个用户
					String uid = next.getKey();
					Session session = next.getValue();
					if (!noticedMap.containsKey(uid)) {
						noticedMap.put(uid, new HashSet<Goods>());
					}
					// 所有收藏记录 收藏循环
					for (Collect collect : collects) {
						// 是该用户的收藏
						if (collect.getUid() == Integer.parseInt(uid)) {
							Integer gid = collect.getGid();
							Goods good = goodsService.findOne(gid);
							//结束时间 减去现在时间
							long endTime =  good.getGend().getTime()-new Date().getTime();
							long startTime =  good.getGstart().getTime()-new Date().getTime();
							System.out.println(uid+"#"+good.getGname()+"#"+endTime);
							//用户的收藏集合
							HashSet<Goods> userGoodsSet = noticedMap.get(uid);
							//没有通知就通知一下  通知完成后就加入 noticedGoods集合中 下次无法加入就不会通知
							boolean status = userGoodsSet.add(good);
							if (good != null&&endTime<60*60*1000&&endTime>0&&status) {
								System.out.println("拍卖结束提醒" + endTime);
								try {
									session.getBasicRemote()
											.sendText(String.format("alert###你收藏的%s,距离拍卖 结束 还有%d分钟", good.getGname(),endTime/1000/60));
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if (good != null&&startTime<60*60*1000&&startTime>0&&status) {
								System.out.println("拍卖开始提醒" + startTime);
								try {
									session.getBasicRemote()
											.sendText(String.format("alert###你收藏的%s,距离拍卖 开始 还有%d分钟", good.getGname(),startTime/1000/60));
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			} catch (Exception e) {
				//究极暴力try catch
			}

		}

	}

}
