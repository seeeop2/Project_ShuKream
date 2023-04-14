
$("#checkBtn").click(function(){
	var userEmail_val = $("#user_email").val();
	alert(userEmail_val);
	
	$.ajax(
        		{		
        				type:"post",
    					async:true, 
    					url:"http://localhost:8090/shuKream/member/emailCheck.do",
    					data:{ user_email : userEmail_val  },
    					dataType:"text", 
    					success : function(data){
    						if(data==0){
    							$('#emailInput').text("이메일 사용가능").css("color","blue");
    							
    						} else{
    							$('#emailInput').text("사용안됨").css("color","red");
    							alert("이메일을 다시 입력해주세요.");
    						}
    					},
    					error:function(data,textStatus){
    						alert("통신에러가 발생했습니다.");
    					}
    				}
    		); 
	});
	$("#user_email").focusout(function(){
	
		var email = $("#user_email");
		var emailValue = email.val();
		var emailReg = /^\w{5,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
		var rsEmail = emailReg.test(emailValue);
		
		if(!rsEmail){
			$("#emailInput").text("이메일 형식이 올바르지않습니다.").css("color","red");
		}else{
			$("#emailInput").text("이메일 사용 가능합니다.");
		}		
	});
	
	$("#user_pw").focusout(function(){
		var pw = $("#user_pw");
		var pwValue = pw.val();
		var pwReg = "^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$";
		var rsPw = pwReg.test(pwValue);
		
		if(!rsPw){
			$("#pwInput").text("영문, 숫자, 특수문자 조합 8자 이상으로 적어주세요").css("color","red");
		}else{
			$("#pwInput").text("비밀번호 사용 가능합니다").css("color","blue");
		}
	});
	

        	
		

	    
	    