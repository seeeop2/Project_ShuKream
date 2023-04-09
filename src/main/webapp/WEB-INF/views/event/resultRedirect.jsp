<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    justify-content: center;
    flex-direction: column;
    box-shadow: 0 0 10px 10px #b7b7b7;
    border-radius: 5px;
}

#event_detail_result_table {
	
	border : 1px solid orangered;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 500px;
	border-radius : 5px;
	


}

#event_detail_result_title{

	border : 1px solid orangered;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 100px;
	background : orangered;

}

#event_detail_result_a {

	border : 1px solid orangered;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 40%;

}

#event_detail_result_a > a {

    border: 1px solid orangered;

    display: flex;
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0px;
    width: calc(100%/4);
    height: 100%;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    align-items: center;
    float: left;
    background: orangered;
    border-radius: 5px;
    color: aliceblue;
    font-weight: bold;
    text-align: center;
}

#event_detail_result_input {

	border : 1px solid orangered;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 60%;
	padding : 10px 0;

}

#event_detail_result_input > input {

    border: 1px solid orangered;
    
    display: flex;
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0px;
    width: calc(100%/4);
    height: 100%;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    align-items: center;
    float: left;
    background: white;
    border-radius: 5px;
    color: black;
    font-weight: bold;
    text-align: center;
}

#event_detail_result_contents_title{

    border: 1px solid dodgerblue;

    width: 100%;
    height: 40px;
    border-radius: 5px;
    background: dodgerblue;
    position: relative;
    top: 0;
    left: 0;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
}


#event_detail_result_contents{

	border : 1px solid dodgeblue;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 360px;
	border-radius: 5px;
	overflow-y: auto;


}

#event_detail_contents_a {

	border : 1px solid dodgerblue;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 40px;
	background : dodgerblue;

}

#event_detail_contents_a > a {

    border: 1px solid dodgerblue;
    
    display: flex;
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0px;
    width: calc(100%/6);
    height: 100%;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    align-items: center;
    float: left;
    background: dodgerblue;
    color: #fff;
    font-weight: bold;
    text-align: center;
}

#event_detail_contents_input {

	border : 1px solid dodgerblue;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 60px;
	background : dodgerblue;
	padding : 5px 0;

}

#event_detail_contents_input > input {

    border: 1px solid dodgerblue;
    
    display: flex;
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0px;
    width: calc(100%/6);
    height: 100%;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    align-items: center;
    float: left;
    background: white;
    border-radius: 5px;
    color: black;
    font-weight: bold;
    text-align: center;
	font-size : 11px;
	
}


#event_detail_contents_row{
	
	border : 1px solid black;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 200px;
	border-radius : 5px;

}

#event_detail_contents_row_a{

	border : 1px solid black;

	position : relative;
	margin : 0 auto;
	top : 0;
	left : 0;
	width: 100%;
	height : 40px;
	background : black;


}

#event_detail_contents_row_a > a {

    border: 1px solid black;
    
    display: flex;
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0px;
    width: 100%;
    height: 100%;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    align-items: center;
    float: left;
    background: black;
    color: red;
    font-weight: bold;
    text-align: center;
    
}

#event_detail_contents_row_input {
    border: 1px solid black;
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0;
    width: 100%;
    height: 160px;
    background: black;
    padding: 5px 10px;
    
}

#event_detail_contents_row_input > input{

    border: 1px solid black;
    
    display: flex;
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0px;
    width: 100%;
    height: calc(100%/6);
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    align-items: center;
    float: left;
    background: white;
    border-radius: 5px;
    color: black;
    font-weight: bold;
    text-align: left;
	font-size : 11px;


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
	   	   <div id="event_detail_result_a">
		   		<a>당첨자</a>
		   		<a>총 응모권 횟수</a>
		   		<a>사용한 횟수</a>
		   		<a>남은 횟수</a>
	   		</div>
	   		<div id="event_detail_result_input">
		   		<input type="text" placeholder="당첨자명" readonly="readonly" value="${id}" />
		   		<input type="text" placeholder="총 응모권 횟수" readonly="readonly" value="${a_cnt}" />
		   		<input type="text" placeholder="사용한 횟수" readonly="readonly" value="${u_cnt}" />
		   		<input type="text" placeholder="남은 횟수" readonly="readonly" value="${d_cnt}" />
	   		</div>
	   	</div>
	   	<div id="event_detail_result_contents_title">
<!--  당첨 내역을 table로 표시하고, 테이블 밖에 하단에는 부가 설명을 첨부한다.-->
	   	   <div id="event_detail_contents_a">
		   		<a>번호</a>
		   		<a>당첨권</a>
		   		<a>당첨 날짜</a>
		   		<a>당첨 내용</a>
		   		<a>유효 기간</a>
		   		<a>사용 여부</a>
	   		</div>
	   	</div>	
	   	<div id="event_detail_result_contents">	
		<c:forEach var="vo" items="${checkuser}">	
	   		<div id="event_detail_contents_input">
		   		<input type="text" placeholder="번호" value="${vo.d_idx}" readonly="readonly" />
		   		<input class="ticket" type="text" placeholder="당첨된 응모권" value="${vo.d_ticket}" readonly="readonly" />
		   		<input class="d_date" type="text" placeholder="당첨 날짜" value="<fmt:formatDate type="date" dateStyle="full" value="${vo.d_date}"/>" readonly="readonly" />
		   		<input type="text" placeholder="신청번호:xxxx 물품명: 조단 판매 완료에 대한 당첨권 1회 발급" value="${vo.d_contents}" readonly="readonly" />
	   			<input class="expiry_date" style="text-decoration: underline; color:red;" id="expiry_date" type="text" placeholder="" value="<fmt:formatDate type="date" dateStyle="full" value="${vo.expiry_date}"/> 까지" readonly="readonly" />
	   			<input class="d_confirm" type="text" value="${vo.d_confirm}" readonly="readonly" />
	   		</div>
	 	</c:forEach>

	    </div>
	   </div>
	   <div id="event_detail_contents_row">
   	   	   <div id="event_detail_contents_row_a">
		   		<a>안내 사항</a>

	   		</div>
	   		<div id="event_detail_contents_row_input">
		   		<input type="text" value="1) 판매자 또는 구매자는 거래 완료 즉시, 1회에 한하여 응모권이 발생합니다." readonly="readonly" />
		   		<input type="text" value="2) 당첨된 응모권은 발급 즉시 사용 가능하며, 사용 즉시 소멸 됩니다." readonly="readonly" />
		   		<input type="text" value="3) 당첨된 응모권은 타인에게 양도 혹은 환불(기타거래)가 불가능합니다." readonly="readonly" />
		   		<input type="text" value="4) 당첨된 응모권의 유효기간은 발급일로 부터 30일 입니다." readonly="readonly" />
	   			<input type="text" value="5) 당첨된 응모권의 유효기간이 지나면 자동 소멸 됩니다." readonly="readonly" />
	   			<input type="text" value="6) 문의사항은 고객센터를 이용해 주세요" readonly="readonly" />
	   		</div>
	   </div>
	 </div>
  </div>
</section>
<!-- Event Section End -->

<script>

$(document).ready(function(){
	
	var id = "${id}";


	location.replace("${contextPath}/event/detailresult.do?id="+id);
	

})

</script>
