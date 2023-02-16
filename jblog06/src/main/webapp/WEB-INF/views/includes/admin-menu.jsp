<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<ul class="admin-menu">
	<li class="selected">기본설정</li>
	<li><a
		href="${pageContext.request.contextPath}/${authUser.id}/category">카테고리</a></li>
	<li><a
		href="${pageContext.request.contextPath}/${authUser.id}/write">글작성</a></li>
</ul>