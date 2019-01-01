package org.mybatis.demo.mapper;

import java.util.List;

import org.mybatis.demo.po.Orders;

public interface OrdersMapper {
	public List<Orders> findOrdersUserLazyLoading();
}
