$( document ).ready(function () {
    var keyword = "";
    var pageDefault = 0;
    var pathname = window.location.pathname;
    // Returns path only (/path/example.html)
    switch (pathname) {
        case "/home":
            console.log("home");
            $("li#home").addClass("active");
            break;
        case "/shop":
            console.log("shop");
            $("li#shop").addClass("active");
            break;
        case "/product-details":
            console.log("product-details");
            $("li#product-details").addClass("active");
            break;
        case "/cart":
            console.log("cart");
            $("li#cart").addClass("active");
            break;
        case "/checkout":
            console.log("checkout");
            $("li#checkout").addClass("active");
            break;
        default :
            console.log("default");
            $("li").removeClass("active");
            break;
    }

    $.ajax({
        url: "http://localhost:8099/v1/api/product/search?name="+keyword+"&page="+pageDefault+"&perPage=10",
        type: "GET",
        success: function (response) {
            if(response.code == "00") {
                rederData(response.data.content);
                let totalPage = response.data.totalPages;
                forPagination(totalPage);
            }else {
                toastr.error('Find not data!', response.message);
            }
        },
        error: function (result) {
            toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', response.message);
        }
    });
});