package com.woniuxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
		
		if(deposit.getGoods().getGstate()==7||deposit.getGoods().getGstate()==3) {
			return "退款失败";
		}
		
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
			return "退款失败";
		}
	}

	@Override
	public Deposit findOne(Integer did) {
		 Deposit deposit = mapper.findOne(did);
		 System.out.println(deposit);
		return deposit;
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

	@Override
	public String updateList(Map<String , List<Deposit>> map) {

		List<Deposit> list = map.get("list");
			for (Deposit de :list) {
				de.setGstate(4);
				de.setDmoney(0d);
				Deposit deposit = findOne(de.getDid());
				
				
				try {
					
					if(deposit.getGoods().getGstate()==7||deposit.getGoods().getGstate()==3) {
						throw new RuntimeException();
					}
					
					switch (deposit.getGstate()) {
						case 0:
							throw new RuntimeException();
						case 1:
							mapper.updateByPrimaryKeySelective(de);
							break;
						case 2:
							mapper.updateByPrimaryKeySelective(de);
							break;
						case 3:
							throw new RuntimeException();
						case 4:
							throw new RuntimeException();
		
						default:
							throw new RuntimeException();
					}
				} catch (Exception e) {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return "退款失败";
				}
			}
		return "退款成功";
	}

	
}
