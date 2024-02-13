<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>

<link rel="stylesheet" href="css/style.css" />

</head>
<body>
    <div id="wrap">
        <h1>프론트컨트롤러-게시판</h1>
        
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <c:if test="${empty userid}">
            <p><a href="./views/user/login.jsp">로그인</a></p>
            <p><a href="${contextPath}/user/list.do">회원목록</a></p>
            <p><a href="./views/user/regist.jsp">회원등록</a></p>
        </c:if>
        
        <c:if test="${!empty userid}">
            <p>
                <a href="${contextPath}/user/logout.do">로그아웃</a>
                <a href="${contextPath}/board/list.do">글 목록</a> | 
                <a href="./views/board/write.jsp">글 쓰기</a>
            </p>
        </c:if>
    </div>
</body>
</html>