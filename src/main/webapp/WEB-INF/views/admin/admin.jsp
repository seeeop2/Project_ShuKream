<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

<style type="text/css">
	
	.shipping_total{
		width: 1500px; 
		padding: 40px 250px 160;	
		margin: auto;
	}
	
	.shipping_total_2{
 	    overflow: hidden; 
	    min-height: 440px;
	}

	.shipping_title{
	    padding-bottom: 16px;
    	border-bottom: 3px solid #222;

	}

	.shipping_title_2{
	    font-weight: 600;
	}
	
	.shippingTable td{
		width: 250px;
    	position: relative;
    	top: 20px;
     	left: 50px; 
	
	}
	
	.shippingTable_1 td{
    	position: relative;
    	top: 40px;
    	left: 65px;
		width:  250px;
	    position: relative;
	    top: 20px;
	    left: 0px;
	
	}
	.shippingTable_2 td{
    	position: relative;
    	top: 40px;
    	left: 65px;
		width:  250px;
	    position: relative;
	    top: 20px;
	    left: 0px;
	}
	
	.shipping_title button{
		width: 201px;
	    height: 55px;
	    border-radius: 10px;
	    background-color: white;	
	
	}
	
	.bidsBtn{
		margin-left: 10px;
	}
	
	#scroll{
		width:100%; 
		height:400px; 
	 	overflow-y : auto;
		margin-left: 50px
	}
	
</style>

</head>
<body>
	<div class="shipping_total">
		<div class="shipping_total_2">
			<div class="shipping_title">
				<h4 class="shipping_title_2">배송 관리</h4><br>
				<button class="asksBtn" >판매 정보</button> 
				<button class="bidsBtn" >구매 정보</button>
			</div>
				<table>
					<tr class="shippingTable">
						<td>주문번호</td>
						<td>주문자</td>
						<td>주문날짜</td>
						<td>배송상태</td>
					</tr>			
				</table>
	  			
			<div id="scroll">
	  			
				<table>
	  			<c:forEach var="bids" items="${bidsVO}" >  
					
					<tr class="shippingTable_1">
						<td>${bids.BIDS_ORDER_NUMBER}</td>
						<td>${bids.BIDS_USER_EMAIL}</td>
						<td>${bids.BIDS_MATCHED_DATE}</td>
						<td>
							<select id="bids_order" onchange="bids_orderChange(this.value,${bids.BIDS_ORDER_NUMBER})">
								<c:choose>
										<c:when test="${bids.BIDS_ORDER_STATE_IDX eq 1}">
											<option value="1" selected="selected">배송준비중</option>
											<option value="2">배송중</option>
											<option value="3">배송완료</option>
										</c:when>
										<c:when test="${bids.BIDS_ORDER_STATE_IDX eq 2}">
											<option value="1">배송준비중</option>
											<option value="2" selected="selected">배송중</option>
											<option value="3">배송완료</option>
										</c:when>
										<c:when test="${bids.BIDS_ORDER_STATE_IDX eq 3}">
											<option value="1">배송준비중</option>
											<option value="2">배송중</option>
											<option value="3" selected="selected">배송완료</option>
										</c:when>
										<c:otherwise>
 											<option selected="selected">구매확정</option>
 										</c:otherwise>
								</c:choose>
							</select>
						</td>	
					</tr>
	
	
	   			</c:forEach>  
				
					
					
					
	  			<c:forEach var="asks" items="${asksVO}" >  
				
					<tr class="shippingTable_2">
						<td>${asks.ASKS_ORDER_NUMBER}</td>
						<td>${asks.ASKS_USER_EMAIL}</td>
						<td>${asks.ASKS_MATCHED_DATE}</td>
						<td>
							<select id="asks_order" onchange="asks_orderChange(this.value,${asks.ASKS_ORDER_NUMBER})">
								
								<c:choose>
										<c:when test="${asks.ASKS_ORDER_STATE_IDX eq 1}">
											<option value="1" selected="selected">배송준비중</option>
											<option value="2">배송중</option>
											<option value="3">배송완료</option>
										</c:when>
										<c:when test="${asks.ASKS_ORDER_STATE_IDX eq 2}">
											<option value="1">배송준비중</option>
											<option value="2" selected="selected">배송중</option>
											<option value="3">배송완료</option>
										</c:when>
										<c:when test="${asks.ASKS_ORDER_STATE_IDX eq 3}">
											<option value="1">배송준비중</option>
											<option value="2">배송중</option>
											<option value="3"selected="selected">배송완료</option>
										</c:when>
										<c:otherwise>
 											<option selected="selected">구매확정</option>
 										</c:otherwise>
								</c:choose>
							</select>
						
						
						
						
						</td>	
					</tr>
						
	 			</c:forEach>
				
				
				
				
	
				</table>	
			</div>
		
		</div>
 
	
	</div>	
	
	<script type="text/javascript">
	
	//웹페이지 시작시 바로 호출
	window.onload = function () { 
		
		//자동으로 판매 정보버튼 클릭
		$(document).ready(function(){
		    
			$(".asksBtn").trigger('click'); 
		
		});
		
		
		$(".asksBtn").click(function(){
		    
			$(".asksBtn").css("background-color", "#e5e5e587");
	  		$(".bidsBtn").css("background-color", "white");
	  		$(".shippingTable_1").hide();
	  		$(".shippingTable_2").show();
		});
		
	 }	
		

		$(".bidsBtn").click(function(){
		    
			$(".bidsBtn").css("background-color", "#e5e5e587");
			$(".asksBtn").css("background-color", "white");
	  		$(".shippingTable_1").show();
	  		$(".shippingTable_2").hide();
			
		});

		

	
	
		
</script>
	<script type="text/javascript">
	
	    function bids_orderChange(BIDS_ORDER_STATE_IDX,BIDS_ORDER_NUMBER){
	    	
	         $.ajax({
                  	  
	        	  	  url: getContextPath()+"/admin/bidsOrderChange.do",
	                  async : true,
	                  type : 'POST',
	                  data : {BIDS_ORDER_STATE_IDX:BIDS_ORDER_STATE_IDX,
	                	  	  BIDS_ORDER_NUMBER:BIDS_ORDER_NUMBER
	                  },
	                  success : function(data) {
		                 	
	                 	if ( data == 1 ) {
                        	
	                 		alert("배송상태가 변경되었습니다.");
                        
	                 	} else {
	                 		
	                 		alert("배송상태 변경실패하였습니다.");
                        }
	                  
	                 }
	            
	         	}); 
	      }
	    
	    function asks_orderChange(ASKS_ORDER_STATE_IDX,ASKS_ORDER_NUMBER){
	        
	         $.ajax({
                  	  
	        	  	  url: getContextPath()+"/admin/asksOrderChange.do",
	                  async : true,
	                  type : 'POST',
	                  data : {ASKS_ORDER_STATE_IDX:ASKS_ORDER_STATE_IDX,
	                	      ASKS_ORDER_NUMBER:ASKS_ORDER_NUMBER  
	                  },
	                  success : function(data) {
		                 	
	                 	if ( data == 1 ) {
                        	
	                 		alert("배송상태가 변경되었습니다.");
                        
	                 	} else {
	                 		
	                 		alert("배송상태 변경실패하였습니다.");
                        }
	                  
	                 }
	            
	         	}); 
	      }
	    
	   
	    
	    function getContextPath() {
	    	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	    	
	    	return location.href.substring(hostIndex, location.href.indexOf('/',hostIndex + 1));
	    };
	
	</script>	
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	
	
	
</body>
</html>