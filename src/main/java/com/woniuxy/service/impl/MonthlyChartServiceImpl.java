package com.woniuxy.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.GoodstypeMapper;
import com.woniuxy.dao.MonthlyChartMapper;
import com.woniuxy.dao.RoleMapper;
import com.woniuxy.domain.Goodstype;
import com.woniuxy.domain.GoodstypeExample;
import com.woniuxy.domain.Pair;
import com.woniuxy.domain.Role;
import com.woniuxy.domain.Triplet;
import com.woniuxy.service.IMonthlyChart;

@Service
@Transactional
public class MonthlyChartServiceImpl implements IMonthlyChart {
	@Autowired
	private MonthlyChartMapper mapper;
	
	@Autowired
	private GoodstypeMapper goodtypes;
	
	
	
	//图表页面单条数据查询
	@Override
	public Map<String, Object> findData() {
		
		 Map<String, Object> map = new HashMap<>();
		
		 //总收入
		 Integer findGoodsMoney = mapper.findGoodsMoney();
		 map.put("findGoodsMoney", findGoodsMoney);
		 
		//使用人数
		 Integer findUserCount = mapper.findUserCount();
		 map.put("findUserCount", findUserCount);
		 
		 //订单总数量 
		 Integer findOrderCount = mapper.findOrderCount();
		 map.put("findOrderCount", findOrderCount);
		 
		 //拍品总数量
		 Integer findGoods = mapper.findGoods();
		 map.put("findGoods", findGoods);
		 
		 //保证金总额
		 Integer findDepositMoney = mapper.findDepositMoney();
		 map.put("findDepositMoney", findDepositMoney);
		 
		 //使用竞价室数量 
		 Integer findRoomMoney = mapper.findRoomMoney();
		 map.put("findRoomMoney", findRoomMoney);
		 
		 //公告总数量
		 Integer findAnnounceMoney = mapper.findAnnounceMoney();
		 map.put("findAnnounceMoney", findAnnounceMoney);
		 
		 //净利润收入
		 Double mon  = findGoodsMoney*0.2;
		 map.put("mon", mon);
		return map;
	}

	


	@Override
	public Map<String, Object> findLineChart() {
		List <Map<String ,Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Pair pair =null;
		
		//查询出所有的角色类型
		String [] str = new String[] {"卖家","买家"};
		
		List <Object > nums = null;
		//根据每一个商品类型查询该类型在本年内每个月的销售记额
		for (String s : str) {
			Map<String, Object> map2 = new HashMap<>();
			pair = new Pair(2019,s);
			 List<Triplet<String, Integer, Long>> charts = mapper.findLineChart(pair);
			
			//当本年该商品类型交易额不为空时,将交易额取出放入list集合
			if(charts.size()!=0) {
				nums= new ArrayList<>();
				String name = null;
				int i = 1 ; 
				for (Triplet<String, Integer, Long> chart : charts) {
					
					//若某个月份交易额为空,则将其设为0
					for (; i <= 12; i++) {
						if((Integer)chart.second != i) {
							nums.add(0);
						}else {
							//不为空时将其放入money集合中
							nums.add((Long)chart.three);
							name = chart.first;
							i++;
							break;
						}
					}

					//取出商品类型名称放入一个map集合中
					if(!map2.containsKey(name)&&name!=null) {
						map2.put("name", name);
					}
				}
				//当一个商品类型循环结束,把循环时存储12个月分销售额的
				//list集合放入一个map集合中,该集合与商品名称存放的map集合是一个
				map2.put("data", nums);
			}   
			//根据highcharts返回值要求,再将map2集合放入一个list集合中
			list.add(map2);
			
		}
		//此处返回map是为了携带更多的数据,上面的list已经满足highcharts返回值要求
		map.put("series", list);
		
		return  map;
	}
	
	
	
	
	@Override
	public Map<String, Object> findPieChart() {
		Date date = new Date();
		Map<String ,Object> map = new HashMap<>();
		List<Map<String , Object>> chart = new ArrayList<>();
		
		int count = mapper.findGoodsCount(date.getYear());
		
		List<Pair<String, String>> data = mapper.findPieChart(date.getYear());
		for (Pair<String, String> pair : data) {
		
			Map<String ,Object> map2 = new HashMap<>();
			 String state = String.valueOf(pair.first);
			String name = "";
			
			switch (state) {
			case "0":
				name = "待审核";
				break;
			case "1":
				name = "未通过审核";
				break;
			case "2":
				name = "公告期";
				break;
			case "3":
				name = "拍卖期";
				break;
			case "4":
				name = "无效";
				break;
			case "5":
				name = "等待竞价";
				break;
			case "6":
				name = "竞价失败";
				break;
			case "7":
				name = "已成交";
				break;
			}
			map2.put("name", name);
			double db = Double.parseDouble(String.valueOf(pair.second));
			DecimalFormat df = new DecimalFormat("0.0");
			String percentage = df.format(db/count);
			map2.put("y",Double.parseDouble(percentage));
			
			chart.add(map2);
		}
		
		map.put("series", chart);
		return map;
	}

	
	
	
	
	
	@Override
	public Map<String , Object> find() {
		List <Map<String ,Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Pair pair =null;
		
		//查询出所有的商品类型
		List<Goodstype> goodTypes = goodtypes.selectByExample(null);
		
		List <Double > moneys = null;
		//根据每一个商品类型查询该类型在本年内每个月的销售记额
		for (Goodstype goodstype : goodTypes) {
			Map<String, Object> map2 = new HashMap<>();
			pair = new Pair(2019,goodstype.getGtid());
			List<GoodstypeExample> charts = mapper.find(pair);
			
			//当本年该商品类型交易额不为空时,将交易额取出放入list集合
			if(charts.size()!=0) {
				moneys= new ArrayList<>();
				int i = 1 ; 
				for (GoodstypeExample chart : charts) {
					String name = null;
					System.out.println( chart.getGtname());
					//若某个月份交易额为空,则将其设为0
					for (; i <= 12; i++) {
						if(Integer.parseInt(chart.getMonth()) != i) {
							moneys.add(0d);
						}else {
							//不为空时将其放入money集合中
							moneys.add(chart.getOdmoney());
							name = chart.getGtname();
							i++;
							break;
						}
					}

					//取出商品类型名称放入一个map集合中
					if((!map2.containsKey(name))&&name!=null) {
						map2.put("name", name);
					}
				}
				//当一个商品类型循环结束,把循环时存储12个月分销售额的
				//list集合放入一个map集合中,该集合与商品名称存放的map集合是一个
				
				map2.put("data", moneys);
			
			}
			//根据highcharts返回值要求,再将map2集合放入一个list集合中
			if(map2.get("name")!=null) {
				list.add(map2);
			}
			
		}
		//此处返回map是为了携带更多的数据,上面的list已经满足highcharts返回值要求
		map.put("series", list);
		
		return  map;
	}










	
	
	


}
