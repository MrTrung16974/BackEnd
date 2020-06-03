var user = getCookie("user");
console.log(user);
var keyword = "";
var pageDefault = 0;
var singleProduct = null;
var cart = {
    id: "",
    buyer: "",
    listProduct: [],
    status: ""
};


var url      = window.location.href;
var origin   = window.location.origin;
var pathname = window.location.pathname;
// Returns path only (/path/example.html)

console.log(singleProduct);
if(singleProduct != null) {
    console.log(singleProduct + "Ok");
    rederDataProductDetail(singleProduct);
}

switch (pathname) {
        case "/home":
            $("li.home").addClass("active");
            break;
        case "/shop":
            $("li.shop").addClass("active");
            break;
        case "/cart":
            $("li.cart").addClass("active");
            break;
        case "/checkout":
            $("li.checkout").addClass("active");
            break;
        default :
            $("li").removeClass("active");
            break;
    }

if(url == origin+"/login?error=true") {
    setCookie("user", "");
}

function saveUserName() {
    let username = $("#username").val().trim();
    if(username != null) {
        setCookie("user", username);
    }
    console.log(username);
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
                    <div  class="single-product-wrapper">
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
                                <a onclick="detailProduct(${item.id})">
                                    <h6>${item.name}</h6>
                                </a>
                            </div>
                            <!-- Ratings & Cart -->
                            <div class="ratings-cart text-right">
                                <div id="ratings" class="ratings">
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                </div>
                                <div class="cart">
                                    <a onclick="addToCastDB(${item.id})" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="img/core-img/cart.png" alt=""></a>
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

function rederDataCastBoxUp(data) {
    $("#box-up-lst-prodcut-in-cast").empty();
    if(data != null) {
        data.map(item => {
            $('#box-up-lst-prodcut-in-cast').append(
                `<tr style="position: relative;">
                    <td class="cart_product_img">
                        <a href="#"><img width="50" height="50" src="${item.image.imageOne}" alt="Product"></a>
                    </td>
                    <td class="cart_product_desc">
                        <h5>${item.name}</h5>
                    </td>
                    <td class="price">
                        <span>$${item.price}</span>
                    </td>
                    <td style="position: relative;" onclick="deleteItem(${item.id})" class="remove-item">
                        <span>x</span>
                    </td>
                </tr>`
            );
        });
    }else{
        $("#box-up-lst-prodcut-in-cast").text("Sản phẩm không tồn tại");
    }
}

function rederDataProductDetail(data) {
    $("#single-product-detail").empty();
    if(data != null) {
        data.map(item => {
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
        });
    }else{
        $("#single-product-detail").text("Sản phẩm không tồn tại");
    }
}

function rederDataCast(data) {
    $("#lst-product-in-cast").empty();
    if (data != null) {
        data.map(item => {
            $('#lst-product-in-cast').append(
                `<tr style="position: relative;">
                <td class="cart_product_img">
                    <a href="#"><img src="${item.image.imageOne}" alt="Product"></a>
                </td>
                <td class="cart_product_desc">
                    <h5>${item.name}</h5>
                </td>
                <td class="price">
                    <span>$${item.price}</span>
                </td>
                <td class="qty">
                    <div class="qty-btn d-flex">
                        <p>Qty</p>
                        <div class="quantity">
                            <span class="qty-minus" onclick="removeItem(${item.id})"><i class="fa fa-minus" aria-hidden="true"></i></span>
                            <input type="number" class="qty-text" id="qty2" step="1" min="1" max="300" name="quantity" value="${item.number}">
                            <span class="qty-plus" onclick="addItem(${item.id})"><i class="fa fa-plus" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </td>
                <td onclick="deleteItem(${item.id})" class="remove-item">
                    <span>x</span>
                </td>
            </tr>`
            );
        });
    } else {
        $("#lst-product-in-cast").text("Sản phẩm không tồn tại");
    }
}

function getTotalProductInCast(cast) {
    let total = cart.listProduct.length;
    if (total <= 0) {
        $("#total-cast").text(`(0)`);
    } else {
        $("#total-cast").text(`(${total})`);
    }
}

function getPriceProductInCast(cast) {
    let price_number = 0;
    if (cast.listProduct != null) {
        let length = cast.listProduct.length;
        for (let i = 0; i < length; i++) {
            price_number += (cast.listProduct[i].price * cast.listProduct[i].number);
        }
        $("#price-number").text("$" + price_number);
    }

}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}