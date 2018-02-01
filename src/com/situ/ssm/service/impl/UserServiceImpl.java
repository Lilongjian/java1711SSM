package com.situ.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.ssm.dao.UserDao;
import com.situ.ssm.entity.User;
import com.situ.ssm.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User login(String name, String password) {
		return userDao.login(name,password);
	}

}
