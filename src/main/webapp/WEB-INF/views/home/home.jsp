<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!-- Hero Section Begin -->
<section class="hero">
  <div class="hero__slider owl-carousel">
    <div class="hero__items set-bg"
      data-setbg="${contextPath}/resources/img/hero/main_slider1.png" onclick="location.href='shop/list.do'" style="cursor: pointer;">
      <div class="container">
        <div class="row">
          <div class="col-xl-5 col-lg-7 col-md-8">
            <div class="hero__text">
              <!-- <h6>Summer Collection</h6>
              <h2>Fall - Winter Collections 2030</h2>
              <p>A specialist label creating luxury essentials.
                Ethically crafted with an unwavering commitment to
                exceptional quality.</p>
              <a href="#" class="primary-btn">Shop now <span
                class="arrow_right"></span></a> -->
              <div class="hero__social" style="position: absolute; bottom: -550px;">
                <a href="#"><i class="fa fa-facebook"></i></a> <a
                  href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
                  class="fa fa-pinterest"></i></a> <a href="#"><i
                  class="fa fa-instagram"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="hero__items set-bg"
      data-setbg="${contextPath}/resources/img/hero/main_slider2.png" onclick="location.href='shop/list.do'" style="cursor: pointer;">
      <div class="container">
        <div class="row">
          <div class="col-xl-5 col-lg-7 col-md-8">
            <div class="hero__text">
              <!-- <h6>Summer Collection</h6>
              <h2>Fall - Winter Collections 2030</h2>
              <p>A specialist label creating luxury essentials.
                Ethically crafted with an unwavering commitment to
                exceptional quality.</p>
              <a href="#" class="primary-btn">Shop now <span
                class="arrow_right"></span></a> -->
              <div class="hero__social" style="position: absolute; bottom: -550px;">
                <a href="#"><i class="fa fa-facebook"></i></a> <a
                  href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
                  class="fa fa-pinterest"></i></a> <a href="#"><i
                  class="fa fa-instagram"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Hero Section End -->

<!-- Banner Section Begin -->
<%-- <section class="banner spad" style="background-color: #eee">
  <div class="container">
    <div class="row">
      <div class="col-lg-7 offset-lg-4">
        <div class="banner__item">
          <div class="banner__item__pic">
            <img src="${contextPath}/resources/img/banner/main_article.webp"
              alt="">
          </div>
          <div class="banner__item__text">
            <h2>Clothing Collections 2030</h2>
            <a href="#">Shop now</a>
          </div>
        </div>
      </div>
      <div class="col-lg-5">
        <div class="banner__item banner__item--middle">
          <div class="banner__item__pic">
            <img src="${contextPath}/resources/img/banner/main_article2.webp"
              alt="">
          </div>
          <div class="banner__item__text">
            <h2>Accessories</h2>
            <a href="#">Shop now</a>
          </div>
        </div>
      </div>
      <div class="col-lg-7">
        <div class="banner__item banner__item--last">
          <div class="banner__item__pic">
            <img src="${contextPath}/resources/img/banner/main_article3.webp"
              alt="">
          </div>
          <div class="banner__item__text">
            <h2>Shoes Spring 2030</h2>
            <a href="#">Shop now</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</section> --%>
<!-- Banner Section End -->

<!-- Product Section Begin -->
<section class="product spad" style="padding-top: 50px; background-color: #ddd">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <ul class="filter__controls">
          <li class="active" data-filter="*">Best Sellers</li>
          <li data-filter=".new-arrivals">New Arrivals</li>
          <li data-filter=".hot-sales">Hot Sales</li>
        </ul>
      </div>
    </div>
    <div class="row product__filter">
      <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
        <div class="product__item">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-1.png">
