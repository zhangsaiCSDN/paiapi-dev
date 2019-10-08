package com.woniuxy.service;

import java.util.List;
import java.util.Map;

import com.woniuxy.domain.Deposit;
import com.woniuxy.domain.Page;
  
public interface IDepositService {

	void save(Deposit ds);
	void delete(Integer did);
	String update(Deposit ds);
	String updateList(Map<String , List<Deposit>> map);
	Deposit findOne(Integer did);
	List<Deposit> find(Page<Deposit> page);
	Integer count();
	Page<Deposit> findDepo(Integer p ,Integer size , Integer uid);
	
	List<Deposit> search(Map<String,Object> map);
}
