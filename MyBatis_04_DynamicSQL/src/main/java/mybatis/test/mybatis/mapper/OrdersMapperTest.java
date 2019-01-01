/**
 * 
 */
package mybatis.test.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import mybatis.mapper.OrdersMapper;
import mybatis.po.Orders;
import mybatis.po.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class OrdersMapperTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	// 创建工厂
	@Before
	public void init() throws IOException {

		// 配置文件（SqlMapConfig.xml）
		String resource = "SqlMapConfig.xml";

		// 加载配置文件到输入 流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void findOrderUserListResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建mapper代理对象
		OrdersMapper ordersMapper = sqlSession.
				getMapper(OrdersMapper.class);
		
		//调用方法
		List<Orders> list = ordersMapper.findOrderUserListResultMap();
		
		System.out.println(list);

	}

	@Test
	public void findOrderAndOrderdetail() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建mapper代理对象
		OrdersMapper ordersMapper = sqlSession.
				getMapper(OrdersMapper.class);
		
		//调用方法
		List<Orders> list = ordersMapper.findOrderAndOrderdetail();
		
		System.out.println(list);

	}
	
	@Test
	public void findUserOrderDetail() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建mapper代理对象
		OrdersMapper ordersMapper = sqlSession.
				getMapper(OrdersMapper.class);
		
		//调用方法
		List<User> list = ordersMapper.findUserOrderDetail();
		
		System.out.println(list);

	}
	
	
	@Test
	public void findUserOrderItems() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建mapper代理对象
		OrdersMapper ordersMapper = sqlSession.
				getMapper(OrdersMapper.class);
		
		//调用方法
		List<User> list = ordersMapper.findUserOrderItems();
		
		System.out.println(list);

	}
	
	//一对一延迟
	@Test
	public void testFindOrderUserListLazyLoading() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建mapper代理对象
		OrdersMapper ordersMapper = sqlSession.
				getMapper(OrdersMapper.class);
		
		//调用方法
		List<Orders> list = ordersMapper.findOrderUserListLazyLoading();
		
		User user = list.get(0).getUser();
		
		System.out.println(user);

	}
}
