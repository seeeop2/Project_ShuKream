<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style>
</style>

<!-- Css Styles 적용 -->
<link rel="stylesheet" href="${contextPath}/resources/css/event/coupon.css" type="text/css">

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-blog set-bg"
  data-setbg="${contextPath}/resources/img/event/coupon.jpg">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h2>쿠폰 내역</h2>
      </div>
    </div>
  </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Coupon Section Begin -->
<section id="coupon_wrapper" class="coupon spad">
  <div id="coupon_wrapper" class="container">
	쿠폰내역페이지입니다.
  </div>
</section>
<!-- Coupon Section End -->
