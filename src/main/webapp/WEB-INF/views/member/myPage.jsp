<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style>

#mypage_wrapper{

/* 	border : 1px solid black; */
	
	position : relative;
	display : flex;
	max-width : 1920px;
	width : 100%;
	height: 500px;
	margin : 0 auto;


}

#mypage_box{

/*     border: 1px solid red; */
    
    position: relative;
    display: flex;
    width: 100%;
    height: 100%;
    margin: 0 auto;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
}

.myinfo {

/* 	border : 1px solid green; */
	
    position: relative;
    display: flex;
    width: calc(100%/4);
    height: 100%;
    margin: 0 10px;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    box-shadow: 0 0 10px 5px;
    border-radius: 20px;
    font-weight : bold;

}

.tradeinfo {

/* 	border : 1px solid green; */
	
    position: relative;
    display: flex;
    width: calc(100%/4);
    height: 100%;
    margin: 0 10px;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    box-shadow: 0 0 10px 5px;
    border-radius: 20px;
    font-weight : bold;

}

.shippinginfo {

/* 	border : 1px solid green; */
	
    position: relative;
    display: flex;
    width: calc(100%/4);
    height: 100%;
    margin: 0 10px;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    box-shadow: 0 0 10px 5px;
    border-radius: 20px;
    font-weight : bold;
}

.couponinfo {
	
/* 	border : 1px solid green; */

    position: relative;
    display: flex;
    width: calc(100%/4);
    height: 100%;
    margin: 0 10px;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    box-shadow: 0 0 10px 5px;
    border-radius: 20px;
    font-weight : bold;

}

.mybtn {

	border: 1px dashed black;
	
    position: relative;
    display: flex;
    width: 100%;
    height: 100%;
    margin: 0 auto;
    text-align: center;
    line-height: 0;
    font-size: 50px;
    padding: 20px;
    border-radius: 20px;
    flex-direction: column;
    flex-wrap: nowrap;
    justify-content: center;
    transition : 1s;
    color : black;
    background : white;
    font-weight : bold;
}

.mybtn:hover {
	
	border-radius : 20px;
	background : black;
	color : white;
	transition : 0.3s;
	box-shadow : 0 0 10px 5px;
	font-weight : bold;
}

</style>

<!-- Css Styles 적용 -->
<link rel="stylesheet" href="${contextPath}/resources/css/member/mypage.css" type="text/css">

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
	
	<div class="tradeinfo">
		<a class="mybtn" type="button" href="#">주문 정보</a>
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
