<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<style>
</style>

<!-- Css Styles 적용 -->
<link rel="stylesheet" href="${contextPath}/resources/css/event/coupon.css" />

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
  <div id="coupon_box" class="container">
	<div id="title_box">
		<a class="coupon_title" type="text">쿠폰번호</a>
    	<a class="coupon_title" type="text">쿠폰명</a>
    	<a class="coupon_title" type="text">발급일</a>
    	<a class="coupon_title" type="text">유효기간</a>
    </div>
    
    <div id="content_box">
    	<c:forEach var="coupon" items="${checkcoupon}">
	    	<div id="content_row">
		    	<input class="coupon_content" id="coupon_num" type="text" value="${coupon.d_idx}" readonly="readonly" />
		    <c:choose>
			    <c:when test= "${coupon.d_ticket eq '무료배송권'}">
			    	<input style="color: blue; font-weight:bold;" class="coupon_content" id="coupon_name" type="text" value="${coupon.d_ticket}" readonly="readonly" />
			    </c:when>
   			    <c:when test= "${coupon.d_ticket eq '무료1회입고권'}">
			    	<input style="color: #20c997; font-weight:bold;" class="coupon_content" id="coupon_name" type="text" value="${coupon.d_ticket}" readonly="readonly" />
			    </c:when>
    			<c:when test= "${coupon.d_ticket eq '수수료1회무료권'}">
			    	<input style="color: orange; font-weight:bold;" class="coupon_content" id="coupon_name" type="text" value="${coupon.d_ticket}" readonly="readonly" />
			    </c:when>
			    <c:otherwise>
			    	<input style="color: black; font-weight:bold;" class="coupon_content" id="coupon_name" type="text" value="${coupon.d_ticket}" readonly="readonly" />
			    </c:otherwise>
		    </c:choose>
		    	<input class="coupon_content" id="coupon_date" type="text" value="<fmt:formatDate value="${coupon.d_date}" dateStyle="long" /> 발급" readonly="readonly" />
		    	<input style="font-weight :bold; color: red; text-decoration: underline;"class="coupon_content" id="coupon_expiry_date" type="text" value="<fmt:formatDate value="${coupon.expiry_date}" dateStyle="long" /> 폐기 됨" readonly="readonly" />
	    	</div>
    	</c:forEach>
    </div>
  </div>
</section>
<!-- Coupon Section End -->
