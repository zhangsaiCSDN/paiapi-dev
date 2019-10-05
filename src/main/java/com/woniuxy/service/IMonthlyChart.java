package com.woniuxy.service;

import java.util.Map;


public interface IMonthlyChart {

	Map<String , Object> find();
	Map<String , Object> findPieChart();
	Map<String , Object> findLineChart();
	
	Map<String ,Object> findData();
}
