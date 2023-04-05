<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style>

#event_wrapper {
	
    position: relative;
    margin: 0 auto;
    top: 0;
    left: 0;
    width: 100%;
    height: 700px;
}

#event_row {

	
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

#event_container {
	
    position: relative;
    height: 100%;
    width: 100%;
    left: 0;
    top: 0;
    text-align : center;
    margin : 0 auto;
}

#event_item {
	
	position: relative;
    top: 0;
    left: 0;
    margin: 0 auto;
    width: 100%;
    height: 100%;
	box-shadow: 0 0 10px 10px gray;
    border-radius: 40px;
}

#event_item_pic {
	
    height: 60%;
    width: 100%;
    border: 1px solid white;
    border-radius: 40px;
    margin: 0 auto 20px auto;
    position: relative;
    top: 0;
    left: 0;
}
	
#event_item_text {
	
    height: 30%;
    width: 100%;
    border: 1px solid white;
    border-radius: 40px;
    margin: 0 auto;
    position: relative;
    top: 0;
    left: 0;
    font-size : 20px;
    font-weight : bold;

}

#event_calendar {
	height: 20%;
	width : 7%;

}

#event_main_text {
	font-weight : bold;
	color : red;

}

#event_link {
	
	text-decoration : none;
	color : navy;
	transition : 0.3s;

}
#event_link:hover {
	color : orange;
	transition : 0.3s;

}

</style>

<!-- Css Styles 적용 -->
<%-- <link rel="stylesheet" href="${contextPath}/resources/css/event/event.css" type="text/css"> --%>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-blog set-bg"
  data-setbg="${contextPath}/resources/img/event/event_bg.jpg">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h2>Event 페이지</h2>
      </div>
    </div>
  </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Event Section Begin -->
<section id="event_wrapper" class="event spad">
  <div id="event_container" class="container">
    <div id="event_row" class="row">
	  <!-- 썸네일 스타일의 목록 > 내용 -->
      <div class="col-lg-4 col-md-6 col-sm-6">
        <div id="event_item" class="event__item">
          <div id="event_item_pic" class="event__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/event/event-1.jpg"></div>
          <div id="event_item_text" class="event__item__text">
            <span>[진행중]<br>
            <img id="event_calendar" src="${contextPath}/resources/img/icon/calendar.png" alt="">&nbsp;&nbsp;4/1 ~ 4/30</span>
              <br>
            <h2 id="event_main_text">행운뽑기 이벤트</h2>
              <br>
            <a id="event_link" href="#">이벤트 자세히보기</a>
          </div>
        </div>
      </div>
  	</div>
  </div>
</section>
<!-- Event Section End -->
