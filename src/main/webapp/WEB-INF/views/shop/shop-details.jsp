<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="sneakers" value="sneakers" />
<c:set var="slipper" value="slipper" />

<style>
/* //모달에 적용한 css속성값.  */
.modal-title {
  font-size: 30px;
  text-align: left;
  font-weight: bold;
}
.modal_table {
  width: 100%;
}
.modal_table>div>ul {
  list-style: none;
}
.modal_table>div>ul>li {
  float: left;
}
#modal_userFollow {
  /*   margin:10px; */
  /*   text-align: right; */
  
}
.btn-outline-dark {
  /*   padding: 30px 55px; */
  width: 150px;
  height: 75px;
}
</style>

<script src="https://kit.fontawesome.com/d158a8723c.js"
  crossorigin="anonymous"></script>

<!-- Shop Details Section Begin -->
<section class="shop-details">
  <div style="display: flex; width: 100%; margin: auto;">
    <div class="product__details__pic"
      style="width: 60%; margin-left: 5%;">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="product__details__breadcrumb">
              <a href="./index.html">Home</a>
              <a href="./shop.html">Shop</a>
              <span>Product Details</span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-3 col-md-3">
            <ul class="nav nav-tabs" role="tablist">

              <c:choose>
                <c:when test="${product_id <30}">
                  <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">
                      <div class="product__thumb__pic set-bg" data-setbg="${contextPath}/resources/img/product/sneakers/${imgNameMain}"></div>
                    </a>
                  </li>

                  <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">
                      <div class="product__thumb__pic set-bg" data-setbg="${contextPath}/resources/img/product/sneakers/${imgNameDetail}"></div>
                    </a>
                  </li>
            </ul>
          </div>
          <div class="col-lg-6 col-md-9">
            <div class="tab-content">
              <div class="tab-pane active" id="tabs-1" role="tabpanel">
                <div class="product__details__pic__item">
                  <img src="${contextPath}/resources/img/product/sneakers/${imgNameMain}" alt="">
                </div>
              </div>
              <div class="tab-pane" id="tabs-2" role="tabpanel">
                <div class="product__details__pic__item">
                  <img src="${contextPath}/resources/img/product/sneakers/${imgNameDetail}" alt="">
                </div>
              </div>
              </c:when>

              <c:otherwise>
                <li class="nav-item"><a class="nav-link active"
                  data-toggle="tab" href="#tabs-1" role="tab">
                    <div class="product__thumb__pic set-bg"
                      data-setbg="${contextPath}/resources/img/product/slipper/${imgNameMain}"></div>
                </a></li>
                <li class="nav-item"><a class="nav-link active"
                  data-toggle="tab" href="#tabs-1" role="tab">
                    <div class="product__thumb__pic set-bg"
                      data-setbg="${contextPath}/resources/img/product/slipper/${imgNameDetail}"></div>
                </a></li>

                </ul>
            </div>
            <div class="col-lg-6 col-md-9">
              <div class="tab-content">
                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                  <div class="product__details__pic__item">
                    <img
                      src="${contextPath}/resources/img/product/slipper/${imgNameMain}"
                      alt="">
                  </div>
                </div>
                <div class="tab-pane" id="tabs-2" role="tabpanel">
                  <div class="product__details__pic__item">
                    <img
                      src="${contextPath}/resources/img/product/slipper/${imgNameDetail}"
                      alt="">
                  </div>
                </div>

                </c:otherwise>
                </c:choose>


                <div class="tab-pane" id="tabs-4" role="tabpanel">
                  <div class="product__details__pic__item">
                    <img
                      src="${contextPath}/resources/img/shop-details/product-big-4.png"
                      alt=""> <a
                      href="https://www.youtube.com/watch?v=8PJ3_p7VqHw&list=RD8PJ3_p7VqHw&start_radio=1"
                      class="video-popup"><i class="fa fa-play"></i></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row d-flex">
        <div class="product__details__text"
          style="text-align: left; margin-left: 30px;">
          <h4>
            <span style="border-bottom: 1px solid;">
            <b>${productvo.product_brand}</b>
            </span>
          </h4>
          <h4>${productvo.product_name_en}</h4>
          <div class="rating">
            <span> ${productvo.product_name_kor}</span>
          </div>
          <h3><span id="biglow">${latestMoney}</span>원</h3>
          <div class="product__details__option">
            <div class="product__details__option__size"
              style="width: 100%; display: flex; justify-content: space-between;">
              <span style="font-size: 20px;">Size</span> 
              <a class="follower" style="font-size: 23px; cursor: pointer;">
                <b id="forSize">모든 사이즈</b>
                <i class="fa-solid fa-caret-up"></i> 
              </a>
              <%------------- Modal ---------------%>
              <div class="modal fade" id="followModal" role="dialog" style="display:hidden;">
                <!--   이곳에 적어준 id 값을 토대로 모달을 호출하게 된다.  -->
                <div class="modal-dialog">
                  <!-- Modal content-->
                  <div class="modal-content">
                    <div class="modal-header">
                      <!--           //모달창의 header 부분에 해당한다.  -->
                      <h4 class="modal-title"></h4>
                      <button type="button" class="close"
                        data-dismiss="modal">×</button>
                    </div>
                    <div class="modal-body">
                      <!--           //모달창의 가운데 내용이 들어가는 곳이다.  -->
                      <div class="modal_table">
                        <div>
                          <ul>
                            <li>
                              <button class="btn btn-outline-dark" id="clickForsizeAll"><span id="forAllSize">모든사이즈</span> <br><span id="forLowBids">${lowBids}</span></button>
                            </li>

                            <c:forEach var="theLowestBids" items="${theLowestBids}" varStatus="status">
                              <li>
                                <button class="btn btn-outline-dark" id="clickForSizeBtn${status.index}">
                                  <span id="clickForSize${status.index}">${theLowestBids.key}</span><br>
                                  <span id="clickForMoney${status.index}">${theLowestBids.value}</span><br>
                                </button>
                              </li>
                            </c:forEach>
                          </ul>
                        </div>
                      </div>
                    </div>
                    <div id="count" value="1"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="product__details__cart__option">
            <div style="margin-bottom: 5px;">
              <button type="button" class="btn btn-danger"
                style="width: 49%; background-color: #ef6253">
                <span
                  style="float: left; font-size: 2rem; border-right: 1px solid white; padding-right: 10px;">구매</span>
                <span style="vertical-align: middle;"><b>${lowBids}</b>원</span><br>
                <span style="vertical-align: middle; font-size: 0.8rem;">즉시 구매가</span>
              </button>
              <button type="button" class="btn btn-success"
                style="width: 49%; background-color: #41b979">
                <span
                  style="float: left; font-size: 2rem; border-right: 1px solid white; padding-right: 10px;">판매</span>
                <span style="vertical-align: middle;"><b>${lowAsks}</b>원</span><br>
                <span style="vertical-align: middle; font-size: 0.8rem;">즉시 판매가</span>
              </button>
            </div>
            <div style="background-color: yellow">
              <a href="#" class="primary-btn"
                style="margin: auto; display: block; text-align: center;">
                <i class="fa fa-heart"></i> add to wishlist
              </a>
            </div>
          </div>
          <div class="product__details__last__option"
            style="margin-bottom: 20px;">
            <h5 style="margin-bottom: 5px;">
              <span>상품 정보</span>
            </h5>
            <ul style="padding-top: 5px;">
              <li><span>모델번호 :</span> <b>${productvo.model_number}</b></li>
              <li><span>출시일 :</span>
                ${productvo.product_release_date}</li>
              <li><span>컬러 :</span> ${productvo.product_color}</li>
              <li><span>발매가 :</span> ${productvo.product_price}</li>
            </ul>
          </div>
          <div class="product__details__last__option"
            style="margin-bottom: 20px;">
            <h5 style="margin-bottom: 5px;">
              <span>배송 정보</span>
            </h5>
            <ul style="padding-top: 5px;">
              <li><span>일반배송:</span> 3,000원</li>
              <li style="padding-left: 4.5em">검수 후 배송 ・ 5-7일 내 도착
                예정</li>

            </ul>
          </div>
          <div class="product__details__last__option">
            <h5 style="margin-bottom: 5px;">
              <span>시세</span>
            </h5>
            <div id="chart_div"></div>
          </div>
        </div>
      </div>
    </div>
    <%-- 컨텐츠 부분 --%>
    <div class="product__details__content" style="width: 100%">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="product__details__tab">
              <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item"><a class="nav-link active"
                  data-toggle="tab" href="#tabs-5" role="tab">배송 기간
                    안내</a></li>
                <li class="nav-item"><a class="nav-link"
                  data-toggle="tab" href="#tabs-6" role="tab">검수 안내</a></li>
                <li class="nav-item"><a class="nav-link"
                  data-toggle="tab" href="#tabs-7" role="tab">구매
                    환불/취소/교환 안내</a></li>
              </ul>
              <div class="tab-content">
                <div class="tab-pane active" id="tabs-5" role="tabpanel">
                  <div class="product__details__tab__content">
                    <p class="note">
                      KREAM은 최대한 빠르게 모든 상품을 배송하기 위해 노력하고 있습니다. <br>
                      배송 시간은 판매자가 검수를 위하여 상품을 검수센터로 보내는 속도에 따라 차이가 있습니다.
                    </p>
                    <div class="product__details__tab__content__item">
                      <h5>일반 구매</h5>
                      <p>- 거래가 체결된 시점부터 48시간(일요일•공휴일 제외) 내에 판매자가 상품을
                        발송해야 하며, 통상적으로 발송 후 1-2일 내에 KREAM 검수센터에 도착합니다.</p>
                      <p>- 검수센터에 도착한 상품은 입고 완료 후 3영업일 이내에 검수를 진행합니다.
                        검수 합격시 배송을 준비합니다.</p>
                      <p style="padding-left: 3em">* 상품 종류 및 상태에 따라
                        검수 소요 시간은 상이할 수 있으며, 구매의사 확인에 해당할 경우 구매자와 상담
                        진행으로 인해 지연이 발생할 수 있습니다.</p>
                      <p>- 검수센터 출고는 매 영업일에 진행하고 있으며, 출고 마감시간은 오후
                        5시입니다. 출고 마감시간 이후 검수 완료건은 운송장번호는 입력되지만 다음 영업일에
                        출고됩니다.</p>
                    </div>
                  </div>
                </div>
                <div class="tab-pane" id="tabs-6" role="tabpanel">
                  <div class="product__details__tab__content">
                    <div class="product__details__tab__content__item">
                      <h5>판매자의 상품이 검수센터에 도착하면 전담 검수팀이 철저한 분석과 검사로
                        정가품 확인을 진행합니다.</h5>
                      <p>- 검수센터에서는 정가품 여부를 확인하기 위하여, 지속적으로 데이터를 쌓고
                        분석하여 기록하고 있습니다.</p>
                      <p>- 업계 전문가로 구성된 검수팀은 박스와 상품의 라벨에서 바느질, 접착, 소재
                        등 모든 것을 검수합니다.</p>
                    </div>
                    <div class="product__details__tab__content__item">
                      <h5>
                        검수 결과는 불합격•검수 보류•합격의 세가지 상태로 결과가 변경됩니다. <a
                          href="#" style="font-size: 80%">검수기준 보기</a>
                      </h5>
                      <p>* 검수 합격: KREAM 검수택(Tag)이 부착되어 배송을 준비함</p>
                      <p>* 검수 보류: 앱에서 사진으로 상품의 상태 확인 및 구매 여부를 선택.
                        (24시간 이후 자동 검수 합격)</p>
                      <p>* 검수 불합격: 즉시 거래가 취소되고 구매하신 금액을 환불 처리함.(환불
                        수단은 결제 수단과 동일)</p>
                    </div>
                  </div>
                </div>
                <div class="tab-pane" id="tabs-7" role="tabpanel">
                  <div class="product__details__tab__content">
                    <p class="note">KREAM은 익명 거래를 기반으로 판매자가 판매하는 상품을
                      구매자가 실시간으로 구매하여 거래를 체결합니다.</p>
                    <div class="product__details__tab__content__item">
                      <h5>Infomation</h5>
                      <p>- 단순 변심이나 실수에 의한 취소/교환/반품이 불가능합니다. 상품을 원하지
                        않으시는 경우 언제든지 KREAM에서 재판매를 하실 수 있습니다.</p>
                      <p>- 상품 수령 후, 이상이 있는 경우 KREAM 고객센터로 문의해주시기
                        바랍니다.</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</section>
