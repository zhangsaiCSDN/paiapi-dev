package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.DepositMapper;
import com.woniuxy.domain.Deposit;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IDepositService;
  
@Service
@Transactional
public class DepositServiceImpl implements IDepositService {

	@Autowired
	private DepositMapper mapper;
	@Override
	public void save(Deposit ds) {
		mapper.insert(ds);
		
	}

	@Override
	public void delete(Integer did) {

		mapper.deleteByPrimaryKey(did);
	}

	@Override
	public String update(Deposit ds) {
		Deposit deposit = findOne(ds.getDid());
		
		switch (deposit.getGstate()) {
		case 0:
			return "退款失败,您的押金已被扣除";
		case 1:
			return "退款正在申请中";
		case 2:
			mapper.updateByPrimaryKeySelective(ds);
			return "退款申请中";
		case 3:
			return "退款失败,您的押金已已抵押货款";
		case 4:
			return "退款成功";

		default:
			return "";
		}
	}

	@Override
	public Deposit findOne(Integer did) {

		return mapper.selectByPrimaryKey(did);
	}

	@Override
	public List<Deposit> find(Page<Deposit> page) {
		
		return mapper.findAll(page);
	}

	@Override
	public Integer count() {
		
		return  (int) mapper.countByExample(null);
	}

	@Override
	public Page<Deposit> findDepo(Integer p ,Integer size) {
		// TODO Auto-generated method stub
		int findCount = mapper.findCount();
		Page<Deposit> page = new Page<Deposit>(p, findCount, size);
		List<Deposit> list = mapper.findDepo(page);
		page.setList(list);
		return page;
	}

	
}
