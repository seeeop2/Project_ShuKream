<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- Footer Section Begin -->
<footer class="footer">
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="footer__about">
          <div class="footer__logo">
            <a href="#"><img
              src="${contextPath}/resources/img/footer_logo.jpg" alt=""></a>
          </div>
          <p>슈크림을 이용해주셔서 감사합니다</p>
          <a href="#"><img
            src="${contextPath}/resources/img/payment.png" alt=""></a>
        </div>
      </div>
      <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
        <div class="footer__widget">
          <h6>Shopping</h6>
          <ul>
            <li><a href="shop/list.do">신발사러가기</a></li>
            <li><a href="#">이벤트참여하러가기</a></li>
            <li><a href="#">링크3</a></li>
            <li><a href="#">링크4</a></li>
          </ul>
        </div>
      </div>
      <div class="col-lg-2 col-md-3 col-sm-6">
        <div class="footer__widget">
          <h6>슈크림지원센터</h6>
          <ul>
            <li><a href="#">오시는길</a></li>
            <li><a href="#">결제방법</a></li>
            <li><a href="#">배송</a></li>
            <li><a href="#">반품 및 환불</a></li>
          </ul>
        </div>
      </div>
      <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
        <div class="footer__widget">
          <h6>새소식</h6>
          <div class="footer__newslatter">
            <p>슈크림의 새로운 소식을 누구보다 가장 빠르게 듣고싶다면! &nbsp;아래에 고객님의 이메일 주소를 입력해주세요.</p>
            <form action="#">
              <input type="text" placeholder="Your email">
              <button type="submit">
                <span class="icon_mail_alt"></span>
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-12 text-center">
        <div class="footer__copyright__text">
          <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
          <p>
            Copyright ©
            <script>
                          document.write(new Date().getFullYear());
                        </script>
            2020 All rights reserved | This template is made with <i
              class="fa fa-heart-o" aria-hidden="true"></i> by <a
              href="https://colorlib.com" target="_blank">Colorlib</a>
          </p>
          <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- Footer Section End -->

<!-- Search Begin -->
<div class="search-model">
  <div class="h-100 d-flex align-items-center justify-content-center">
    <div class="search-close-switch">+</div>
    <form class="search-model-form">
      <input type="text" id="search-input"
        placeholder="Search here.....">
    </form>
  </div>
</div>
<!-- Search End -->
