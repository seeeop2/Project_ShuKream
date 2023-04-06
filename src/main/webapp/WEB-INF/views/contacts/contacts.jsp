<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!-- Map Begin -->
<!-- <div class="map">
  <iframe
    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d111551.9926412813!2d-90.27317134641879!3d38.606612219170856!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x54eab584e432360b%3A0x1c3bb99243deb742!2sUnited%20States!5e0!3m2!1sen!2sbd!4v1597926938024!5m2!1sen!2sbd"
    height="500" style="border: 0;" allowfullscreen=""
    aria-hidden="false" tabindex="0"></iframe>
</div> -->

<!--
	* 카카오맵 - 약도서비스
	* 한 페이지 내에 약도를 2개 이상 넣을 경우에는
	* 약도의 수 만큼 소스를 새로 생성, 삽입해야 합니다.
-->
<!-- 1. 약도 노드 -->
<div id="daumRoughmapContainer1680683107739" class="root_daum_roughmap root_daum_roughmap_landing" style="margin: 0 auto;"></div>

<!-- 2. 설치 스크립트 -->
<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

<!-- 3. 실행 스크립트 -->
<script charset="UTF-8">
	new daum.roughmap.Lander({
		"timestamp" : "1680683107739",
		"key" : "2ece7",
		"mapWidth" : "1200",
		"mapHeight" : "600"
	}).render();
</script>

<!-- Map End -->

<!-- Contact Section Begin -->
<section class="contact spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-6 col-md-6">
        <div class="contact__text">
          <div class="section-title">
            <span>정보</span>
            <h2>문의하기</h2>
            <p>고급 인테리어 시공사로 출발한 업체답게 세심한 주의를 기울이고 있습니다.</p>
          </div>
          <ul>
         	 <li>
              <h4>한국</h4>
              <p>
                경남 양산시 중부동 686-7 양산역프라자 2층 <br />대표전화 : 1800-0000
              </p>
            </li>
            <li>
              <h4>America</h4>
              <p>
                195 E Parker Square Dr, Parker, CO 801 <br />+43
                982-314-0958
              </p>
            </li>
          </ul>
        </div>
      </div>
      <div class="col-lg-6 col-md-6">
        <div class="contact__form">
          <form action="#">
            <div class="row">
              <div class="col-lg-6">
                <input type="text" placeholder="Name">
              </div>
              <div class="col-lg-6">
                <input type="text" placeholder="Email">
              </div>
              <div class="col-lg-12">
                <textarea placeholder="Message"></textarea>
                <button type="submit" class="site-btn">Send
                  Message</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Contact Section End -->

