package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	//多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
	//@MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
	@MapKey("lastName")
	public Map<String, Employee> getEmpByLastNameLikeReturnMap(String lastName);
	
	//返回一条记录的map；key就是列名，值就是对应的值
	public Map<String, Object> getEmpByIdReturnMap(Integer id);

	// 在接口中定义返回list，则会将sql的返回值封装成对象后，再包装成list返回
	public List<Employee> getEmpsByLastNameLike(String lastName);

	// 通过key-value即map形式, 在key中指定对应#{id}去取
	public Employee getEmpByMap(Map<String, Object> map);

	// 显示的通过param制定参数，告诉xml通过#{id}去取
	public Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);
	
	public Employee getEmpById(Integer id);

	// 通过传对象pojo的形式，那么对象的属性一定要在xml中的sql#{id}有对应
	public Long addEmp(Employee employee);

	public boolean updateEmp(Employee employee);

	public void deleteEmpById(Integer id);
	
}
