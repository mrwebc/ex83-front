<%@page import="com.study.jsp.srv.BoardService"%>
<%@page import="com.study.jsp.conf.Factory"%>
<%@page import="com.study.jsp.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>

<body>
	<div id="wrap">
		<h1>회원목록</h1>

		<table style="text-align:center;">
		  <caption>프론트 컨트롤러</caption>
		  <colgroup>
		  	<col />
		  	<col />
		  	<col style="width:100px;" />
		  	<col style="width:100px"/>
		  	<col style="width:70px"/>
		  </colgroup>
		  <thead>
			<tr>
				<th scope="col">num</th>
				<th scope="col">userid</th>
				<th scope="col">password</th>
				<th scope="col">nickname</th>
				<th scope="col">role</th>
			</tr>	
		  </thead>
		  <tbody>
		  
              <c:set var="contextPath" value="${pageContext.request.contextPath}" />
		      <c:forEach items="${list}" var="dto" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td><a href="${contextPath}/user/read.do?userid=${dto.userid}">${dto.userid}</a></td>
					<td>${dto.password}</td>
					<td>${dto.name}</td>
					<td>${dto.role}</td>
				</tr>
		      </c:forEach>
		  </tbody>
		</table>
		<p><a href="${contextPath}/views/user/regist.jsp">회원등록</a></p> 
		<p><a href="${contextPath}/user/logout.do">로그아웃</a></p> 
	</div>
</body>
</html>



