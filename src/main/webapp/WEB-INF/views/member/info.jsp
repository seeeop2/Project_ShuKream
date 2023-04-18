<%@page import="com.shukream.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<%request.setCharacterEncoding("UTF-8");
  String contextPath = request.getContextPath();%>    

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
				font-weight: bold;"	
				>회원 정보</p>
			</div>
			<dl class="teble">

				<dt class="dt">
					<span>이름</span>
				</dt>
				<dd class="dd">
					<div>
						<p></p>
					</div>
				</dd>			
			</div>
				
	
	<div class="saveBtn">
						<a id="backBtn" href="<%=request.getContextPath()%>/member/mypage.do?center=/nbMember/mypage.jsp" class="roundBtn whiteBtn">뒤로가기</a>				
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="changeBtn" href="#<%-- <%=contextPath%>/member/changeInfo.do --%>" class="roundBtn blueBtn">수정하기</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						<button  id="delBtn" class="roundBtn blueBtn">회원탈퇴</button>
	</div>

	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 회원정보 수정 유효성 체크  -->
	<script src="<%=request.getContextPath()%>/js/change.js"></script>
	
</body>
</html>