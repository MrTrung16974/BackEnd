var keyword = "";
var pageDefault = 0;

function search() {
    keyword = $('#search').val().trim().toLocaleLowerCase();
    if (keyword == null) {
        keyword = '';
    }
    $.ajax({
        type: "GET",
        url: "http://localhost:8099/v1/api/product/search?name=" + keyword + "&page=0&perPage=10",
        processData: false,
        contentType: 'application/json',
        success: function (response) {
            $("#lst-product").empty();
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi
            if(response.code == "00") {
                rederData(response.data.content);
                let totalPage = response.data.totalPages;
                forPagination(totalPage);
            }
            else {
                console.log(response.message);
            }
        }
    });
}

function paginationProduct(page) {
    pageDefault = page;
    keyword = $('#search').val().trim().toLocaleLowerCase();
    if (keyword == null) {
        keyword = '';
    }
    $.ajax({
        type: "GET",
        url: "http://localhost:8099/v1/api/product/search?name=" + keyword + "&page="+pageDefault+"&perPage=10",
        processData: false,
        contentType: 'application/json',
        success: function (response) {
            $("#lst-product").empty();
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi
            if(response.code == "00") {
                rederData(response.data.content);
                let totalPage = response.data.totalPages;
                forPagination(totalPage);
            }
            else {
                console.log(response.message);
            }
        }
    });
}

function forPagination(totalPage) {
    $("#pagination").empty();
    for(let i = 0; i < totalPage; i++) {
        if(i == pageDefault) {
            $("#pagination").append(`<li class="page-item active"><a class="page-link" onclick='paginationProduct(${i})' >0${i+1}.</a></li>`);
        }else {
            $("#pagination").append(`<li class="page-item"><a class="page-link" onclick='paginationProduct(${i})' >0${i+1}.</a></li>`);
        }
    }
}

function forStar(star) {
    let starWrite = "";
    for (let i=1; i <= 5; i++) {
        if(i > star) {
            starWrite += "<i class=\"fa fa-star\" aria-hidden=\"true\"></i>";
        }else {
            starWrite += "<i class=\"fa fa-star\" aria-hidden=\"false\"></i>";
        }
    }
    return starWrite;
}

function rederData(data) {
    $("#lst-product").empty();
    if(data != null) {
        data.map(item => {
            $('#lst-product').append(
                `<div class="col-12 col-sm-6 col-md-12 col-xl-6">
                    <div class="single-product-wrapper">
                        <!-- Product Image -->
                        <div class="product-img">
                            <img src="${item.image.imageOne}" alt="">
                            <!-- Hover Thumb -->
                            <img class="hover-img" src="${item.image.imageTwo}" alt="">
                        </div>

                        <!-- Product Description -->
                        <div class="product-description d-flex align-items-center justify-content-between">
                            <!-- Product Meta Data -->
                            <div class="product-meta-data">
                                <div class="line"></div>
                                <p class="product-price">$${item.price}</p>
                                <a href="product-details.html">
                                    <h6>${item.name}</h6>
                                </a>
                            </div>
                            <!-- Ratings & Cart -->
                            <div class="ratings-cart text-right">
                                <div id="ratings" class="ratings">
                                </div>
                                <div class="cart">
                                    <a href="cart.html" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="img/core-img/cart.png" alt=""></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>`);
        });
    }else{
        $("#lst-product").text("Sản phẩm không tồn tại");
    }
}
