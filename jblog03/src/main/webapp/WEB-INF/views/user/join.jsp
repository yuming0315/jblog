<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>

		<c:import url="/WEB-INF/views/includes/menu.jsp" />

		<form class="join-form" id="join-form" method="post"
			action="${pageContext.request.contextPath}/user/join">
			<label class="block-label" for="name">이름</label> <input id="name"
				name="name" type="text" value="${requestScope.user.name }"> <label
				class="block-label" for="blog-id">아이디</label> <input id="blog-id"
				name="id" type="text" value="${requestScope.user.id }"> <input
				id="btn-checkemail" type="button" value="id 중복체크"> <img
				id="img-checkemail" style="display: none;"
				src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label> <input
				id="password" name="password" type="password" value="${requestScope.user.password }"/>

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>
			<c:if test="${not empty requestScope.user }">
				<p>가입에 실패 했습니다. 정보를 모두 기입해 주세요.</p>
			</c:if>
			<input type="submit" value="가입하기">

		</form>
	</div>
</body>
</html>
