package com.ibm.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cn.entity.User;
import com.ibm.cn.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public int addUser(User user) {
		return userMapper.addUser(user);
	}
	
	public User findUser(String username,String password) {
		return userMapper.findUser(username, password);
	}
}
