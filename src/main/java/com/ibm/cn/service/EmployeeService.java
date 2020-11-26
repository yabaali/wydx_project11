package com.ibm.cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cn.entity.Employee;
import com.ibm.cn.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	//查询所有的员工
	public List<Employee> findAllEmp(){
		return employeeMapper.getAllEmp();
	}
	
	//插入一条员工的信息
	public int inserEmp(Employee emp) {
		return employeeMapper.insertEmp(emp);
	}
	
	//删除一条员工信息
	public int delEmp(Integer id) {
		return employeeMapper.delEmp(id);
	}
	
	//修改一条员工的信息
	public int updataEmp(Employee emp) {
		return employeeMapper.updataEmp(emp);
	}
	
	public Employee getEmpById(Integer id) {
		return employeeMapper.getEmpById(id);
	}
	
	//根据名字查员工
	public List<Employee> getEmpByName(String name) {
		return employeeMapper.getEmpByName(name);
	}
	
}
