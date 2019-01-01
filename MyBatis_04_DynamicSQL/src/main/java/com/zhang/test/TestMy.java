package com.zhang.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zhang.dao.OrdersDao;
import com.zhang.dao.UserDao;
import com.zhang.domain.Orders;
import com.zhang.domain.User;

public class TestMy {
	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	

	@Test
	public void findOrdersUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
		List<Orders> list=ordersDao.findOrdersUserLazyLoading();
		for (Orders orders : list) {
		User user=	orders.getUser();
		}
		System.out.println(list.size());
	}
	
	
	// 一级缓存测试
		@Test
		public void testCache1() throws Exception {
			SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			// 下边查询使用一个SqlSession
			// 第一次发起请求，查询id为1的用户
			User user1 = userDao.findUserById(1);
			System.out.println(user1);
			// 如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。
			// 更新user1的信息
			 user1.setUsername("测试用户22");
			 userDao.updateUser(user1);
			//执行commit操作去清空缓存
			 sqlSession.commit();
			// 第二次发起请求，查询id为1的用户
			User user2 = userDao.findUserById(1);
			System.out.println(user2);
			sqlSession.close();
		}

		
		// 二级缓存测试
		@Test
		public void testCache2() throws Exception {
			SqlSession sqlSession1 = sqlSessionFactory.openSession();
			SqlSession sqlSession2 = sqlSessionFactory.openSession();
			SqlSession sqlSession3 = sqlSessionFactory.openSession();
			UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
			// 第一次发起请求，查询id为1的用户
			User user1 = userDao1.findUserById(1);
			System.out.println(user1);
			//这里执行关闭操作，将sqlsession中的数据写到二级缓存区域
			sqlSession1.close();
			
			//使用sqlSession3执行commit()操作
			UserDao userDao3 = sqlSession3.getMapper(UserDao.class);
			User user  = userDao3.findUserById(1);
			user.setUsername("张明明");
			userDao3.updateUser(user);
			//执行提交，清空UserMapper下边的二级缓存
			sqlSession3.commit();
			sqlSession3.close();
			
			UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
			// 第二次发起请求，查询id为1的用户
			User user2 = userDao2.findUserById(1);
			System.out.println(user2);
			sqlSession2.close();
		}
	
}
