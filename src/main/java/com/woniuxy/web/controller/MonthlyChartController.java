package com.woniuxy.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.service.IMonthlyChart;

@Controller
@RequestMapping("chart")
public class MonthlyChartController {

	@Autowired
	private IMonthlyChart service;
	
	@PostMapping
	@ResponseBody
	public Map<String , Object> find() {
		Map<String, Object> map = service.find();
		return map;
	}
	
	@PostMapping("pie")
	@ResponseBody
	public Map<String , Object> findPieChart() {
		Map<String, Object> map = service.findPieChart();
		return map;
	}
	
	@PostMapping("line")
	@ResponseBody
	public Map<String , Object> findLineChart() {
		Map<String, Object> map = service.findLineChart();
		return map;
	}
	
	@PostMapping("data")
	@ResponseBody
	public Map<String , Object> findData() {
		Map<String, Object> map = service.findData();
		return map;
	}

}