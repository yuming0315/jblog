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
	<div id="container">
		<c:import url="/WEB-INF/views/includes/mainHeader.jsp" />
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${blog.title }</h4>
					<p></p>
				</div>
				<ul class="blog-list">


					<c:forEach items="${requestScope.latestPost }" var="vo">
						<li><a
							href="${pageContext.request.contextPath}/${authUser.id}/${vo.category_no }/${vo.no}">${vo.title }</a>
							<span>${vo.reg_date }</span></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img
					src="${pageContext.request.contextPath}${empty blog.profile ? '/assets/images/spring-logo.jpg':blog.profile}">
			</div>
		</div>

		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />

	</div>
</body>
</html>