<!-- Shop Details Section End -->


<!-- Related Section Begin -->
<section class="related spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h3 class="related-title">Related Product</h3>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
        <div class="product__item">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-1.jpg">
            <span class="label">New</span>
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
            <h6>Piqué Biker Jacket</h6>
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
      <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
        <div class="product__item">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-2.jpg">
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
            <h6>Piqué Biker Jacket</h6>
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
      <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
        <div class="product__item sale">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-3.jpg">
            <span class="label">Sale</span>
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
            <h6>Multi-pocket Chest Bag</h6>
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
      <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
        <div class="product__item">
          <div class="product__item__pic set-bg"
            data-setbg="${contextPath}/resources/img/product/product-4.jpg">
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
            <h6>Diagonal Textured Cap</h6>
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
    </div>
  </div>
</section>

<!-- Related Section End -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
  src="https://www.gstatic.com/charts/loader.js"></script>

<script>
    /*팔로우 버튼 클릭*/
    $('.follower').click(function(){
        $('#followModal').modal('show');   //id가 "followModal"인 모달창을 열어준다. 
        $('.modal-title').text("사이즈");    //modal 의 header 부분에 "팔로우"라는 값을 넣어준다. 
        
        
        $('#clickForsizeAll').click(function(){
          $("#forSize").html($('#forAllSize').clone());
          $("#biglow").html($('#forLowBids').clone());
          $('#followModal').modal('hide');
         })
        
        $('#clickForSizeBtn0').click(function(){
          $("#forSize").html($('#clickForSize0').clone());
          $("#biglow").html($('#clickForMoney0').clone());
          $('#followModal').modal('hide');   //id가 "followModal"인 모달창을 닫아준다.
         })
         $('#clickForSizeBtn1').click(function(){
           $("#forSize").html($('#clickForSize1').clone());
           $("#biglow").html($('#clickForMoney1').clone());
           $('#followModal').modal('hide');
          })
          $('#clickForSizeBtn2').click(function(){
            $("#forSize").html($('#clickForSize2').clone());
            $("#biglow").html($('#clickForMoney2').clone());
            $('#followModal').modal('hide');
           })
           $('#clickForSizeBtn3').click(function(){
             $("#forSize").html($('#clickForSize3').clone());
             $("#biglow").html($('#clickForMoney3').clone());
             $('#followModal').modal('hide');
            })
            $('#clickForSizeBtn4').click(function(){
              $("#forSize").html($('#clickForSize4').clone());
              $("#biglow").html($('#clickForMoney4').clone());
              $('#followModal').modal('hide');
             })
             $('#clickForSizeBtn5').click(function(){
               $("#forSize").html($('#clickForSize5').clone());
               $("#biglow").html($('#clickForMoney5').clone());
               $('#followModal').modal('hide');
              })
              $('#clickForSizeBtn6').click(function(){
                $("#forSize").html($('#clickForSize6').clone());
                $("#biglow").html($('#clickForMoney6').clone());
                $('#followModal').modal('hide');
               })
               $('#clickForSizeBtn7').click(function(){
                 $("#forSize").html($('#clickForSize7').clone());
                 $("#biglow").html($('#clickForMoney7').clone());
                 $('#followModal').modal('hide');
                })
                $('#clickForSizeBtn8').click(function(){
                  $("#forSize").html($('#clickForSize8').clone());
                  $("#biglow").html($('#clickForMoney8').clone());
                  $('#followModal').modal('hide');
                 })
                 $('#clickForSizeBtn9').click(function(){
                   $("#forSize").html($('#clickForSize9').clone());
                   $("#biglow").html($('#clickForMoney9').clone());
                   $('#followModal').modal('hide');
                  })
                  $('#clickForSizeBtn10').click(function(){
                    $("#forSize").html($('#clickForSize10').clone());
                    $("#biglow").html($('#clickForMoney10').clone());
                    $('#followModal').modal('hide');
                   })
                   $('#clickForSizeBtn11').click(function(){
                     $("#forSize").html($('#clickForSize11').clone());
                     $("#biglow").html($('#clickForMoney11').clone());
                     $('#followModal').modal('hide');
                    })
                    $('#clickForSizeBtn12').click(function(){
                      $("#forSize").html($('#clickForSize12').clone());
                      $("#biglow").html($('#clickForMoney12').clone());
                      $('#followModal').modal('hide');
                     })
                     $('#clickForSizeBtn13').click(function(){
                       $("#forSize").html($('#clickForSize13').clone());
                       $("#biglow").html($('#clickForMoney13').clone());
                       $('#followModal').modal('hide');
                      })
                      $('#clickForSizeBtn14').click(function(){
                        $("#forSize").html($('#clickForSize14').clone());
                        $("#biglow").html($('#clickForMoney14').clone());
                        $('#followModal').modal('hide');
                       })
                       $('#clickForSizeBtn15').click(function(){
                         $("#forSize").html($('#clickForSize15').clone());
                         $("#biglow").html($('#clickForMoney15').clone());
                         $('#followModal').modal('hide');
                        })
                        $('#clickForSizeBtn16').click(function(){
                          $("#forSize").html($('#clickForSize16').clone());
                          $("#biglow").html($('#clickForMoney16').clone());
                          $('#followModal').modal('hide');
                         })
          
          
    });

    
    // 시세 스크립트 부분
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawBackgroundColor);

    function drawBackgroundColor() {
          var data = new google.visualization.DataTable();
          data.addColumn('number', '날짜');
          data.addColumn('number', '체결');

          data.addRows([
            [0, 100000],   [1, 125000],  [2, 80000],  [3, 90000],  [4, 18],  [5, 9],
            [6, 11],  [7, 27],  [8, 33],  [9, 40],  [10, 32], [11, 35]
          ]);

          var options = {
            hAxis: {
              title: '날짜'
            },
            vAxis: {
              title: 'ShuKream'
            },
            backgroundColor: 'white'
          };

          var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
          chart.draw(data, options);
        }
    
    
</script>

