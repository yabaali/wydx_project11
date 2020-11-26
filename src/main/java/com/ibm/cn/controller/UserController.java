package com.ibm.cn.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.ibm.cn.entity.Employee;
import com.ibm.cn.entity.User;
import com.ibm.cn.service.EmployeeService;
import com.ibm.cn.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("username") String username,
			@RequestParam("realname") String realname,
			@RequestParam("sex") String sex,
			@RequestParam("password") String password,
			Model model) {
		System.out.println(username);
		System.out.println(realname);
		System.out.println(password);
		System.out.println(sex);
		User user = new User();
		user.setPassword(password);
		user.setSex(sex);
		user.setUsername(username);
		user.setRealname(realname);
//		先在数据库中查看该用户是否存在，存在则不可注册，不存在则注册
		User u = userService.findUser(user.getUsername(), user.getPassword());
		if(u==null) {
			userService.addUser(user);
			System.out.println("添加成功！");
			return "login";
		}else {
			System.out.println("该用户已存在");
			model.addAttribute("error", "该用户已存在！");
			return "regist1";
		}
		
	}
	
	@PostMapping("/login")
	public String userlogin(@RequestParam("username") String username,
							@RequestParam("password") String password,
							HttpSession session,
							Model model) {
		//查询出所有的员工信息
		PageHelper.startPage(1, 10);
		List<Employee> emp = employeeService.findAllEmp();
		User u = userService.findUser(username,password);
		System.out.println(u);
		if(u!=null) {
			session.setAttribute("user", u);
			model.addAttribute("emps", emp);
			model.addAttribute("user", u);
			return "show";
		}else {
			model.addAttribute("error", "用户名或密码错误");
			return "login";
		}
	}
	
	//去到注册页面
	@GetMapping("/toRegist")
	public String toRegist() {
		return "regist";
	}
	
	
	
	
}
