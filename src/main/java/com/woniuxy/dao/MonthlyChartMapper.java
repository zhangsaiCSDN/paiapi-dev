package com.woniuxy.dao;

import java.util.List;

import com.woniuxy.domain.GoodstypeExample;
import com.woniuxy.domain.Pair;
import com.woniuxy.domain.Triplet;

public interface MonthlyChartMapper {
   List<GoodstypeExample> find(Pair pair);
   List<Pair<String,String>>findPieChart(int year);
   List<Triplet<String ,Integer ,Long>>findLineChart(Pair pair);
   Integer findGoodsCount(int year);
   
   
   
   Integer findGoodsMoney();
   Integer findUserCount();
   Integer findOrderCount();
   Integer findGoods();
   Integer findDepositMoney();
   Integer findRoomMoney();
   Integer findAnnounceMoney();
}