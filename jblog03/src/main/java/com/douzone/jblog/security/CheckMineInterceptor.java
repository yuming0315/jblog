package com.douzone.jblog.security;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import com.douzone.jblog.vo.UserVo;

public class CheckMineInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println(request.getMethod()); //get방식인지 post방식인지
		Map<?, ?> pathVariables = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		UserVo user = (UserVo)request.getSession().getAttribute("authUser");
		if(user == null) {
			request.setAttribute("id", pathVariables.get("id"));
			request.getRequestDispatcher("/WEB-INF/views/user/login.jsp")
			.forward(request, response);
			return false;
		}
		if(!user.getId().equals(pathVariables.get("id"))) {
			request.getRequestDispatcher("/WEB-INF/views/main/index.jsp")
			.forward(request, response);
			return false;
		}
		return true;
	}
	
}
