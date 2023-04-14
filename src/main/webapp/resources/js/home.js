let displayList = $("#displayList");
$(".search_wrap").hide();

$("#search-input").keyup(function () {
    let word = $(this).val().trim();
                let html = "";

    if (word.length === 0) {
        $(".search_wrap").hide();
    } else {
        $.ajax({
            url: "/shuKream/home/wordSearch.do/" + word,
            type: "GET",
            dataType: "json",
            success: function (data) {

                data.products.forEach(function (product,index) {
                    let productEnName = product.PRODUCT_NAME_EN;
                    let productKrName = product.PRODUCT_NAME_KOR;
                    let productID = product.PRODUCT_ID;
                    let productImgFileName = product.IMG_FILE;
					html += `
						<div class="search_result" onclick="location.href='/shuKream/shop/shopDetails.do?product_id=${productID}'">
							<img width="70px" height="70px" src="/shuKream/resources/img/product/sneakers/${productImgFileName}" alt="">
							<div style='display:inline-block; vertical-align:middle;'><span><strong>${productEnName}</strong></span><br>
							<span>${productKrName}</span></div>
						</div>
						  `;
                });
                displayList.html(html);
                $(".search_wrap").show();
            },
            error: function (request, status, error) {
                alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
            }
        });
    }
});