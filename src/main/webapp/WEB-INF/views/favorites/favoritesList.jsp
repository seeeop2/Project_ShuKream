<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%-- <c:set var="myLikeList"   value="${sessionScope.likeMap}"  /> --%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/favorites/favorites.css" type="text/css">

<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<div class="favorites_total">
		<div class="favorites_total_2">
			<div class="favorites_title">
				<h4 class="favorites_title_2">관심 상품</h4>
			</div>
			<c:choose>
			<c:when test="${totalCount eq 0}">
				<div class="goShop">
					<p >추가하신 관심 상품이 없습니다.</p>
					<a href="${contextPath}/shop/list.do" id="goShop_a">SHOP바로가기</a>			
				</div>
			</c:when>
			
			<c:otherwise> 
				<ul>
					<c:forEach var="L" items="${likeMap}" varStatus="">
						<li>
							<div id="favorites_list">
								<div id="">
									<c:choose>
										<c:when test="${L.LIKE_PRODUCT <= 30}">
											<img id=favorites_img src="${contextPath}/resources/img/product/sneakers/${L.LIKE_IMG_FILE}">
										</c:when>
										<c:otherwise> 
											<img id=favorites_img src="${contextPath}/resources/img/product/slipper/${L.LIKE_IMG_FILE}">
										</c:otherwise>
									</c:choose>
								</div>
								<div id="favorites_info">
									<p id="name_kor">${L.LIKE_PRODUCT_NAME_KOR}</p>
									<p id="name_en">${L.LIKE_PRODUCT_NAME_EN}</p>
								</div>
								<div id="favorites_buy">
<%-- 									<a href="${contextPath}/shop/list.do"> --%>
									<a href="${contextPath}/shop/shopDetails.do?product_id=${L.LIKE_PRODUCT}">	
										<div id="buyBtn">
											<div id="buyBtn2">
												<strong>구매</strong>
											</div>
												
											<div id="buyPrice">
												<p id="price">${L.LIKE_PRODUCT_PRICE}</p>
												<p id="price2">입찰 가격</p>
											</div>								
										</div>
									</a>
									<a id="del" href="${contextPath}/favorites/favoritesDel.do?like_idx=${L.LIKE_IDX}">삭제</a>
								</div>						
							</div>
						</li>			
					</c:forEach>
				</ul>
			</c:otherwise>
			</c:choose>
		
		<div class="row">
          <div class="col-lg-12">
            <div class="product__pagination">
            	<c:if test="${pagination.hasPrevBlock()}">
              		<a class="" href="?page=${pagination.startPage-1}">&laquo;</a> 
            	</c:if>
            	<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="pageNumber">
            		<c:choose>
            			<c:when test="${pageNumber eq pagination.currentPage}">
            				<a class="active" href="?page=${pageNumber}">${pageNumber}</a>
            			</c:when>
            			<c:otherwise>
            				<a href="?page=${pageNumber}">${pageNumber}</a>
            			</c:otherwise>
            		</c:choose>
            	</c:forEach>
            	<c:if test="${pagination.hasNextBlock()}">
            		<a href="?page=${pagination.endPage+1}">&raquo;</a>
            	</c:if>
            </div>
          </div>
        </div>
		</div>
 
	
	</div>	

<script type="text/javascript">
		
		
		$("#goShop_a").mouseover(function(){
		    
			$("#goShop_a").css("background-color", "#e5e5e587");
			
		});
	
	
		$("#goShop_a").mouseout(function(){
		
	  		$("#goShop_a").css("background-color", "white");
		
		});
		
		
</script>

</body>
</html>


