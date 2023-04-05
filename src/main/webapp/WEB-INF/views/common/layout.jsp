<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="Male_Fashion Template">
<meta name="keywords" content="Male_Fashion, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title><tiles:insertAttribute name="title" /></title>
<!-- Google Font -->
<link
  href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
  rel="stylesheet">
<!-- Css Styles -->
<link rel="stylesheet"
  href="${contextPath}/resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet"
  href="${contextPath}/resources/css/font-awesome.min.css"
  type="text/css">
<link rel="stylesheet"
  href="${contextPath}/resources/css/elegant-icons.css" type="text/css">
<link rel="stylesheet"
  href="${contextPath}/resources/css/magnific-popup.css" type="text/css">
<link rel="stylesheet"
  href="${contextPath}/resources/css/nice-select.css" type="text/css">
<link rel="stylesheet"
  href="${contextPath}/resources/css/owl.carousel.min.css"
  type="text/css">
<link rel="stylesheet"
  href="${contextPath}/resources/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/resources/css/style.css"
  type="text/css">

</head>
<body>
  <div id="container">

    <!-- Page Preloder -->
    <div id="preloder">
      <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
      <div class="offcanvas__option">
        <div class="offcanvas__links">
          <a href="#">Sign in</a> <a href="#">FAQs</a>
        </div>
        <div class="offcanvas__top__hover">
          <span>Usd <i class="arrow_carrot-down"></i></span>
          <ul>
            <li>USD</li>
            <li>EUR</li>
            <li>USD</li>
          </ul>
        </div>
      </div>
      <div class="offcanvas__nav__option">
        <a href="#" class="search-switch"><img
          src="${contextPath}/resources/img/icon/search.png" alt=""></a> <a href="#"><img
          src="${contextPath}/resources/img/icon/heart.png" alt=""></a> <a href="#"><img
          src="${contextPath}/resources/img/icon/cart.png" alt=""> <span>0</span></a>
        <div class="price">$0.00</div>
      </div>
      <div id="mobile-menu-wrap"></div>
      <div class="offcanvas__text">
        <p>Free shipping, 30-day return or refund guarantee.</p>
      </div>
    </div>
    <!-- Offcanvas Menu End -->


    <div id="header">
      <tiles:insertAttribute name="header" />
    </div>
    <div id="content">
      <tiles:insertAttribute name="body" />
    </div>
    <div id="footer">
      <tiles:insertAttribute name="footer" />
    </div>
  </div>

  <!-- Js Plugins -->
  <script src="${contextPath}/resources/js/jquery-3.3.1.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  <script src="${contextPath}/resources/js/jquery.nice-select.min.js"></script>
  <script src="${contextPath}/resources/js/jquery.nicescroll.min.js"></script>
  <script src="${contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="${contextPath}/resources/js/jquery.countdown.min.js"></script>
  <script src="${contextPath}/resources/js/jquery.slicknav.js"></script>
  <script src="${contextPath}/resources/js/mixitup.min.js"></script>
  <script src="${contextPath}/resources/js/owl.carousel.min.js"></script>
  <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
