<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>

.footer{
    top: 380px;
    position: relative;
}
.addMem{
	position: relative;
	top: 120px;
}
#checkBtn{
	color: white;
    background: black;
}
#addBtn{
	color: white;
    background: black;
    position: relative;
    top: 110px;
    left: 100px;
}
#resetBtn{
	color: white;
    background: black;
    position: relative;
    top: 110px;
    left: 130px;
}
</style>

</head>
<body>

<div class="addMem" style="text-align: center">
	<form action="${contextPath}/member/addMember.do" method= "post" style="display: inline-block;">
		<input type="hidden" name="seller_level_id" value="1" />
		<table>
			<tr class="add" style="position: relative; top: 40px;">	
				<td class="join">이메일</td>
				<td>
					<input type="text" name="user_email" id="user_email" size="20" placeholder="이메일을 입력해주세요" />
					<input type="button" id="checkBtn" value="중복확인" onClick="fn_overlapped()"/>
				</td>
			</tr>
			<tr class="add" style="position: relative; top: 60px;">
				<td class="join">비밀번호</td>
				<td><input type="password" name="user_pw" size="20" placeholder="비밀번호를 입력해주세요"></td>
			</tr>
			<tr class="add" style="position: relative; top: 80px;">
				<td class="join">이름</td>
				<td><input type="text" name="user_name" size="20" placeholder="이름을 입력해주세요" /></td>
			</tr>
			
			
			<tr class="add">
				<td><input type="submit" id="addBtn" value="회원가입" /></td>
					<td><input type="reset" id="resetBtn" value="다시입력" /></td>
			</tr>
		</table>
	</form>
</div>
	
</body>
</html>