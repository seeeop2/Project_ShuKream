<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
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
	<script>
		function fn_overlapped() {
			
			var email = $("#user_email").val();
			
			if(email == ''){
				alert("이메일을 입력해주세요");
			return;
			}
			$.ajax({
				type:get,
				async:false,
				url:"${contextPath}/member/overlapped.do",
				dataType:"text",
				data:{email:email},
				success:function (data,textStatus){
					if(data=='false'){
						alert("사용할 수 있는 이메일입니다.");
						$('#checkBtn').prop("disabled", true);
						$('#user_email').prop("disabled", true);
					}else{
						alert("사용할 수 없는 이메일입니다.");
					}
				},
				error:function(data,textStatus){
					alert("에러가 발생했습니다.");
				},
				complete:function(data,textStatus){
				}
			});
		}
	</script>
</head>
<body>

<div class="addMem" style="text-align: center">
	<form action="${contextPath}/member/addMemberForm.do" method= "get" style="display: inline-block;">
		<table>
			<tr class="add" style="position: relative; top: 40px;">	
				<td class="join">이메일</td>
				<td>
					<input type="text" name="user_email" id="user_email" size="20" placeholder="이메일을 입력해주세요">
					<input type="hidden" name="email" id="email" value="">
					
					<input type="button" id="checkBtn" value="중복확인" onClick="fn_overlapped()"/>
				</td>
			</tr>
			<tr class="add" style="position: relative; top: 60px;">
				<td class="join">비밀번호</td>
				<td><input type="password" name="user_pw" size="20" placeholder="비밀번호를 입력해주세요"></td>
			</tr>
			<tr class="add" style="position: relative; top: 80px;">
				<td class="join">이름</td>
				<td><input type="text" name="user_name" size="20" placeholder="이름을 입력해주세요"></td>
			</tr>
			<tr class="add">
				
					<td><input type="submit" id="addBtn" value="회원가입"></td>
					<td><input type="reset" id="resetBtn" value="다시입력"></td>
				</td>
			</tr>
		</table>
	</form>
</div>
	
</body>
</html>