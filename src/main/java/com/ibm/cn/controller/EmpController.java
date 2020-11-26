package com.ibm.cn.controller;

import java.util.List;

import javax.xml.crypto.dsig.keyinfo.PGPData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.ibm.cn.entity.Employee;
import com.ibm.cn.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmployeeService employeeService;
	
	//查找所有员工返回主页面展示
	@GetMapping("/findAllEmp")
	public String getAllEmp(Model model) {
		PageHelper.startPage(1, 10);
		List<Employee> emps = employeeService.findAllEmp();
		
		model.addAttribute("emps", emps);
		System.out.println(emps);
		return "show";
	}
	
	//插入员工
	@PostMapping("/insertEmp")
	public String insertEmp(@RequestParam("name") String name,
							@RequestParam("age") Integer age,
							@RequestParam("salary") double salary) {
		System.out.println(name+age+salary);
		Employee emp = new Employee();
		emp.setAge(age);
		emp.setName(name);
		emp.setSalary(salary);
		employeeService.inserEmp(emp);
		
		return "redirect:findAllEmp";
	}
	
	//删除员工
	@GetMapping("/del/{id}")
	public String delEmp(@PathVariable Integer id) {
		employeeService.delEmp(id);
		return "redirect:../findAllEmp";
	}
	
	//更新员工
	@PostMapping("/updataEmp")
	public String updataEmp(@RequestParam("id") Integer id,
							@RequestParam("name") String name,
							@RequestParam("age") Integer age,
							@RequestParam("salary") double salary) {
		Employee emp = new Employee();
		emp.setAge(age);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setId(id);
		System.out.println(emp);
		employeeService.updataEmp(emp);
		return "redirect:/emp/findAllEmp";
	}
	
	//去到添加页面
	@GetMapping("/toAddEmp")
	public String toAddEmp() {
		return "addEmp";
	}
	
	//去到编辑页面
	@GetMapping("/toUpdataEmp/{id}")
	public String toUpdataEmp(@PathVariable Integer id,
							  Model model) {
		Employee employee= employeeService.getEmpById(id);
		model.addAttribute("emp", employee);
//		System.out.println(employee);
		return "editEmp";	
	}
	
	//分页查询返回首页
	@GetMapping("/findByPage/{page}")
	public String findByPage(Model model,@PathVariable Integer page) {
		PageHelper.startPage(page, 10);
		List<Employee> emps = employeeService.findAllEmp();
		model.addAttribute("emps", emps);
		return "show";
	}
	
	//根据名字模糊查询
	@PostMapping("/findByName")
	public String findEmpByName(Model model,
								@RequestParam("name")String name) {
		List<Employee> emps = employeeService.getEmpByName("%"+name+"%");
		model.addAttribute("emps", emps);
		return "show";
	}
	
}	
