$(document).ready(function () {
    var idProduct = new URLSearchParams(window.location.search).get("id");
    console.log(idProduct);

    $.ajax({
        type: "GET",
        url: "http://localhost:8099/v1/api/product/" + idProduct,
        processData: false,
        success: function (response) {
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi
            if(response.code == "00") {
                console.log(response.data);
                rederDataProductDetail(response.data);
            }
            else {
                console.log(response.message);
            }
        }
    });

    function rederDataProductDetail(item) {
        $("#single-product-detail").empty();
        if(item != null) {
            $('#single-product-detail').html(
                `<div class="col-12 col-lg-7">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(${item.image.imageOne});">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="1" style="background-image: url(${item.image.imageTwo});">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="2" style="background-image: url(${item.image.imageThree});">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="3" style="background-image: url(${item.image.imageFour});">
                                    </li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <a class="gallery_img" href="${item.image.imageOne}">
                                            <img class="d-block w-100" src="${item.image.imageOne}" alt="First slide">
                                        </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="gallery_img" href="${item.image.imageTwo}">
                                            <img class="d-block w-100" src="${item.image.imageTwo}" alt="Second slide">
                                        </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="gallery_img" href="${item.image.imageThree}">
                                            <img class="d-block w-100" src="${item.image.imageThree}" alt="Third slide">
                                        </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="gallery_img" href="${item.image.imageFour}">
                                            <img class="d-block w-100" src="${item.image.imageFour}" alt="Fourth slide">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                 <div class="col-12 col-lg-5">
                        <div class="single_product_desc">
                            <!-- Product Meta Data -->
                            <div class="product-meta-data">
                                <div class="line"></div>
                                <p class="product-price">${item.price}</p>
                                <a href="/product-details">
                                    <h6>${item.name}</h6>
                                </a>
                                <!-- Ratings & Review -->
                                <div class="ratings-review mb-15 d-flex align-items-center justify-content-between">
                                    <div class="ratings">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </div>
                                    <div class="review">
                                        <a href="#">Write A Review</a>
                                    </div>
                                </div>
                                <!-- Avaiable -->
                                <p class="avaibility"><i class="fa fa-circle"></i> In Stock</p>
                            </div>
        
                            <div class="short_overview my-5">
                                <p>${item.description}</p>
                            </div>
        
                            <!-- Add to Cart Form -->
                            <form class="cart clearfix" method="post">
                                <div class="cart-btn d-flex mb-50">
                                    <p>Qty</p>
                                    <div class="quantity">
                                        <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-caret-down" aria-hidden="true"></i></span>
                                        <input type="number" class="qty-text" id="qty" step="1" min="1" max="300" name="quantity" value="${item.number}">
                                        <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-caret-up" aria-hidden="true"></i></span>
                                    </div>
                                </div>
                                <button type="button" onclick="addToCastDetailDB(${item.id})" name="addtocart" value="5" class="btn amado-btn">Add to cart</button>
                            </form>
        
                    </div>`
            );
        }else{
            $("#single-product-detail").text("Sản phẩm không tồn tại");
        }
    }
});