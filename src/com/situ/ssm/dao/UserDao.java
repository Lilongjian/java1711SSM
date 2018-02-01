package com.situ.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.situ.ssm.entity.User;

public interface UserDao {

	User login(@Param(value="name")String name, @Param(value="password")String password);
	

}
