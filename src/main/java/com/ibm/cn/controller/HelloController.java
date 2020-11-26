package com.ibm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.ibm.cn.entity.Employee;
import com.ibm.cn.service.EmployeeService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

@Controller
public class HelloController {
	
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("tologin")
    public String index(){
        
        return "login";
    }
	
//	@RequestMapping("/test")
//	public List<Employee> test(Model model) {
//		List<Employee> emps = employeeService.findAllEmp();
//		HashMap<String,List<Employee>> fr = new HashMap<String,List<Employee>>();
//		JSONArray json = JSONArray.fromObject(fr);
//		System.out.println(json);
//		model.addAttribute("json", json);
//		model.addAttribute("emps", emps);
//		System.out.println(emps);
//		
//		return json;
//	}
//
//	@RequestMapping("/list")
//	@ResponseBody
//    public Layui list(Model model){
//        //查询列表数据
//		PageHelper.startPage(1, 2);
//		List<Employee> emps = employeeService.findAllEmp();;
//		
//		return Layui.data(1000, emps);
//    }
}
