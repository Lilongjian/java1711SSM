package com.situ.ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.ssm.entity.User;
import com.situ.ssm.service.IUserService;
import com.situ.ssm.service.impl.UserServiceImpl;

@Controller
@RequestMapping(value="/login")
public class LoginServlet extends HttpServlet{
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/getLoginPage")
	public void getLoginPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp").forward(request, response);
	}
	@RequestMapping(value="/getOnLinePage")
	public void getOnLinePage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/jsp/online_user_list.jsp").forward(request, response);
	}
	@RequestMapping(value="/signIn")
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    String checkCode = req.getParameter("checkCode");
		   String checkCodeSession = (String) req.getSession().getAttribute("checkCodeSession");
		   if (checkCode == null 
				   || "".equals(checkCode)
				   || !checkCode.equalsIgnoreCase(checkCodeSession)) {
			   resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
			   return;
		   }
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		User user = userService.login(name, password);
		System.out.println(user);
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			List<User> list = (List<User>) req.getServletContext().getAttribute("onLineUserList");
			list.add(user);
			resp.sendRedirect(req.getContextPath() + "/student/searchByCondition.action");
			return;
		}else {
			resp.sendRedirect(req.getContextPath() + "/login/getLoginPage.action");
		}
	}
	@RequestMapping(value="/logout")
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user  = (User) session.getAttribute("user");
		session.removeAttribute("user");
		List<User> list = (List<User>) req.getServletContext().getAttribute("onLineUserList");
		list.remove(user);
		resp.sendRedirect(req.getContextPath() + "/login/getLoginPage.action");
	}
}
