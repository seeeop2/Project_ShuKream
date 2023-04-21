<%@page import="com.shukream.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<c:set var="contextPath" value="${pageContext.request.contextPath}" />  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#footer{
	position: relative;
    top: 380px;
}
.update{
	text-align: center;
}
.namedt,.pwdt{
	position: relative;
	top: 50px;
	right: 130px;
}
.namedd,.pwdd{
	position: relative;
	top: 20px;
    left: 20px;
}

.all{
	position: relative;
	left: 30px;
    top: 80px;
}
.btn{
	position: relative;
    top: 30px;
    left: 20px;
}
#reBtn, #upBtn{
	background-color: black;
	color: white;
}
#reBtn:hover, #upBtn:hover{
	background-color: white;
	color: black;
}
</style>

</head>
<body>
	<form action="${contextPath}/member/updateMemberpro.do" method="post">
		<div class="update">
		<hr>
			<div class="all">	
			<div class="title">
				<h2>회원 수정</h2>
			</div>
			
			<div class="rightBlock">
				<dl class="teble">
				<c:forEach items="${updateMember}" var="vo">
					<div>
						<dt class="namedt">
							<span>이름</span>
						</dt>
							<dd class="namedd">
								<input type="text" id="name" name="user_name"  value="${vo.user_name}">
							</dd>
					</div>
					
					<div>
						<dt class="pwdt">
							<span>비밀번호</span>
						</dt>
							<dd class="pwdd">
								<input type="password" id="pw" name="user_pw" value="${vo.user_pw}">
							</dd>
					</div>
				</c:forEach>
				</dl>
			</div>
			
			<div class="btn">
				<input type="button" id="reBtn" value="홈으로" onclick="location.href='${contextPath}/main.do'"/>
				<input type="submit" id="upBtn" value="수정 완료" />
			</div>
			
		</div>
	</div>	
	</form>
	
</body>
</html>