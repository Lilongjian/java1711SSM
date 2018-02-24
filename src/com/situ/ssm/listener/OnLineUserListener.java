package com.situ.ssm.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.situ.ssm.entity.User;

@Component("onLineUserListener")
public class OnLineUserListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		    System.out.println("悟空888888888");
          	List<User> onLineUserList = new ArrayList<User>();
          	ServletContext servletContext = sce.getServletContext();
          	servletContext.setAttribute("onLineUserList", onLineUserList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}



}
