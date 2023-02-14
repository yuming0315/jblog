package com.douzone.mysite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.douzone.mysite.config.app.DBConfig;
import com.douzone.mysite.config.app.MyBatisConfig;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.douzone.jblog.repository",
	"com.douzone.jblog.service","com.douzone.jblog.aspect",
	"com.douzone.jblog.exception"})
@Import({DBConfig.class,MyBatisConfig.class})
public class AppConfig {
	
}
