package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/join",method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/join",method = RequestMethod.POST)
	public String join(UserVo user, Model model) {
		if(!userService.insertUser(user)) {
			model.addAttribute("user",user);
			return "user/join";
		}
		model.addAttribute("user",user);
		return "user/joinsuccess";
	}
	
	
	@RequestMapping(value="/joinsuccess",method = RequestMethod.GET)
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	@RequestMapping("/auth")
	public void auth() {
	}
	
	@RequestMapping("/logout")
	public void logout() {
	}
}
