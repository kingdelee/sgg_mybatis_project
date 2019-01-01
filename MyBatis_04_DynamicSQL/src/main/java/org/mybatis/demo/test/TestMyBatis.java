package org.mybatis.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.demo.mapper.OrdersMapper;
import org.mybatis.demo.po.Orders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestMyBatis {

	private SqlSessionFactory sessionFactory;


	public void createSqlSessionFactory() throws IOException {
		//引入配置文件
		String resource = "SqlMapConfig.xml";
		InputStream ins = Resources.getResourceAsStream(resource);
		
		//创建SqlSession对象
		sessionFactory = new SqlSessionFactoryBuilder().build(ins);
	}

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void test1() throws IOException {
		createSqlSessionFactory();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			OrdersMapper mapper = session.getMapper(OrdersMapper.class);
			List<Orders> list = mapper.findOrdersUserLazyLoading();
			for(Orders order : list){
				System.out.println(order.getUser().getUsername() + " 在 " +order.getCreatetime() + " 提交了订单");
			}
		} finally {
			if(session != null){
				session.close();
			}
		}
	}

}
