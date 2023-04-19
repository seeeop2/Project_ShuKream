<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<link rel="stylesheet" href="${contextPath}/resources/css/home.css">    
<script src="https://kit.fontawesome.com/4536cebc99.js" crossorigin="anonymous"></script>
<style>
</style>    
  <!-- Page Preloder -->
<!--     <div id="preloder"> -->
<!--         <div class="loader"></div> -->
<!--     </div> -->

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__option">
            <div class="offcanvas__links">
            <%
            if(session.getAttribute("isLogOn") == null) {
            %>
            	<a href="${contextPath}/member/loginForm.do">로그인</a>
                <a href="#">문의</a>
            <%

            }else{
             %>	
            	<a href="${contextPath}/member/logout.do">로그아웃</a>
            	<a href="${contextPath}/member/mypage.do">마이페이지</a>
                <a href="#">문의</a> 
             <%
             }
             %>   
             </div>
            
        </div>
        <div class="offcanvas__nav__option">
            <a href="#" class="search-switch"><img src="${contextPath}/resources/img/icon/search.png" alt=""></a>
            <a href="#"><img src="${contextPath}/resources/img/icon/heart.png" alt=""></a>
          
            
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__text">
            <p>Free shipping, 30-day return or refund guarantee.</p>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-7">
                        <div class="header__top__left">
                            <p>30일 반품 또는 환불 보장.</p>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-5">
                        <div class="header__top__right">
                            <div class="header__top__links">
					      
					        <%--    
					           <%
					            if(session.getAttribute("isLogOn") == null) {
					            %>
					            	<a href="${contextPath}/member/loginForm.do">로그인</a>
					                <a href="#">문의</a>
					            <%
					             else if(session.getAttribute("isLogOn") == "admin"){ 
					          	
					            %>
			                     	<a href="${contextPath}/member/logout.do">로그아웃</a>
			                	    <a href="${contextPath}/admin/admin.do">관리자페이지</a>
					            <%
					            }else{
					            %>	
					            	<a href="${contextPath}/member/logout.do">로그아웃</a>
					            	<a href="${contextPath}/member/mypage.do">마이페이지</a>
					                <a href="#">문의</a> 
					             	
					            <%
					             }
					            %>   
					          
					           --%>
		   							<c:choose>
										<c:when test="${email eq null}">
											<a href="${contextPath}/member/loginForm.do">로그인</a>
					                		<a href="#">문의</a>
										</c:when>
										<c:when test="${email eq 'admin'}">
											<a href="${contextPath}/member/logout.do">로그아웃</a>
			                	    		<a href="${contextPath}/admin/admin.do">배송관리</a>
										</c:when>
										<c:otherwise> 
											<a href="${contextPath}/member/logout.do">로그아웃</a>
					            			<a href="${contextPath}/member/mypage.do">마이페이지</a>
				                		<a href="#">문의</a>
										</c:otherwise>
									</c:choose>
					          
					           </div>
                          </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="${contextPath}/main.do"><img src="${contextPath}/resources/img/header_logo.jpg" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <nav class="header__menu mobile-menu">
                        <ul>
                            <li><a href="${contextPath}/main.do">Home</a></li>
                            <li><a href="${contextPath}/shop/list.do">Shop</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="dropdown">
                                    <li><a href="${contextPath}/pages/about.do">About Us</a></li>
                                    <li><a href="${contextPath}/pages/shoppingCart.do">Shopping Cart</a></li>
                                    <li><a href="${contextPath}/pages/checkOut.do">Check Out</a></li>
                                    <li><a href="${contextPath}/pages/blogDetails.do">Blog Details</a></li>
                                </ul>
                            </li>
                            <li><a href="${contextPath}/blog/list.do">Blog</a></li>
                            <li><a href="${contextPath}/contacts/main.do"">Contacts</a></li>	
                            <!-- 이벤트 페이지 버튼 추가 -->
                            <li><a href="${contextPath}/event/main.do">Event</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3 col-md-3">
                    <div class="header__nav__option">
                        <a href="#" class="search-switch"><img src="${contextPath}/resources/img/icon/search.png" alt=""></a>
                        <a href="${contextPath}/favorites/favoritesList.do"><img src="${contextPath}/resources/img/icon/heart.png" alt=""></a>
                        
                    </div>
                </div>
            </div>
            <div class="canvas__open"><i class="fa fa-bars"></i></div>
        </div>
    </header>
    <!-- Header Section End -->
    
    <!-- Search Begin -->
	<div class="search-model" style="opacity: 0.9">
	  <div class="h-100 d-flex align-items-top justify-content-center">
	    <div class="search-close-switch">+</div>
	    <form class="search-model-form" onsubmit="return false;">
	    	<div style="position: relative; top:200px; left:-100px;">
<!-- 	    	<select id="search-option">
	    		<option value="product_name">상품명</option>
	    		<option value="brand">브랜드</option>
	    	</select> -->
	    	</div>
	      <input type="text" id="search-input"
	        placeholder="Search here....." style="position: relative; top:150px;">
	    </form>
	    <div class="search_wrap" >
	        	<div id="search_wrap_row1">
	        		<div class="search_wrap_cell1">상품 이미지 &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 상품명</div>
	        	</div>
		        <div id="displayList"></div>
        </div>
	  </div>
	</div>
	<div id="quickmenu_box" onclick="addChannel();" style="cursor: pointer;">
		<i id="button" class="fa-solid fa-comment-sms"></i>
		<a id="quickmenu" href="#">1:1문의</a>
	</div>
	<!-- Search End -->
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<%-- 검색어 완성기능용 js파일 --%>
	<script  src="${contextPath}/resources/js/home.js"></script>
	
	<%-- 카카오 챗봇 연동 --%>
	 <script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"></script>
<script>
  Kakao.init(''); // 사용하려는 앱의 JavaScript 키 입력
	function addChannel() {
		Kakao.Channel.addChannel({
			  channelPublicId: '_fvxfxkxj'
			});
		}
</script>
	<script>

	</script>
	