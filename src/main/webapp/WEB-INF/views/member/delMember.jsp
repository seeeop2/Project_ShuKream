<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
   
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>

<style>
#footer{
	position: relative;
    top: 380px;
}
.all{
	text-align: center;
    top: 60px;
    position: relative;
}
.title{
	margin-bottom: 15px;
	font-weight: bold;
	font-size: 21px;
	position: relative;
	top: 10px;
}
.delMember{
	position: relative;
	top: 80px;
}
#email{
	position: relative;
	left: 15px;
}
#name{
	position: relative;
	left: 25px;
}
#pw{
	position: relative;
	left: 10px;
}
.btnDel{
	position: relative;
    top: 120px;
    left: 40px;
}
#delHome, #delBtn{
	background-color: black;
	color: white;
}
#delHome:hover, #delBtn:hover{
	background-color: white;
	color: black;
}
#delHome{
	position: relative;
	right: 10px;
}
#delBtn{
	position: relative;
	left: 17px;
}
</style>

</head>
<body>
	<form action="${contextPath}/member/delMemberpro.do" method="post">
		
		<div class="all">
			<div class="title">
				회원탈퇴
			</div>
			
			<hr>
			
			<div class="delMember">
				<c:forEach items="${delMember}" var="vo">
				<div class="email">
					<label for="email">이메일</label>
					<input type="text" id="email" name="email" value="${vo.user_email}" readonly/>
				</div>
				
				<div>
					<label for="name">이름</label>
					<input type="text" id="name" name="name" value="${vo.user_name}" readonly/>
				</div>
				
				<div>
					<label for="pw">비밀번호</label>
					<input type="password" id="pw" name="pw" value="${vo.user_pw}" readonly/>
				</div>
				</c:forEach>
			</div>	
			
				<div class="btnDel">	
					<div>
						<input type="button" id="delHome" onclick="location.href='${contextPath}/main.do'" value="홈으로"/>
						<input type="submit" id="delBtn" value="탈퇴완료"/>
					</div>
				</div>	
		</div>	
	</form>
</body>
</html>