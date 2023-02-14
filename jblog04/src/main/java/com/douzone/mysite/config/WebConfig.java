package com.douzone.mysite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.douzone.mysite.config.web.FileuploadConfig;
import com.douzone.mysite.config.web.MvcConfig;
import com.douzone.mysite.config.web.SecurityConfig;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.douzone.jblog.controller"})
@Import({MvcConfig.class, SecurityConfig.class,FileuploadConfig.class})
public class WebConfig implements WebMvcConfigurer{
	//Site Interceptor
//	@Bean
//	public HandlerInterceptor siteIterceptor() {
//		return new SiteInterceptor();
//	}
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(siteIterceptor())
//		.addPathPatterns("/**");
//	}
//	
//	@Bean
//	public ApplicationContextEventListener applicationContextEventListener() {
//		return new ApplicationContextEventListener();
//	}
	
}
