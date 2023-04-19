
	$("#checkBtn").click(function(){
		var email = $("#user_email");
		var emailValue = email.val();
		var emailReg = /^\w{3,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
		var rsEmail = emailReg.test(emailValue);
	
			$.ajax(
        		{		
        				type:"post",
    					async:true, 
    					url:"http://localhost:8090/shuKream/member/emailCheck.do",
    					data:{ user_email : emailValue },
    					dataType:"text", 
    					success : function(data){
    						if(data==0){
    							$('#emailInput').text("이메일 사용가능합니다.").css("color","blue");
    							alert("이메일 사용가능합니다.");
    						} else{
    							$('#emailInput').text("중복되는 이메일입니다.").css("color","red");
    							alert("이메일을 다시 입력해주세요.");
    						}
    					},
    					error:function(data,textStatus){
    						alert("통신에러가 발생했습니다.");
    					}
    				}
    				
    		); 
	});
	
	$("#user_pw").focusout(function(){
	
		var pw = $("#user_pw");
		var pwValue = pw.val();
		var pwReg = (/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,}$/);
		var rsPw = pwReg.test(pwValue);
		
		if(!rsPw){
			$("#pwInput").text("비밀번호 형식이 올바르지않습니다.").css("color","red");
		}else{
			$("#pwInput").text("비밀번호 사용 가능합니다.").css("color","blue");
		}		
	});
	
	$("#user_name").focusout(function(){
	
		var name = $("#user_name");
		var nameValue = name.val();
		var nameReg = /^[|가-힣\x20|]{2,4}$/;
		var rsName = nameReg.test(nameValue);
		
		if(!rsName){
			$("#nameInput").text("이름을 한글로 작성해주세요.").css("color","red");
			
		}else{
			$("#nameInput").text("이름 사용 가능합니다.").css("color","blue");
		}		
	});
	
	$("#agree").click(function(){
	    	
		if( !($("#agree").is(":checked")) ){ 
			
			$("#agreeInput").text("약관에 동의해 주세요!").css("color","red");
		}else{
			$("#agreeInput").text("");
    	}
   	});
		  
		 
		 
		 
		 
		 function check(event) {
				
		//약관동의 <input>요소를 선택해서 가져와 
    	var checkbox = $("#agree");
    	//약관동의 체크했는지 검사
    	//선택한 <input type="checkbox">체크박스에 체크가 되어 있지 않으면? 
    	//true를 리턴 해서 조건에 만족 합니다. 
    	if( !(checkbox.is(":checked")) ){ //== 같은 true값을 반환 한다. if(!$("#agree").prop("checked"))
    		$("#agreeInput").text("약관에 동의해 주세요!").css("color","red");
    		
    		return false;

    	}    
		
  


			
		var name = $("#user_name");
    	var nameValue = name.val();
    	
    	var nameReg = RegExp(/^[|가-힣\x20|]{2,4}$/);
    	var resultName = nameReg.test(nameValue);

		if(!resultName){
			$("#nameInput").text("이름을 한글로 작성하여주세요.").css("color","red");
			name.focus();
			return false;
		}else{
			$("#nameInput").text("");
		}
	
		
		
    	var pass = $("#user_pw");
    	var passValue = pass.val();
    	
    	var passReg = RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,}$/);
    	var resultPass = passReg.test(passValue);

		if(!resultPass){
			$("#passInput").text("영어,숫자,특수문자를 호함하여 8~20자로 작성하여주세요.").css("color","red");
			pass.focus();
			return false;
		}else{
			$("#passInput").text("사용 가능한 비밀번호 입니다.").css("color","green");
		}
		
	   
			var mail = $("#user_email");
    		var mailValue = mail.val();
    		var mailReg = (/^\w{5,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/);
    		var rsEmail = mailReg.test(mailValue);
    		
	    	if(!rsEmail){
    			$("#emailInput").text("이메일 형식이 올바르지 않습니다.").css("color","red");
    			mail.focus();
    			return false;
	    	
	    	}else{
    			$("#emailInput").text("");
    		}
	
	    	
	    	
	    			alert("회원가입이 완료 되었습니다.");
	    		
   	    	
   	    	$("form").submit();
	}   