<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
 <script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style>

#event_detail_wrapper {

    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0;
    max-width: 1200px;
    width: 100%;
    height: 900px;
  	
}

#event_detail_container {
	
    position: relative;
    height: 100%;
    width: 100%;
    left: 0;
    top: 0;
    text-align : center;
    margin : 0 auto;
}

#event_detail_row {

	
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

#event_detail_table {
	
	border : 1px solid palegreen;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 100%;
    box-shadow: 0 0 10px 10px #b7b7b7;

}

#event_detail_title{

	border : 1px solid green;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 100px;
	background : green;

}

#detail_title_box {

    border: 1px solid green;
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0;
    width: 100px;
    height: 100%;
    float: left;
    background: green;
    text-align: center;
    color: greenyellow;
    font-weight: bold;
    font-size: 20px;
    
}

.detail_title {

    border: 1px solid green;
    
    position: relative;
    margin: 0 auto;
    top: 0px;
    left: 5px;
    min-width: 340px;
    max-width: 1028px;
    width: 76%;
    height: calc(99%/3);
    float: left;
    text-align: left;
    font-size: 15px;
    background: green;
    color: white;
    font-weight: bold;
}

#event_detail_contents{

	border : 1px solid green;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 600px;

}

#event_detail_num {

    border: 1px solid white;
    position: relative;
    margin: 10px;
    top: 10px;
    left: 20px;
    width: 17%;
    float: left;
    height: 45%;
}

#event_detail_text {

    border: 1px dotted rgb(0 123 255 / 0%);
    
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    text-align: center;
    font-weight: bold;
    font-size: 60px;
    color: #ffffff00;
    background: #ffc107;
    box-shadow: 0 0 15px 10px #e5e5e5;
    border-radius: 30px;
    
}

</style>

<!-- Css Styles 적용 -->
<link rel="stylesheet" href="${contextPath}/resources/css/event/eventDetail.css" type="text/css">

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-blog set-bg"
  data-setbg="${contextPath}/resources/img/event/event_bg.jpg">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h2>행운뽑기 Event 페이지</h2>
      </div>
    </div>
  </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Event Section Begin -->
<section id="event_detail_wrapper" class="event spad">
  <div id="event_detail_container" class="container">
    <div id="event_detail_row" class="row">
	  <!-- 행운 뽑기 Event 내용 -->
	   <div id="event_detail_table">
	   	<div id="event_detail_title">
	   		<input id="detail_title_box" type="text" value="참여 방법" />
	   		<input class="detail_title" type="text" value="          1) 구매 또는 판매가 성사 될 때 마다, 1회의 기회를 얻습니다." readonly="readonly" />
	   		<input class="detail_title" type="text" value="          2) 10개의 금색 응모권 중 하나를 선택해주세요" readonly="readonly" />
	   		<input class="detail_title" type="text" value="          3) 상품 : 무료배송권, 한달무료입고권, 수수료1회무료권 등등 작성중  [확률 30%] " readonly="readonly" />
	   	</div>
	   	<div id="event_detail_contents">
<!--  1번 : 무료배송권 , 3번 : 한달무료입고권 , 5번 : 수수료1회 무료권 등등 작성중...-->
   		  <c:forEach var="cnt" begin="1" end="10" step="1">
   		  <c:set var="ran"><%=java.lang.Math.floor(java.lang.Math.random() * 10)+1%></c:set>
		   	  <div id="event_detail_num" class="e${cnt}">
		   	  	<input type="text" onclick ="reply_click(this.value)" id="event_detail_text" class="t_cnt" value="${ran}" readonly="readonly" />
		   	  </div>
	   	  </c:forEach>
	    </div>
	   </div>
	 </div>
  </div>
</section>
<!-- Event Section End -->
<script>

$( document ).ready(function() {
	
})


// onclick을 이용한 메소드(클릭한 value값 가져오기)
// 로그인 기능 구현되었을 때 , id값도 같이 넘길 것
function reply_click(clicked_value){
	
	if(clicked_value == 1.0){
		
		alert("무료 배송권 당첨!! 당첨내역으로 이동합니다!");
		
		location.replace("${contextPath}/event/detailresult.do?ticket=freeshipping");
		
		
		
	}else if(clicked_value == 3.0){
		
		alert("한달 무료입고권 당첨!! 당첨내역으로 이동합니다!");
		
		location.replace("${contextPath}/event/detailresult.do?ticket=freeimport");
		
	}else if(clicked_value == 5.0){
		
		alert("수수료 1회 무료권 당첨!! 당첨내역으로 이동합니다!");
		
		location.replace("${contextPath}/event/detailresult.do?ticket=freecharge");
		
	}else {
		
		alert("꽝입니다....다음 기회에..");
		
		location.replace("${contextPath}/event/main.do");
		
	}
}
</script>
