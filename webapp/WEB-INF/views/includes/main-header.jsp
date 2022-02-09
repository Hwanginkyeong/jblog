<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<!-- 메인 로고 이미지를 링크하세요 logo.jpg -->
	 	<a href="${pageContext.request.contextPath}/">
			<img class="logo" src="/jblog/assets/image/logo.jpg">
		</a>
	
	<div id="main-header" class="clearfix">
 		<c:choose>
 			<c:when test="${empty sessionScope.authUser}">
 				<!-- 로그인 실패, 로그인 전 -->
 				<ul class="menu">
	 				<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/user/joinForm">회원가입</a></li>
 				</ul>
 			</c:when>
 			<c:otherwise>
 				<!-- 로그인 성공 -->
 				<ul class="menu">
	 				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<li><a href="">내블로그</a></li>	
				</ul>
 			</c:otherwise>
 			
 		</c:choose>
 		
 	</div>