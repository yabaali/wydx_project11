package com.ibm.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm.cn.entity.Employee;

@Mapper
public interface EmployeeMapper {
	//查询所有的员工信息
	public List<Employee> getAllEmp();
	
	//插入员工
	public int insertEmp(Employee emp);
	
	//删除员工
	public int delEmp(Integer id);
	
	//更新员工信息
	public int updataEmp(Employee emp);
	
	//根据id查询员工信息
	public Employee getEmpById(Integer id);
	
	//根据名字查员工
	public List<Employee> getEmpByName(String name);
	
	
}
