package com.woniuxy.service;

import java.util.List;
import com.woniuxy.domain.Deposit;
  
public interface IDepositService {

	void save(Deposit ds);
	void delete(Integer did);
	void update(Deposit ds);
	Deposit findOne(Integer did);
	List<Deposit> find();

}
