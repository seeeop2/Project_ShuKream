<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
#footer{
    top: 380px;
    position: relative;
}
#detail_table{
<<<<<<< HEAD
   text-align: center;
   position: relative;
   top: 120px;
}
#logOn{
   position: relative;
    left: 5px;
}
#sub{
   position: relative;
    left: -10px;
    top: 30px;
    background: black;
    color: white;
}
#re{
   position: relative;
    left: 10px;
    top: 30px;
    background: black;
    color: white;
}
#sub:hover, #re:hover{
   background: white;
   color: black;
}
.find>a{
   color: black;
   font-weight: 100;
}
.find>a:hover{
   color: black;
   font-weight: bolder;
}
.find{
   position: relative;
    top: 100px;
}
.signTable{
   position: relative;
   top: 15px;
=======
	text-align: center;
	position: relative;
	top: 120px;
}
#logOn{
	position: relative;
    left: 5px;
}
#sub{
	position: relative;
    left: -10px;
    top: 30px;
    background: black;
    color: white;
}
#re{
	position: relative;
    left: 10px;
    top: 30px;
    background: black;
    color: white;
}
#sub:hover, #re:hover{
	background: white;
	color: black;
}
.find>a{
	color: black;
	font-weight: 100;
}
.find>a:hover{
	color: black;
	font-weight: bolder;
}
.find{
	position: relative;
    top: 100px;
}
.signTable{
	position: relative;
	top: 15px;
}

</style>

<c:if test='${not empty message }'>
<script>
window.onload=function()
{
  result();
}

function result(){
   alert("이메일 또는 비밀번호가 틀립니다. 다시 로그인해주세요");
}
</script>
</c:if>
</head>
<body>
	<DIV id="detail_table">
	<form action="${contextPath}/member/login.do" method="post" style="display: inline-block;">
		<H3>로그인</H3> <br>
		<TABLE class="signTable">
			<TBODY>
				<TR class="dot_line">
					<TD class="fixed_join">이메일</TD>
					<TD><input name="user_email" type="text" size="20" placeholder="이메일을 입력해주세요" id="logOn"/></TD>
				</TR>
				<TR class="solid_line">
					<TD class="fixed_join">비밀번호</TD>
					<TD><input name="user_pw" type="password" size="20" placeholder="비밀번호를 입력해주세요" id="logOn"/></TD>
				</TR>
			</TBODY>
		</TABLE>
		<br>
		<INPUT id="sub"	type="submit" value="로그인"> 
		<INPUT id="re" type="reset" value="다시입력">
		<br>
		<div class="find">
		   <a href="#">이메일 찾기</a>  | 
		   <a href="#">비밀번호 찾기</a> | 
		   <a href="${contextPath}/member/addMemberForm.do">회원가입</a>    | 
		   <a href="#">고객 센터</a>
		</div>			   
	</form>
	</DIV>	
</body>
</html>