<!--             <span class="label">New</span> -->
            <ul class="product__hover">
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/heart.png"
                  alt=""></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/compare.png"
                  alt=""> <span>Compare</span></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6><!-- (W) Nike Zoom Vomero 5 Cobblestone and Flat Pewter --> 상품이름 DB에서 받아와야함</h6>
            <a href="#" class="add-cart">+ Add To Cart</a>
            <div class="rating">
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i>
            </div>
            <h5>$67.24</h5>
            <div class="product__color__select">
              <label for="pc-1"> <input type="radio" id="pc-1">
              </label> <label class="active black" for="pc-2"> <input
                type="radio" id="pc-2">
              </label> <label class="grey" for="pc-3"> <input
                type="radio" id="pc-3">
              </label>
            </div>
          </div>
        </div>
      </div>
      <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix hot-sales">
        <div class="product__item">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-2.png">
            <ul class="product__hover">
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/heart.png"
                  alt=""></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/compare.png"
                  alt=""> <span>Compare</span></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6>Nike Air Force 1 '07 WB Flax</h6>
            <a href="#" class="add-cart">+ Add To Cart</a>
            <div class="rating">
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i>
            </div>
            <h5>$67.24</h5>
            <div class="product__color__select">
              <label for="pc-4"> <input type="radio" id="pc-4">
              </label> <label class="active black" for="pc-5"> <input
                type="radio" id="pc-5">
              </label> <label class="grey" for="pc-6"> <input
                type="radio" id="pc-6">
              </label>
            </div>
          </div>
        </div>
      </div>
      <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
        <div class="product__item sale">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-3.png">
<!--             <span class="label">Sale</span> -->
            <ul class="product__hover">
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/heart.png"
                  alt=""></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/compare.png"
                  alt=""> <span>Compare</span></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6>Nike Air Force 1 '07 Low White</h6>
            <a href="#" class="add-cart">+ Add To Cart</a>
            <div class="rating">
              <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                class="fa fa-star-o"></i>
            </div>
            <h5>$43.48</h5>
            <div class="product__color__select">
              <label for="pc-7"> <input type="radio" id="pc-7">
              </label> <label class="active black" for="pc-8"> <input
                type="radio" id="pc-8">
              </label> <label class="grey" for="pc-9"> <input
                type="radio" id="pc-9">
              </label>
            </div>
          </div>
        </div>
      </div>
      <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix hot-sales">
        <div class="product__item">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-4.png">
            <ul class="product__hover">
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/heart.png"
                  alt=""></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/compare.png"
                  alt=""> <span>Compare</span></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6>(W) Nike Zoom Vomero 5 Photon Dust and Metallic Silver</h6>
            <a href="#" class="add-cart">+ Add To Cart</a>
            <div class="rating">
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i>
            </div>
            <h5>$60.9</h5>
            <div class="product__color__select">
              <label for="pc-10"> <input type="radio" id="pc-10">
              </label> <label class="active black" for="pc-11"> <input
                type="radio" id="pc-11">
              </label> <label class="grey" for="pc-12"> <input
                type="radio" id="pc-12">
              </label>
            </div>
          </div>
        </div>
      </div>
      <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
        <div class="product__item">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-5.png">
            <ul class="product__hover">
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/heart.png"
                  alt=""></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/compare.png"
                  alt=""> <span>Compare</span></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6>Jordan 1 Low SE Tokyo 96</h6>
            <a href="#" class="add-cart">+ Add To Cart</a>
            <div class="rating">
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i>
            </div>
            <h5>$31.37</h5>
            <div class="product__color__select">
              <label for="pc-13"> <input type="radio" id="pc-13">
              </label> <label class="active black" for="pc-14"> <input
                type="radio" id="pc-14">
              </label> <label class="grey" for="pc-15"> <input
                type="radio" id="pc-15">
              </label>
            </div>
          </div>
        </div>
      </div>
      <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix hot-sales">
        <div class="product__item sale">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-6.png">
