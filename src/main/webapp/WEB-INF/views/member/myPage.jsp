<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style>
</style>

<!-- Css Styles 적용 -->
<link rel="stylesheet" href="${contextPath}/resources/css/member/mypage.css" />

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-blog set-bg"
  data-setbg="${contextPath}/resources/img/member/mypage.jpg">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h2>마이 페이지</h2>
      </div>
    </div>
  </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Event Section Begin -->
<section id="mypage_wrapper" class="mypage spad">
  <div id="mypage_box" class="container">
	
	<div class="myinfo">
		<a class="mybtn" type="button" href="${contextPath}/member/info.do">내 정보</a>
	</div>
	
	<div class="shippinginfo">
		<a class="mybtn" type="button" href="${contextPath}/member/shipping.do">배송 정보</a>
	</div>
	
	<div class="couponinfo">
		<a class="mybtn" type="button" href="${contextPath}/event/coupon.do">보유 쿠폰</a>
	</div>
	
	
  </div>
</section>
<!-- Event Section End -->
