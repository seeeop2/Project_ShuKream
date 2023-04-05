<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
 <script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style>

#event_detail_result_wrapper {

    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0;
    max-width: 1200px;
    width: 100%;
    height: 900px;
}

#event_detail_result_container {
	
    position: relative;
    height: 100%;
    width: 100%;
    left: 0;
    top: 0;
    text-align : center;
    margin : 0 auto;
}

#event_detail_result_row {

	
    margin: 0 auto;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    position: relative;
    display: flex;
    flex-wrap: nowrap;
    align-content: center;
    justify-content: center;
}

#event_detail_result_table {
	
	border : 1px solid red;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 100%;

}

#event_detail_result_title{

	border : 1px solid blue;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 100px;

}

#event_detail_result_contents{

	border : 1px solid green;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 600px;

}


</style>

<!-- Css Styles 적용 -->
<link rel="stylesheet" href="${contextPath}/resources/css/event/eventDetailResult.css" type="text/css">

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-blog set-bg"
  data-setbg="${contextPath}/resources/img/event/event_bg.jpg">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h2>행운뽑기내역 페이지</h2>
      </div>
    </div>
  </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Event Section Begin -->
<section id="event_detail_result_wrapper" class="event spad">
  <div id="event_detail_result_container" class="container">
    <div id="event_detail_result_row" class="row">
	  <!-- 행운 뽑기 Event 상세페이지 내용 -->
	   <div id="event_detail_result_table">
	   	<div id="event_detail_result_title">
	   		<input type="text" value="당첨내역 상세페이지" />
	   	</div>
	   	<div id="event_detail_result_contents">
<!--  당첨 내역을 table로 표시하고, 테이블 밖에 하단에는 부가 설명을 첨부한다.-->
			당첨내역 테이블 만들기
	    </div>
	   </div>
	   <div id="event_detail_result_row">
	         당첨내역 하단부 주의사항 적기	 
	   </div>
	 </div>
  </div>
</section>
<!-- Event Section End -->
<script>
</script>