<!--             <span class="label">Sale</span> -->
            <ul class="product__hover">
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/heart.png"
                  alt=""></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/compare.png"
                  alt=""> <span>Compare</span></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6>Jordan 4 x Nike SB Retro Pine Green</h6>
            <a href="#" class="add-cart">+ Add To Cart</a>
            <div class="rating">
              <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                class="fa fa-star-o"></i>
            </div>
            <h5>$98.49</h5>
            <div class="product__color__select">
              <label for="pc-16"> <input type="radio" id="pc-16">
              </label> <label class="active black" for="pc-17"> <input
                type="radio" id="pc-17">
              </label> <label class="grey" for="pc-18"> <input
                type="radio" id="pc-18">
              </label>
            </div>
          </div>
        </div>
      </div>
      <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix new-arrivals">
        <div class="product__item">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-7.png">
            <ul class="product__hover">
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/heart.png"
                  alt=""></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/compare.png"
                  alt=""> <span>Compare</span></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6>Jordan 1 Retro High OG Chicago 2022</h6>
            <a href="#" class="add-cart">+ Add To Cart</a>
            <div class="rating">
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i>
            </div>
            <h5>$49.66</h5>
            <div class="product__color__select">
              <label for="pc-19"> <input type="radio" id="pc-19">
              </label> <label class="active black" for="pc-20"> <input
                type="radio" id="pc-20">
              </label> <label class="grey" for="pc-21"> <input
                type="radio" id="pc-21">
              </label>
            </div>
          </div>
        </div>
      </div>
      <div
        class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix hot-sales">
        <div class="product__item">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-8.png">
            <ul class="product__hover">
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/heart.png"
                  alt=""></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/compare.png"
                  alt=""> <span>Compare</span></a></li>
              <li><a href="#"><img
                  src="${contextPath}/resources/img/icon/search.png"
                  alt=""></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6>Jordan 1 x Travis Scott Retro Low OG SP Black Phantom</h6>
            <a href="#" class="add-cart">+ Add To Cart</a>
            <div class="rating">
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
              <i class="fa fa-star-o"></i>
            </div>
            <h5>$26.28</h5>
            <div class="product__color__select">
              <label for="pc-22"> <input type="radio" id="pc-22">
              </label> <label class="active black" for="pc-23"> <input
                type="radio" id="pc-23">
              </label> <label class="grey" for="pc-24"> <input
                type="radio" id="pc-24">
              </label>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Product Section End -->

<!-- Categories Section Begin -->
<%-- <section class="categories spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <div class="categories__text">
          <h2>
            Clothings Hot <br /> 
            <span>Shoe Collection</span> <br />
            Accessories
          </h2>
        </div>
      </div>
      <div class="col-lg-5">
        <div class="categories__hot__deal">
          <img src="${contextPath}/resources/img/product-hotdeal.png"
            alt="">
          <div class="hot__deal__sticker">
            <span>Sale Of</span>
            <h5>$29.99</h5>
          </div>
        </div>
      </div>
      <div class="col-lg-4 offset-lg-1">
        <div class="categories__deal__countdown">
          <span>Deal Of The Week</span>
          <h2>Jordan 1 Retro High OG Black Mocha</h2>
          <div class="categories__deal__countdown__timer" id="countdown">
            <div class="cd-item">
              <span>3</span>
              <p>Days</p>
            </div>
            <div class="cd-item">
              <span>1</span>
              <p>Hours</p>
            </div>
            <div class="cd-item">
              <span>50</span>
              <p>Minutes</p>
            </div>
            <div class="cd-item">
              <span>18</span>
              <p>Seconds</p>
            </div>
          </div>
          <a href="#" class="primary-btn">Shop now</a>
        </div>
      </div>
    </div>
  </div>
</section> --%>
<!-- Categories Section End -->

<!-- Instagram Section Begin -->
<section class="instagram spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-8">
        <div class="instagram__pic">
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-1.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-2.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-3.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-4.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-5.jpg"></div>
          <div class="instagram__pic__item set-bg"
            data-setbg="${contextPath}/resources/img/instagram/instagram-6.jpg"></div>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="instagram__text">
          <h2>Instagram</h2>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing
            elit, sed do eiusmod tempor incididunt ut labore et dolore
            magna aliqua.</p>
          <h3>#ShuKream</h3>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Instagram Section End -->

<!-- Latest Blog Section Begin -->
<section class="latest spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="section-title">
          <span>Latest News</span>
          <h2>Fashion New Trends</h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="blog__item">
          <div class="blog__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/blog/blog-1.jpg"></div>
          <div class="blog__item__text">
            <span><img
              src="${contextPath}/resources/img/icon/calendar.png"
              alt=""> 16 February 2020</span>
            <h5>What Curling Irons Are The Best Ones</h5>
            <a href="#">Read More</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="blog__item">
          <div class="blog__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/blog/blog-2.jpg"></div>
          <div class="blog__item__text">
            <span><img
              src="${contextPath}/resources/img/icon/calendar.png"
              alt=""> 21 February 2020</span>
            <h5>Eternity Bands Do Last Forever</h5>
            <a href="#">Read More</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="blog__item">
          <div class="blog__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/blog/blog-3.jpg"></div>
          <div class="blog__item__text">
            <span><img
              src="${contextPath}/resources/img/icon/calendar.png"
              alt=""> 28 February 2020</span>
            <h5>The Health Benefits Of Sunglasses</h5>
            <a href="#">Read More</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Latest Blog Section End -->
