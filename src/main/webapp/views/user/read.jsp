<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div id="wrap">
    	<h1>회원정보</h1>
    	
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    	<form action="${contextPath}/user/edit.do">
    		<fieldset>
    			<legend>내용보기</legend>
    			<ul>
    				<li><input type="text" name="userid" value="${dto.userid}" readonly /></li>
    				<li>
    				    <label for="password">비밀번호</label>
    				    <input type="password" id="password" name="password" />
    				</li>
    				<li>
    				    <label for="name">이름</label>
    				    <input type="text" id="name" name="name" value="${dto.name}" />
    				</li>
    				<li>
    				    <label for="role">권한</label>
    				    <select id="role" name="role">
    				        <option value="Admin" ${dto.role eq "Admin" && "selected"}>관리자</option>
    				        <option value="Guest" ${dto.role eq "Guest" && "selected"}>방문자</option>
    				        <option value="User" ${dto.role eq "User" && "selected"}>사용자</option>
    				    </select>
    				</li>
    			</ul>
    		</fieldset>
			<p>
			  <button class="confirm">수정</button>
			</p>
    	</form>

        <p>
	        <a href="${contextPath}/views/user/regist.jsp">회원등록</a> <br />
	        <a href="${contextPath}/user/delete.do?userid=${dto.userid}">회원삭제</a> <br />
	        <a href="${contextPath}/user/list.do">회원목록</a>      	
        </p>
    </div>
    <script>
        const $password = document.getElementById('password');
        const $btnConfirm = document.querySelector('.confirm');
        
        $btnConfirm.addEventListener('click', function(evt){
        	evt.preventDefault();
        	
        	const password = $password.value.trim();
        	
        	if(password === null || password === ""){
                alert("패스워드를 입력하세요");
                $password.focus();
                return false;
        	}
        	
        	document.querySelector('form').submit();

        });
    </script>
</body>
</html>