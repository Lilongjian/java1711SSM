package com.situ.ssm.service;

import com.situ.ssm.entity.User;

public interface IUserService {

	User login(String name, String password);

}
