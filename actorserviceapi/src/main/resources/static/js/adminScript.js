function loadData() {
    $("#lst-product").empty();
    $.ajax({
        url: "http://localhost:8080/v1/api/products",
        success: function (result) {
            console.log("data response", result);
            if(result.code == '00') {
                rederData(result.data);
            }else {
                alert(result.message);
            }
        },
        error: function (result) {
            console.log("error " + result);
        }
    });
}

function addProduct () {
    let dataJson = {
        name: $("#nameActor").val().trim(),
        age: $("#ageActor").val().trim(),
        conutry: $("#conutryActor").val()
    };
    $.ajax({
        url: "http://localhost:8080/v1/api/product",
        type: "POST",
        data: JSON.stringify(dataJson),
        contentType: "application/json",
        success: function (result) {
            console.log("response" + result.message);
            alert("Bạn đã thêm sản phẩm mới thành công")
            loadData()
        },
        error: function (result) {
            alert("Lỗi hệ thống")
            console.log("error " + result.message);
        }
    });
}

function editProduct() {
    let updateData = {
        name: $("#nameActor").val().trim(),
        age: $("#ageActor").val().trim(),
        conutry: $("#conutryActor").val()
    }
    $.ajax({
        url: "http://localhost:8080/v1/api/actor/" + $("#idActor").val(),
        type: "PUT",
        data: JSON.stringify(updateData),
        contentType: "application/json",
        success: function (result) {
            console.log("response" + result.message);
            alert("Bạn đã sửa thành công!")
            loadData()
        },
        error: function (result) {
            alert("Lỗi hệ thống!")
            console.log("error " + result.message);
        }
    });
}

function deleteProduct() {
    let idea =  confirm("Bạn chắc muốn xóa chớ ngáo đó !!!!");
    if(idea) {
        $.ajax({
            url: "http://localhost:8080/v1/api/actor/" + $("#idActor").val(),
            type: "DELETE",
            success: function (result) {
                console.log("response" + result.message);
                alert("Bạn đã xóa thành công!")
                loadData()
            },
            error: function (result) {
                console.log("error " + result.message);
                alert("Lỗi hệ thống!")
            }
        });
    }
}

$.ajax({
    url: "http://localhost:8080/v1/api/products",
    success: function (result) {
        console.log("data response", result);
        if(result.code == '00') {
            rederData(result.data);
        }else {
            alert(result.message);
        }
    },
    error: function (result) {
        console.log("error " + result);
    }
});
function rederData(data) {
    console.log("OK");
    data.map(item => {
        $('#lst-product').append(
        `<div class="card">
                  <img src=${item.image}
                  alt="Denim Jeans" style="width:100%">
                  <h1>${item.name}</h1>
                  <p class="price">${item.price}</p>
                  <p>${item.description}</p>
                  <p><button onclick="setProductId(${item.id})">Edit</button></p>
                  <p><button onclick="setProductId(${item.id}), deleteProduct(${item.id})">Delete</button></p>
                  <p><button>Add to Cart</button></p>
                </div>`
    );
});
}

function setProductId(id) {
    $("#idProduct").val(id);
}