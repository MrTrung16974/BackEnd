// khai báo biến
var user = getCookie("user");
var username = getCookie("username");
var keyword = "";
var checkLogin = false;
var sort = 1;
var pageDefault = 0;
var cart = {
    id: "",
    image: "",
    buyer: "",
    listProduct: [],
    status: ""
};
var comment = {
    image: "",
    buyer: "",
    content: "",
    createAt: ""
};

var url      = window.location.href;
var origin   = window.location.origin;
var pathname = window.location.pathname;
// Returns path only (/path/example.html)


$(".icon-heart").hover(function () {
    let icon = $(".icon-heart");
    let temp = -1;
    if(temp != 1) {
        console.log("C0")
        this.icon.addClass('fa fa-heart');
    }else {
        console.log("Ko")
        this.icon.addClass('fa fa-heart-o');
    }
    temp *= -1;
});

// reder chung
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
        case "/favourite":
            $("li.favourite").addClass("active");
            break;
        default :
            $("li").removeClass("active");
            break;
    }

// logic cart
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

function forPagination(totalPage) {
    $("#pagination").empty();
    for(let i = 0; i < totalPage; i++) {
        if(i == pageDefault) {
            $("#pagination").append(`<li class="page-item active"><a class="page-link" onclick='searchProduct(${i})' >0${i+1}.</a></li>`);
        }else {
            $("#pagination").append(`<li class="page-item"><a class="page-link" onclick='searchProduct(${i})' >0${i+1}.</a></li>`);
        }
    }
}

function getTotalProductInCast(cast) {
    let total = cart.listProduct.length;
    if (total <= 0) {
        $("#total-cast").text(`(0)`);
        $("#total-in-cast").text(`0 sản phẩm`);
    } else {
        $("#total-cast").text(`(${total})`);
        $("#total-in-cast").text(`${total} sản phẩm`);
    }
}
function getTotalProductInFavourite(data) {
    let total = data.length;
    if (total <= 0) {
        $("#total-favourite").text(`(0)`);
    } else {
        $("#total-favourite").text(`(${total})`);
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

//logic user name

function loadPageCast() {
    if(user != null && user != "") {
        window.location.href = "http://localhost:8089/cart"
    }else {
        window.location.href = "http://localhost:8089/login"

    }
}

function loadPageFavourite() {
    if(user != null && user != "") {
        window.location.href = "http://localhost:8089/favourite"
    }else {
        window.location.href = "http://localhost:8089/login"

    }
}

// logic cookie
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

function deleteCookie( name, path, domain ) {
    if( getCookie( name ) ) {
        document.cookie = name + "=" +
            ((path) ? ";path="+path:"")+
            ((domain)?";domain="+domain:"") +
            ";expires=Thu, 01 Jan 1970 00:00:01 GMT";
    }
}