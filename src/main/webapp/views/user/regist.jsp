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
    	<h1>회원등록</h1>
    	
    	<form action="${pageContext.request.contextPath}/user/regist.do">
    		<fieldset>
    			<legend>정보입력</legend>
    			<ul>
    				<li>
    				    <label for="아아디">userid</label>
    				    <input type="text" id="userid" name="userid" />
                        <button class="chkid" type="button">중복확인</button> 
                        <span class="result"></span>
    				</li>
    				<li>
    				    <label for="password">비밀번호</label>
    				    <input type="password" id="password" name="password" />
    				</li>
    				<li>
    				    <label for="name">이름</label>
    				    <input type="text" id="name" name="name" />
    				</li>
    				<li>
    				    <label for="role">권한</label>
    				    <select id="role" name="role">
    				        <option value="Admin">관리자</option>
    				        <option value="Guest">방문자</option>
    				        <option value="User" selected>사용자</option>
    				    </select>
    				</li>
    			</ul>
    		</fieldset>
			<p>
			  <button class="confirm" disabled>확인</button>
			</p>
    	</form>
    </div>
    <script>
        const $userid = document.getElementById('userid');
        const $btnConfirm = document.querySelector('.confirm');
        const $result = document.querySelector('.result');
        const $chkid = document.querySelector('.chkid');
        
        $chkid.addEventListener('click', function(){
        	const userid = $userid.value.trim();
        	if(userid === null || userid === ""){
                alert("아이디를 입력하세요");
                $userid.focus();
                return false;
        	}

            $.ajax({
                type:"post",
                dataType:"text",//응답데이터 타입
                async:true,//비동기로 설정
                url : "${pageContext.request.contextPath}"+"/user/chkid",
                data : {userid:userid},
                success : function(data, status){
                    
                    console.log(data);//string 0, 1
                    
                    if(data==0){
                        $result.textContent = "사용가능한 ID입니다.";
                        $(".confirm").prop("disabled", false);
                    }else{
                    	$result.textContent = "사용할 수 없는 ID입니다.";
                    }
                },//end of success,
				
				 //통신이 실패했을 때
				 error : function(data, status) {
				 $result.textContent = "통신결과 : 에러발생";
				},
				
				 //작업완료후 무조건 실행
				 complete : function() {
				 console.log('작업을 완료했습니다.');
				}
            });//end of ajax  
        });
    </script>
</body>
</html>