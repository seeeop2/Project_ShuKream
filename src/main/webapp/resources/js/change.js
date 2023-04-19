function change(event) {
		
		//약관동의 <input>요소를 선택해서 가져와 
    	var checkbox = $("#agree");
    	
    	
//====================================================================================================
		
		var email = $("#user_email");
    		var emailValue = email.val();
    		var emailReg = /^\w{5,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
    		var rsEmail = emailReg.test(emailValue);
    		
	    	if(!rsEmail){
    			$("#emailInput").text("이메일 형식이 올바르지 않습니다.").css("color","red");
    			email.focus();
    			return false;
	    	
	    	}else{
    			$("#emailInput").text("");
    		}

//====================================================================================================
								
 	   if(confirm("정보를 수정하시겠습니까??")){
		        
	    		$("form").attr("action", "http://localhost:8090/TeamProject/member/updateInfo.do");
				$("form").submit();
				
			}else {
				
				location.href="#";
				
			}
		}
	
//=====================================================================================================	
	    		
	    	$("#delBtn").click(function(){
	    		
	    		if (confirm("정말 회원탈퇴 하시겠습니까?")) {
	    			
					location.href = "delete.do";

				} else {
					
					location.href = "#";

				}

	    	
	    	});
