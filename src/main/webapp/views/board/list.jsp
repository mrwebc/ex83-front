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
		<h1>글목록</h1>
		<p>${name}님 환영합니다~!</p>

		<table style="text-align:center;">
		  <caption>프론트 컨트롤러 - 게시판</caption>
		  <colgroup>
		  	<col />
		  	<col />
		  	<col style="width:100px;" />
		  	<col style="width:100px"/>
		  	<col style="width:70px"/>
		  </colgroup>
		  <thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">닉네임</th>
				<th scope="col">등록일</th>
				<th scope="col">조회수</th>
			</tr>	
		  </thead>
		  <tbody>
		  
              <c:set var="contextPath" value="${pageContext.request.contextPath}" />
		      <c:forEach items="${list}" var="bVo">
				<tr>
					<td>${bVo.seq}</td>
					<td><a href="${contextPath}/board/read.do?seq=${bVo.seq}">${bVo.title}</a></td>
					<td>${bVo.nickname}</td>
					<td>${bVo.regdate}</td>
					<td>${bVo.cnt}</td>
				</tr>
		      </c:forEach>
		  </tbody>
		</table>
		<p><a href="${contextPath}/views/board/write.jsp">새글 등록</a></p> 
		<p><a href="${contextPath}/user/logout.do">로그아웃</a></p> 
	</div>
</body>
</html>



