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
                    let productName = product.PRODUCT_NAME;
                    let productImgIdx = product.IMG_PRODUCT_IDX;
					html += `
						<div class="search_result" onclick="location.href='/shuKream/shop/list.do?'">
							<img width="70px" height="70px" src="/shuKream/resources/img/product/product-${productImgIdx}.jpg" alt="">
							<span>${productName}</span>
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