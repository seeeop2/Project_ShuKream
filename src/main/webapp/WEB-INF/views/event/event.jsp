<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style>
</style>

<!-- Css Styles 적용 -->
<link rel="stylesheet" href="${contextPath}/resources/css/event/event.css" type="text/css">

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
            <a id="event_link" href="${contextPath}/event/detail.do">이벤트 자세히보기</a>
          </div>
        </div>
      </div>
  	</div>
  </div>
</section>
<!-- Event Section End -->
