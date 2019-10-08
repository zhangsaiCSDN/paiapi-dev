package com.woniuxy.dao;

import com.woniuxy.domain.Orders;
import com.woniuxy.domain.OrdersExample;
import com.woniuxy.domain.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer odid);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer odid);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    List<Orders> find(Page<Orders> page);
    
    List<Orders> findByUid(Map<String , Object> map); //根据用户uid查询
    
    List<Orders> findByBuyerid(Map<String , Object> map); //根据用户buyerid查询
    
    Integer findCount(Map<String , Object> map);//根据用户uid查询
    
}