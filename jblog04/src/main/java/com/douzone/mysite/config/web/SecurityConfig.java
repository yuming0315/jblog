package com.douzone.mysite.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.douzone.jblog.security.CheckMineInterceptor;
import com.douzone.jblog.security.LoginInterceptor;
import com.douzone.jblog.security.LogoutInterceptor;

@Configuration
public class SecurityConfig implements WebMvcConfigurer{
	
	//Interceptors
	//매핑은 없고 인터셉터만 있는 경우, 인터셉터 작동 안할 수 있음
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/user/auth");
		registry.addInterceptor(logoutInterceptor()).addPathPatterns("/user/logout");
		registry.addInterceptor(checkMineInterceptor())
		.addPathPatterns("/*/write","/*/edit","/*/post","/*/category","/*/deleteCategory/*");
	}
	
	@Bean
	public HandlerInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

	@Bean
	public HandlerInterceptor logoutInterceptor() {
		return new LogoutInterceptor();
	}
	@Bean
	public HandlerInterceptor checkMineInterceptor() {
		return new CheckMineInterceptor();
	}
	
}
