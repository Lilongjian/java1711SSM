package com.situ.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.ssm.service.IAccountService;

@Controller
@RequestMapping(value="/account")
public class AccountController {
   @Autowired
   private IAccountService accountService;
   @RequestMapping(value="/transfer")
   public void transfer(Integer fromAccountId,Integer toAccountId,Integer money){
	   accountService.transfer(fromAccountId,toAccountId,money);
   }
}
