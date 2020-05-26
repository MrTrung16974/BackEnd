$.ajax({
    url: "http://localhost:8099/v1/api/product/search?page=0&perPage=0&name=",
    type: "GET",
    success: function (result) {
        if(result != null) {
            $("#list-product").empty();
            rederData(result);
        }else {
            alert("Find not data");
        }
    },
    error: function (result) {
        console.log("error " + result);
    }
});

let productCast = getCookie("productCart");
$.ajax({
    url: "http://localhost:8099/v1/api/get-all-cookie",
    type: "POST",
    data: productCast,
    processData: false,
    contentType: false,
    success: function (result) {
        if(result != null) {
            console.log(result);
        }else {
            alert("Find not data");
        }
    },
    error: function (result) {
        console.log("error " + result);
    }
});

function rederData(data) {
    data.map(item => {
        $('#list-product').append(
        `<div class="card col-3" style="width: 18rem;">
            <img src="https://cf.shopee.vn/file/110be78c00d495ae468f1d1bd9f51815" class="card-img-top" alt="...">
            <div class="card-body" >
                <h5 class="card-title">${item.id}</h5>
                <h5 class="card-title">${item.name}</h5>
                <p class="card-text">${item.price}</p>
                <p class="card-text">${item.number}</p>
                <button class="btn btn-primary" onclick="addToCast('${item.id}')">Add to cart</button>
            </div>
        </div>`);
    });
}
