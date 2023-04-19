<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8");
   String contextPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Insert title here</title>

<link rel="stylesheet" href="<%=contextPath%>/resources/css/member/addMember.css">

<style>
#footer{
    top: 380px;
    position: relative;
}
a:hover{
	color: white;
	background-color: black;
	text-decoration: none;
}
</style>

</head>
<body>

<div class="addMem" style="text-align: center">

	<form action="<%=contextPath%>/member/addMember.do" method= "post" style="display: inline-block;">
		
		<div class="accordion" id="accordionExample">
			
			<div class="row justify-content-lefts" align="center"
				style=" margin-left: 10px;">
				<h2>이용약관</h2>
			</div>
			
			<div class="card">
				<div class="card-header" id="headingOne">
					<h2 class="mb-0">
						<button class="btn btn-link btn-block text-left" type="button"
							data-toggle="collapse" data-target="#collapseOne"
							aria-expanded="true" aria-controls="collapseOne" style="color: black";>
							[필수]이용약관 동의
						</button>
					</h2>
				</div>

				<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
					data-parent="#accordionExample">
					<div class="card-body"> 
						이 약관은 "회원" 개인 상호 간 또는 “제휴 사업자”와 “회원” 개인 간에 상품 등을 매매하는 것을 중개하고, "상품" 등에 관한 정보를 상호 교환할 수 있도록 크림 주식회사(이하 "회사"라 합니다)가 운영, 제공하는 SHUKREAM 서비스(이하 "서비스")에 대한 것으로 본 약관에서는 "서비스"의 이용과 관련하여 "회사"와 "회원"과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정합니다.
						이 약관에서 사용하는 용어의 정의는 다음 각 호와 같으며, 관계 법령 및 지침 등에 의합니다.
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingTwo">
					<h2 class="mb-0">
						<button class="btn btn-link btn-block text-left collapsed"
							type="button" data-toggle="collapse" data-target="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo" style="color: black";>
							[필수]개인정보취급방침 동의
						</button>
					</h2>
				</div>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionExample">
					<div class="card-body">
						회사(이하 "SHUKREAM" 또는 "서비스")는 서비스를 제공함에 있어 이용자의 개인정보보호를 중요하게 생각하며, 본 개인정보처리방침을 통하여 이용자의 개인정보 처리 현황을 알려드립니다.
						회원가입 시점에 이용자로부터 수집하는 개인정보는 아래와 같습니다.
						회원 가입 시 또는 이벤트 진행 및 경품 배송처리를 위해 이름, 이메일 주소, 비밀번호를 필수 항목으로 수집하며, 선택항목으로 이름, 이메일주소, 비밀번호, 신발 사이즈, 배송 주소, 카드 정보, 거래은행을 수집합니다.
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center text-center">
			<div class="col-4">
				<input type="checkbox" name="agree" id="agree"> 위의 약관의 내용에 동의합니다.
				<p id="agreeInput"></p>

			</div>
		</div>
		
		<input type="hidden" name="seller_level_id" value="1" />
		
		<div id="tb" style="position: relative; left: 210px;">
		<table>
			<tr class="add" style="position: relative; top: 40px;">	
				<td class="join">이메일</td> 
				<td>
					<input type="text" name="user_email" id="user_email" size="30" placeholder="이메일을 입력해주세요" />
					<input type="button" id="checkBtn" value="중복확인"/>
					<p id="emailInput"></p>
				</td>
			</tr>
			
			<tr class="add" style="position: relative; top: 50px;">
				<td class="join">이름</td>
				<td>
				<input type="text" name="user_name" id="user_name" size="30" placeholder="이름을 입력해주세요"/>
				<p id="nameInput"></p>
				</td>
			</tr>
			
			<tr class="add" style="position: relative; top: 60px;">
				<td class="join">비밀번호</td>
				<td>
				<input type="password" name="user_pw" id="user_pw" size="30" placeholder="영문, 숫자, 특수문자 조합 6자 이상">
				<p id="pwInput"></p>
				</td>
			</tr>
			
			<tr class="add">
				<td><a href="#"
					   onclick="check(); return false;" 
					   type="button" 
					   style="text-decoration: none;"
					   class="btn btn-outline-warning";
					   id="joinBtn";
					>회원가입</a></td>
			</tr>
		</table>
		</div>
	</form>
</div>

<script src="<%=contextPath%>/resources/js/member.js"></script>
</body>
</html>