let perPage =  prompt("Số diễn viên bạn muốn trong một trang là  !!!!", '');
let keyword = "";

$.ajax({
    url: "https://12d3a150.ngrok.io/v1/api/actor/search?page=0&perPage="+ perPage +"&name=" + keyword,
    success: function (result) {
        for(let i = 0; i < result.total; i++) {
            let page = i+1;
            $("#pagination").append("<a onclick='paginationActor("+ i +")' >"+ page +"</a>")
        }
        if (result.code == '00') {
            rederData(result.data.content);
        } else {
            alert(result.message);
        }

    },
    error: function (result) {
        console.log("error " + result);
    }
});


function loadData() {
    $("#lst-product").empty();
    $.ajax({
        url: "https://12d3a150.ngrok.io/v1/api/actors",
        type: "GET",
        success: function (result) {
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

function rederData(data) {
    data.map(item => {
        $('#lst-product').append(
        `<div class="card">
                  <img width="200" height="250" src="https://saobiz.net/wp-content/uploads/2016/11/ngoc-trinh-trang-da-blogtamsuvn5_01.jpg"
                  alt="Denim Jeans" style="width:100%">
                  <h3>${item.name}</h3>
                  <p class="price">${item.age} Tuổi</p>
                  <p>${item.country}</p>
                  <p><button onclick="detailActor(${item.id})" id="detailActor" data-toggle="modal"
         data-target="#modalAddProduct">Detail</button></p>
                  <p><button>Add to Cart</button></p>
                </div>`);
});
}

function searchActor() {
    let keyword = $('#actorName').val().trim().toLocaleLowerCase();
    if (keyword == null) {
        keyword = '';
    }
    $.ajax({
        type: "GET",
        url: "https://12d3a150.ngrok.io/v1/api/actor/search?page=0&perPage="+ perPage +"&name=" + keyword,
        processData: false,
        contentType: 'application/json',
        success: function (result) {
            $("#lst-product").empty();
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi
            if(result.code == "00") {
                $("#pagination").empty();
                rederData(result.data.content);
                for(let i = 0; i < result.total; i++) {
                    let page = i+1;
                    $("#pagination").append("<a onclick='paginationActor("+ i +")' >"+ page +"</a>")
                }
            }else {
                console.log(result.message);
            }
        }
    });
}


function detailActor(idActor) {
    $.ajax({
        type:"GET",
        url:"https://12d3a150.ngrok.io/v1/api/actor/"+ idActor,
        processData: false,
        contentType: 'application/json',
        success: function(result){
            $('#model-actor').empty();
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi
            let item = result.data;
            $('#model-actor').append(
            `<div class="form-group">
                <label for="actorName">Tên diễn viên :</label>
                <input value="${item.name}" type="text" class="form-control" id="actorName">
                <input type="hidden" id="productId">
            </div>
            <div class="form-group">
                <label for="actorAge">Tuổi diễn viên :</label>
                <input type="text" value="${item.age}" class="form-control" id="actorAge">
            </div>
            <div class="form-group">
                <label for="conutryActor">Đất nước diễn viên :</label>
                <input type="text" value="${item.country}" class="form-control" id="conutryActor">
            </div>`);
        }
    });
}

function paginationActor(page) {
    keyword = $('#actorName').val().trim().toLocaleLowerCase();
    if (keyword == null) {
        keyword = '';
    }
    $.ajax({
        type: "GET",
        url: "http://localhost:8083/v1/api/actor/search?page=" + page + "&perPage="+ perPage +"&name=" + keyword,
        processData: false,
        contentType: 'application/json',
        success: function (result) {
            $("#lst-product").empty();
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi
            if(result.code == "00") {
                rederData(result.data.content);
                $("#totalPage").val(page);
            }
            else {
                console.log(result.message);
            }
        }
    });
}
});
