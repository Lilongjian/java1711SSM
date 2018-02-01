package com.situ.ssm.Filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginFilter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
            System.out.println("LoginFilter.afterCompletion()");		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		    System.out.println("LoginFilter.postHandle()");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		   System.out.println("你是小可爱");
		   HttpServletRequest req = (HttpServletRequest) request;
		   HttpServletResponse resp = (HttpServletResponse) response;
		   String servletPath = req.getServletPath();
		   System.out.println("获取数据" + servletPath);
		   int lastIndex = servletPath.lastIndexOf(".");
		   String extension = "";
		   if (lastIndex != -1) {
			extension = servletPath.substring(lastIndex);
			System.out.println("截取的" + extension);}
		   if ("/login".equals(servletPath)
				   || "/checkImg".equalsIgnoreCase(servletPath)
				   || ".js".equalsIgnoreCase(extension)
				   || ".css".equalsIgnoreCase(extension)
				   || ".action".equals(extension)) {
			       
				return true;
			}else{
				HttpSession session = req.getSession();
				Object user = session.getAttribute("user");
				System.out.println("346" + user);
				if (user == null) {
					req.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp").forward(request, response);
					return false;
			}
		}
		return true;
	}

}
