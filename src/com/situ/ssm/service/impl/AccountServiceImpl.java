package com.situ.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.ssm.dao.AccountDao;
import com.situ.ssm.service.IAccountService;
@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	private AccountDao accountDao;

	@Override
	public void transfer(Integer fromAccountId, Integer toAccountId, Integer money) {
		accountDao.decreaseMoney(fromAccountId,money);
		int t = 8/0;
		accountDao.increaseMoney(toAccountId,money);
		      
	}

}
