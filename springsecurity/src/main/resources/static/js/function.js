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

function searchProduct() {
    keyword = $('#keysearch').val().trim().toLocaleLowerCase();
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
    keyword = $('#keysearch').val().trim().toLocaleLowerCase();
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

function detailProduct(idProduct) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8099/v1/api/product/" + idProduct,
        processData: false,
        success: function (response) {
            $("#lst-product").empty();
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi
            if(response.code == "00") {
                rederDataProductDetail(response.data);
            }
            else {
                console.log(response.message);
            }
        }
    });
}

// cart product
getProductInCast();
function getProductInCast() {
    $.ajax({
        url: "http://localhost:8099/order/products/hiep",
        type: "GET",
        success: function (response) {
            if(response.code = '00') {
                cart = response.data;
                if(cart.listProduct != null) {
                    getTotalProductInCast(cart);
                    rederDataCast(cart.listProduct);
                    rederDataCastBoxUp(cart.listProduct);
                    if(cart.listProduct[0] != null) {
                        getPriceProductInCast(cart);
                    }
                }
            }
        },
        error: function (error) {
            toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', response.message);
        }
    });
}

function addToCastDetailDB(idProduct) {
    let number = $("#qty").val().trim();
    let updateCastRequest = {
        name: "hiep",
        listProductCast: [{
            id: idProduct,
            number: number,
            type: 1
        }]
    };
    $.ajax({
        url: "http://localhost:8099/order/update/" + cart.id,
        type: "POST",
        data: JSON.stringify(updateCastRequest),
        contentType: "application/json",
        success: function (response) {
            if (response.code = "00") {
                cart = response.data;
                if(cart.listProduct != null) {
                    getTotalProductInCast(cart);
                    rederDataCast(cart.listProduct);
                    getPriceProductInCast(cart);
                    if(cart.listProduct[0] != null) {
                        toastr.error('Add product success!', "HAHA");
                    }
                }
            }
        },
        error: function (error) {
            toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', response.message);
        }
    });
}

function addToCastDB(idProduct) {
    let updateCastRequest = {
        name: "hiep",
        listProductCast: [{
            id: idProduct,
            number: 1,
            type: 1
        }]
    };
    $.ajax({
        url: "http://localhost:8099/order/update/" + cart.id,
        type: "POST",
        data: JSON.stringify(updateCastRequest),
        contentType: "application/json",
        success: function (response) {
            if (response.code = "00") {
                cart = response.data;
                if(cart.listProduct != null) {
                    getTotalProductInCast(cart);
                    rederDataCast(cart.listProduct);
                    getPriceProductInCast(cart);
                    rederDataCastBoxUp(cart.listProduct);
                    if(cart.listProduct[0] != null) {
                        toastr.error('Add product success!', "HAHA");
                    }
                }
            }
        },
        error: function (error) {
            toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', response.message);
        }
    });
}

function deleteItem(idProduct) {
    let updateCastRequest = {
        name: "hiep",
        listProductCast: [{
            id: idProduct,
            number: 1,
            type: 3
        }]
    };
    $.ajax({
        url: "http://localhost:8099/order/update/" + cart.id,
        type: "POST",
        data: JSON.stringify(updateCastRequest),
        contentType: "application/json",
        success: function (response) {
            if (response.code = "00") {
                cart = response.data;
                if(cart.listProduct != null) {
                    getTotalProductInCast(cart);
                    rederDataCast(cart.listProduct);
                    getPriceProductInCast(cart);
                    rederDataCastBoxUp(cart.listProduct);
                    if(cart.listProduct[0] != null) {
                        toastr.error('Delete product success!',  "HAHA");
                    }
                }
            }
        },
        error: function (error) {
            toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', response.message);
        }
    });
}

function addItem(idProduct) {
    let updateCastRequest = {
        name: "hiep",
        listProductCast: [{
            id: idProduct,
            number: 1,
            type: 1
        }]
    };
    $.ajax({
        url: "http://localhost:8099/order/update/" + cart.id,
        type: "POST",
        data: JSON.stringify(updateCastRequest),
        contentType: "application/json",
        success: function (response) {
            if (response.code = "00") {
                cart = response.data;
                if(cart.listProduct != null) {
                    getTotalProductInCast(cart);
                    rederDataCast(cart.listProduct);
                    getPriceProductInCast(cart);
                    rederDataCastBoxUp(cart.listProduct);
                    if(cart.listProduct[0] != null) {
                        toastr.error('Add product success!', "HAHA");
                    }
                }
            }
        },
        error: function (error) {
            toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', response.message);
        }
    });
}

function removeItem(idProduct) {
    let updateCastRequest = {
        name: "hiep",
        listProductCast: [{
            id: idProduct,
            number: 1,
            type: 2
        }]
    };
    $.ajax({
        url: "http://localhost:8099/order/update/" + cart.id,
        type: "POST",
        data: JSON.stringify(updateCastRequest),
        contentType: "application/json",
        success: function (response) {
            if (response.code = "00") {
                cart = response.data;
                if(cart.listProduct != null) {
                    getTotalProductInCast(cart);
                    rederDataCast(cart.listProduct);
                    getPriceProductInCast(cart);
                    rederDataCastBoxUp(cart.listProduct);
                    if(cart.listProduct[0] != null) {
                        toastr.error('Delete product success!',  "HAHA");
                    }
                }
            }
        },
        error: function (error) {
            toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', response.message);
        }
    });
}


function paymentToCastDB(idProduct) {
    $.ajax({
        url: "http://localhost:8099/order/update/" + cart.id,
        type: "POST",
        success: function (response) {
            if (response.code = "00") {
                cart = response.data;
                if(cart.listProduct != null) {
                    getTotalProductInCast(cart);
                    rederDataCast(cart.listProduct);
                    getPriceProductInCast(cart);
                    rederDataCastBoxUp(cart.listProduct);
                    if(cart.listProduct[0] != null) {
                        toastr.error('Pay product success!',  "HAHA");
                    }
                }
            }
        },
        error: function (error) {
            toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', response.message);
        }
    });
}