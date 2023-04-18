<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="center" value="${requestScope.center}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${contextPath}/resources/css/admin/adminPage.css" type="text/css">
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
	
	
</style>

</head>
<body>
	<div class="shipping_total">
		<div class="shipping_total_2">
			<div class="shipping_title">
				<h4 class="shipping_title_2">배송 관리</h4>
			</div>
			<table>
				<tr class="shippingTable">
					<td>배송번호</td>
					<td>주문내역</td>
					<td>주문날짜</td>
					<td>배송상태</td>
					<td>배송수정</td>
				</tr>			

<%-- 			<c:forEach var="L" items="${likeMap}" varStatus=""> --%>
				
				<tr class="shippingTable_1">
					<td>배송번호</td>
					<td>주문내역</td>
					<td>주문날짜</td>
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
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>