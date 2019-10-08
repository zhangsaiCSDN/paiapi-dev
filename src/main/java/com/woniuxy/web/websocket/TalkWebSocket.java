package com.woniuxy.web.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

/*
 我们已经知道，http协议是一个无状态的连接协议。

 当服务器有新的消息时，客户端不能得到，除非客户端主动请求一下，服务器才能响应新数据。
 
 又有新数据了呢？ 
 
 解决方案：
 1. ajax轮询
 
 2. comet   
 
 3. H5 websocket  必须保证客户端浏览器支持websocket， 服务器也支持websocket （tomcat7.0或者以上）
 
*/



@ServerEndpoint("/talk")  
@Component
public class TalkWebSocket {

	private static Set<Session> set = new HashSet<>();
	
	// 当有客户端连接到当前服务端时，的回调函数，参数Session表示连接的会话
	@OnOpen
	public void onOpen(Session s) {
		set.add(s);
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
			
			for (Session s : set) {
				try {
					s.getBasicRemote().sendText(message);
				} catch (Exception e) {
					// swollow exception
				}
			}
	}
	
	@OnClose
	public void onClose(Session session) {
		set.remove(session);		
	}
}	
