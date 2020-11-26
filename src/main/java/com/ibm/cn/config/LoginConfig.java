package com.ibm.cn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器
		LoginHandlerInterceptor loginInterceptor = new LoginHandlerInterceptor();
		InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
		// 拦截路径
		loginRegistry.addPathPatterns("/emp/*");
		// 排除路径
		loginRegistry.excludePathPatterns("/");
		loginRegistry.excludePathPatterns("/login");
		// 排除资源请求
		loginRegistry.excludePathPatterns("/css/login/*.css");
		loginRegistry.excludePathPatterns("/js/login/**/*.js");
	}

}
