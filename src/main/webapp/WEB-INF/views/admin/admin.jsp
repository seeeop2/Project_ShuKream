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
	    min-height: 380px;
	}

	.shipping_title{
	    padding-bottom: 16px;
    	border-bottom: 3px solid #222;

	}

	.shipping_title_2{
	    font-weight: 600;
	}
	
	.shippingTable td{
		width: 200px;
    	position: relative;
    	top: 20px;
    	left: 65px;
	
	}
	
	.shippingTable_1 td{
    	position: relative;
    	top: 40px;
    	left: 65px;
	
	}
	.shippingTable_2 td{
    	position: relative;
    	top: 40px;
    	left: 65px;
	
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
	
	#info{
		width: 350px;
	}
	
	
</style>

</head>
<body>
	<div class="shipping_total">
		<div class="shipping_total_2">
			<div class="shipping_title">
				<h4 class="shipping_title_2">배송 관리</h4><br>
				<button class="asksBtn" onclike="asks()" >판매 정보</button> 
				<button class="bidsBtn" onclick="bids()" >구매 정보</button>
			</div>
			<table>
				<tr class="shippingTable">
					<td>판매자</td>
					<td>주문자</td>
					<td id="info">주문내용</td>
					<td>주문날짜</td>
					<td>배송상태</td>
					<td>배송수정</td>
				</tr>			

<%-- 			<c:forEach var="L" items="${likeMap}" varStatus=""> --%>
				
				<tr class="shippingTable_1">
					<td>12345</td>
					<td>구매자</td>
					<td>
						상품명:ㅇㄴㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇ<br>
						사이즈 : 260
					</td>
					<td>2023.04.18</td>
					<td>
						<select>
							<option>배송준비중</option>
							<option>배송중</option>
							<option>배송완료</option>
						
						</select>
					</td>	
					<td><button>변경</button></td>
				</tr>


<%-- < 			</c:forEach> --%>
			
				
				
				
<%-- 			<c:forEach var="L" items="${likeMap}" varStatus=""> --%>
			
				<tr class="shippingTable_2">
					<td>12345</td>
					<td>판매자</td>
					<td>
						신발:2번 신발<br>
						사이즈 : 280
					</td>
					<td>2023.04.19</td>
					<td>
						<select>
							<option>배송준비중</option>
							<option>배송중</option>
							<option>배송완료</option>
						
						</select>
					</td>	
					<td><button>변경</button></td>
				</tr>
					
<%-- < 			</c:forEach> --%>
			
			
			
			

			</table>	

		
		</div>
 
	
	</div>	
	
	<script type="text/javascript">
	
	window.onload = function () { 
		
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
	
	
	
	
	
	
</body>
</html>