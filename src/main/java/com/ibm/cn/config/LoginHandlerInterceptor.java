package com.ibm.cn.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.cn.entity.User;

public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			// 统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				return true;
			}
			response.sendRedirect(request.getContextPath() + "/tologin");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
		// 如果设置为true时，请求将会继续执行后面的操作
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// System.out.println("执行了postInterceptor的postHandle方法");
	}
}
