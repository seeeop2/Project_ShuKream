<%@page import="com.shukream.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<%request.setCharacterEncoding("UTF-8");
  String contextPath = request.getContextPath();%>    

<%
	MemberVO memberVO =  (MemberVO)request.getAttribute("MemberVO");
   String email = memberVO.getUser_email();
   System.out.print("email:" + email);
   String name = memberVO.getUser_name();
   System.out.print("name:" + name);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=contextPath%>/resources/css/info.css">

<style>
#footer{
	position: relative;
    top: 380px;
}
</style>

</head>
<body>
	
	<div class="total" style="text-align: center">
		<hr>
		
		<div class="rightBlock">
			<div>
				<p class="title" 
					style="margin-bottom: 15px;
					font-weight: bold;">회원 정보</p>
			</div>
			
			<dl class="teble">
			
				<dt class="dt">
					<span>이메일</span>
				</dt>
				<dd class="dd">
					<div>
						<p><%=email%></p>
					</div>
				</dd>
				<br>
				<dt class="dt" style="position: relative; left: -720px; top: 40px;">
					<span>이름</span>
				</dt>
					<dd class="dd" style="position: relative; left: 203px; top: -10px;">
						<div>
							<p><%=name%></p>
					</div>
				</dd>			
			</dl>	
			
				
	<dd class="btn-dd">	
		<div class="saveBtn">
						<a id="backBtn" href="<%=request.getContextPath()%>/member/mypage.do?center=/nbMember/mypage.jsp" class="roundBtn whiteBtn">뒤로가기</a>				
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="changeBtn" href="<%=contextPath%>/member/updateMember.do?email=<%=email%>" class="roundBtn blueBtn">수정하기</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a  id="delBtn" href="<%=contextPath%>/member/delMember.do?email=<%=email%>" class="roundBtn blueBtn">회원탈퇴</a>
	  	</div>
	  </dd>	
</div>
</div>

	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>