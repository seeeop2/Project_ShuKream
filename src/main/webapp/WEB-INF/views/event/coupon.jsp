<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<style>

#coupon_wrapper{

/*     border : 1px solid black; */
	
	position : relative;
	display : flex;
	max-width : 1920px;
	width : 100%;
	height: 700px;
	margin : 0 auto;


}

#coupon_box{

    border: 1px dotted white;
    
    position: relative;
    display: flex;
    width: 100%;
    height: 100%;
    margin: 0 auto;
    flex-direction: column;
    flex-wrap: nowrap;
    justify-content: center;
    text-align: center;
    border-radius: 30px;
    box-shadow: 0 0 30px 10px;
}

#title_box{

/* 	border : 1px dotted white; */

    position: relative;
    display: flex;
    margin: 5px;
    width: 97%;
    height: 100px;
    top: 0;
    left: 0;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    border-radius: 20px;
    color: white;
    background: white;

}

.coupon_title {

    border: 1px dotted white;
    
    position: relative;
    display: flex;
    margin: 10px;
    width: 100%;
    height: 80%;
    top: 0;
    left: 0;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    font-size: 25px;
    padding: 20px;
    font-weight: bold;
    border-radius: 20px;
    background: black;


}


#content_box{

/* 	border : 1px dotted black; */

	position: relative;
    display: flex;
    margin: 0px;
    width: 100%;
    height: 70%;
    top: 0;
    left: 0;
    flex-direction: column;
    flex-wrap: nowrap;
    justify-content: flex-start;
    border-radius: 10px;
    padding: 0;
    overflow-y: auto;
    

}

#content_row{

/* 	border : 1px solid blue; */

    position: relative;
    display: flex;
    margin: 3px;
    width: 97%;
    height: 50px;
    top: 0;
    left: 2px;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
	


}

#content_row > input{

	float : left;
	margin : 0px 15px;
	top : 0;
	left : 0;
	padding : 0;
	


}

.coupon_content{

	border: 1px dashed black;
	
    position: relative;
    display: flex;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    flex-direction: column;
    flex-wrap: nowrap;
    justify-content: center;
    border-radius: 10px;
    text-align: center;
    font-size: 20px;
}

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
		    	<input class="coupon_content" id="coupon_name" type="text" value="${coupon.d_ticket}" readonly="readonly" />
		    	<input class="coupon_content" id="coupon_date" type="text" value="<fmt:formatDate value="${coupon.d_date}" dateStyle="long" /> 발급" readonly="readonly" />
		    	<input style="color : red; text-decoration: underline;"class="coupon_content" id="coupon_expiry_date" type="text" value="<fmt:formatDate value="${coupon.expiry_date}" dateStyle="long" /> 폐기 됨" readonly="readonly" />
	    	</div>
    	</c:forEach>
    </div>
  </div>
</section>
<!-- Coupon Section End -->
