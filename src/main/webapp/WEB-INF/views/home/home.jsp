<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="bestSeller" value="${mainProductMap.bestSeller}"/>
<c:set var="newArrivals" value="${mainProductMap.newArrivals}"/>
<c:set var="popularItems" value="${mainProductMap.popularItems}"/>
<c:set var="likeList" value="${likeList}" />

<!-- Hero Section Begin -->
<section class="hero">
  <div class="hero__slider owl-carousel">
    <div class="hero__items set-bg"
      data-setbg="${contextPath}/resources/img/hero/main_slider1.jpg" onclick="location.href='shop/list.do'" style="cursor: pointer;">
      <div class="container">
        <div class="row">
          <div class="col-xl-5 col-lg-7 col-md-8">
            <div class="hero__text">
              <div class="hero__social" style="position: absolute; bottom: -550px;">
                <a href="#"><i class="fa fa-facebook"></i></a> <a
                  href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
                  class="fa fa-pinterest"></i></a> <a href="#"><i
                  class="fa fa-instagram"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="hero__items set-bg"
      data-setbg="${contextPath}/resources/img/hero/main_slider2.jpg" onclick="location.href='shop/list.do'" style="cursor: pointer;">
      <div class="container">
        <div class="row">
          <div class="col-xl-5 col-lg-7 col-md-8">
            <div class="hero__text">
              <div class="hero__social" style="position: absolute; bottom: -550px;">
                <a href="#"><i class="fa fa-facebook"></i></a> <a
                  href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
                  class="fa fa-pinterest"></i></a> <a href="#"><i
                  class="fa fa-instagram"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Hero Section End -->

<!-- Product Section Begin -->
<section class="product spad" style="padding-top: 50px; background-color: #eee">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <ul class="filter__controls">
          <li class="active" data-filter="*">Best Sellers</li>
          <li data-filter=".new-arrivals">New Arrivals</li>
<!--           <li data-filter=".hot-sales">Hot Sales</li> -->
          <li data-filter=".popular-items">Popular Items</li>
        </ul>
      </div>
    </div>
    <div class="row product__filter">
    
    <div class="row product__filter">
    
    <%-- 여기부터 --%>
    <c:forEach var="newArrivals" items="${mainProductMap.newArrivals}" begin="0" end="3" varStatus="i">
    <c:set var="product_name_en" value="${newArrivals.productVO.product_name_en}"/>
    <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
        <div class="product__item">
		<c:if test="${newArrivals.productVO.category eq 0}">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/sneakers/${newArrivals.img_file}">
         </c:if>
         <c:if test="${newArrivals.productVO.category eq 1}">
        	<div class="product__item__pic set-bg"
            	data-setbg="${contextPath}/resources/img/product/slipper/${newArrivals.img_file}">
         </c:if>
         
            <ul class="product__hover">
              <li>
          		<a id="heartBtn" onclick="javascript:heartBtn('${newArrivals.productVO.product_id}',
      														  '${newArrivals.img_file}',
													  		  '${newArrivals.productVO.product_name_en}',              														  
															  '${newArrivals.productVO.product_name_kor}',              														  	
														      '${newArrivals.productVO.product_price}',              														  	
															  '${email}'             														  	
																	);">
	             	<c:choose>
		            	<c:when test="${fn:contains(likeList,product_name_en)}">
		         			<img  style="cursor: pointer;" id="heartImg${newArrivals.productVO.product_id}" src="${contextPath}/resources/img/icon/heart1.png" alt=""> 
		                </c:when>
		                <c:otherwise>
		         			<img  style="cursor: pointer;" id="heartImg${newArrivals.productVO.product_id}" src="${contextPath}/resources/img/icon/heart.png" alt=""> 
		                </c:otherwise>
			 		</c:choose>
      			</a>
		      </li>
              <li><a href="shop/shopDetails.do?product_id=${newArrivals.productVO.product_id}"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6>${newArrivals.productVO.product_name_en}</h6>
            <span>${newArrivals.productVO.product_name_kor}</span>
            <a href="#" class="add-cart">+ Add To Wish List</a>
            <div class="rating">
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i>
            </div>
            <fmt:formatNumber value="${newArrivals.productVO.product_price}" type="number" var="product_price" />
            <h5>${product_price}원</h5>
          </div>
        </div>
      </div>
      <%--popular --%>
       <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix popular-items">
        <div class="product__item">
         <c:if test="${mainProductMap.popularItems[i.index].productVO.category eq 0}">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/sneakers/${mainProductMap.popularItems[i.index].img_file}">
         </c:if>
          <c:if test="${mainProductMap.popularItems[i.index].productVO.category eq 1}">
        	<div class="product__item__pic set-bg"
            	data-setbg="${contextPath}/resources/img/product/slipper/${mainProductMap.popularItems[i.index].img_file}">
         </c:if>
            <ul class="product__hover">
              <li>
           			
           			<a id="heartBtn" onclick="javascript:heartBtn('${mainProductMap.popularItems[i.index].productVO.product_id}',
	      														  '${mainProductMap.popularItems[i.index].img_file}',
														  		  '${mainProductMap.popularItems[i.index].productVO.product_name_en}',              														  
																  '${mainProductMap.popularItems[i.index].productVO.product_name_kor}',              														  	
															      '${mainProductMap.popularItems[i.index].productVO.product_price}',              														  	
																  '${email}'             														  	
																	);">
	             	<c:choose>
		            	<c:when test="${fn:contains(likeList,product_name_en)}">
		         			<img  style="cursor: pointer;" id="heartImg${mainProductMap.popularItems[i.index].productVO.product_id}" src="${contextPath}/resources/img/icon/heart1.png" alt=""> 
		                </c:when>
		                <c:otherwise>
		         			<img  style="cursor: pointer;" id="heartImg${mainProductMap.popularItems[i.index].productVO.product_id}" src="${contextPath}/resources/img/icon/heart.png" alt=""> 
		                </c:otherwise>
			 		</c:choose>
      			
      			</a>
              </li>
              <li><a href="shop/shopDetails.do?product_id=${mainProductMap.popularItems[i.index].productVO.product_id}"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6>${mainProductMap.popularItems[i.index].productVO.product_name_en}</h6>
            <span>${mainProductMap.popularItems[i.index].productVO.product_name_kor}</span>
            <a href="#" class="add-cart">+ Add To Wish List</a>
            <div class="rating">
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i>
            </div>
            <fmt:formatNumber value="${mainProductMap.popularItems[i.index].productVO.product_price}" type="number" var="product_price" />
            <h5>${product_price}원</h5>
          </div>
        </div>
      </div>
      </c:forEach>
    <%-- 여기까지 --%>
    </div>
  </div>
