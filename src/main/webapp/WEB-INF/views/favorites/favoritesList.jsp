<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%-- <c:set var="myLikeList"   value="${sessionScope.likeMap}"  /> --%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
	.favorites_total{
		width: 1500px; 
		padding: 40px 250px 160;	
		margin: auto;
	}
	
	.favorites_total_2{
 	    overflow: hidden; 
	    min-height: 380px;
	}

	.favorites_title{
	    padding-bottom: 16px;
    	border-bottom: 3px solid #222;

	}

	.favorites_title_2{
	    font-weight: 600;
	}
	
	.goShop{
		padding: 80px 0;
		text-align: center;
	}
	.goShop p{
		font-size: 13px;
	    letter-spacing: -.07px;
	    color: rgba(34,34,34,.5);
	}
	
	.goShop a{
	    border: 1px solid #d3d3d3;
   		color: rgba(34,34,34,.8);
	    font-size: 12px;
	    padding: 12px 14px;
        border-radius: 10px;
	}
	
	#favorites_list{
 	    display: flex; 
 		align-items: flex-start; 
	    padding: 20px 0 19px;
    	webkit-box-align: center;
/*     	align-items: center; */
    	border-bottom: 1px solid #ebebeb;
   		flex-direction: row;
	}
	#favorites_detail{
		argin-right: 30px;
	    width: 100%;
	    cursor: pointer;
	}
	
	#favorites_img{
	    width: 100px;
	    height: 100px;
	    border: 2px solid #ebebeb;
	    border-radius: 15px;
		margin-left: 20px;		
	}
	#favorites_info{
		width: 55%;
	}
	
	#name_en{
		margin-left: 10px;
	    margin-top: -13px;
	}
	#name_kor	{
		margin-left: 10px;
		font-weight: bold;
	}
	
	#favorites_buy{
	    margin-left: auto;
	    text-align: right;
		width: 21%;	
	}
	
	#buyBtn{
		height: 75px;
		text-align: left;
	 	background-color: #ef6253;
   	 	border-radius: 10px;
   	 	color: #fff;
		width: 210px;
		float: left;
	}
	
	#buyBtn2{
		width: 35%;
		height: 75px;
		border-right: 1px solid #11111136;
	    float: left;
	}
	
	#buyBtn2 strong{
		font-size: 18px;
    	position: relative;
		top: 25px;
		left: 20px;
	}
	
	#buyPrice{
		width:65%;
		height: 74px;
		float: left;
		margin-top: 14px;
		padding-left: 8px;
	}
		
	#price{
		font-weight: 700;
 		font-size: 20px;
 		color: white; 
 		display: table-header-group;;
	}
	#Price2{
 		color: white; 
 		font-size: 17px;
 		display: table-header-group;;
		
	}

	#del{
		color: #3d3d3d;
	    text-decoration: underline;
	}

</style>

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
									<a href="${contextPath}/shop/list.do">
										<div id="buyBtn">
											<div id="buyBtn2">
												<strong>구매</strong>
											</div>
												
											<div id="buyPrice">
												<p id="price">${L.LIKE_PRODUCT_PRICE}</p>
												<p id="price2">즉시 구매가</p>
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


