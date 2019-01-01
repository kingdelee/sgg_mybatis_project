package com.zhang.dao;

import java.util.List;

import com.zhang.domain.Orders;
public interface OrdersDao {
		//查询订单关联查询用户，用户信息是延迟加载
		public List<Orders> findOrdersUserLazyLoading()throws Exception;
}