</section>
<!-- Product Section End -->

<!-- Instagram Section Begin -->
<section class="instagram spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-8">
        <div class="instagram__pic">
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-1.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-2.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-3.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-4.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-5.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-6.jpg"></div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="instagram__text">
          <h2>Instagram</h2>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing
            elit, sed do eiusmod tempor incididunt ut labore et dolore
            magna aliqua.</p>
          <h3>#ShuKream</h3>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Instagram Section End -->

<!-- Latest Blog Section Begin -->
<section class="latest spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="section-title">
          <span>Latest News</span>
          <h2>Fashion New Trends</h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="blog__item">
          <div class="blog__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/blog/blog-1.jpg"></div>
          <div class="blog__item__text">
            <span><img
              src="${contextPath}/resources/img/icon/calendar.png"
              alt=""> 16 February 2020</span>
            <h5>What Curling Irons Are The Best Ones</h5>
            <a href="#">Read More</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="blog__item">
          <div class="blog__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/blog/blog-2.jpg"></div>
          <div class="blog__item__text">
            <span><img
              src="${contextPath}/resources/img/icon/calendar.png"
              alt=""> 21 February 2020</span>
            <h5>Eternity Bands Do Last Forever</h5>
            <a href="#">Read More</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="blog__item">
          <div class="blog__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/blog/blog-3.jpg"></div>
          <div class="blog__item__text">
            <span><img
              src="${contextPath}/resources/img/icon/calendar.png"
              alt=""> 28 February 2020</span>
            <h5>The Health Benefits Of Sunglasses</h5>
            <a href="#">Read More</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Latest Blog Section End -->

	<script type="text/javascript">
	
	    function heartBtn(PRODUCT_ID,IMG_FILE,PRODUCT_NAME_EN,PRODUCT_NAME_KOR,PRODUCT_PRICE,email){
 	        if(email == ""){
	          alert("로그인을 하여주세요");
 	        } else{
	          $.ajax({
	                  url:  "/shuKream/favorites/favoritesLike.do",
	                  async : true,
	                  type : 'POST',
	                  data : {
 	                	  		PRODUCT_ID : PRODUCT_ID,	                	  		
 	                	  		IMG_FILE : IMG_FILE,
	                	  		PRODUCT_NAME_EN : PRODUCT_NAME_EN,
 	                	  		PRODUCT_NAME_KOR : PRODUCT_NAME_KOR,
	                	  		PRODUCT_PRICE : PRODUCT_PRICE,
								email : email
	                  		},
	                  success : function(data) {
	                 	
	                 	if ( data == 0 ) {
                        	
	                 		$("#heartImg"+PRODUCT_ID).attr("src","${contextPath}/resources/img/icon/heart.png");
                        
	                 	} else if (data == 1) {
	                        
	                 		$("#heartImg"+PRODUCT_ID).attr("src","${contextPath}/resources/img/icon/heart1.png"); 
                        }
	                  
	                  }
	            });
	        }
	      }
	    
	    function getContextPath() {
	    	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	    	
	    	return location.href.substring(hostIndex, location.href.indexOf('/',hostIndex + 1));
	    };
	
	</script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>