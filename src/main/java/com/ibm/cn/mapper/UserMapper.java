package com.ibm.cn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm.cn.entity.User;


@Mapper
public interface UserMapper {
	//插入用户
	public int addUser(User user);
	//查找用户
	public User findUser(@Param("username")String username,@Param("password")String password);
}
