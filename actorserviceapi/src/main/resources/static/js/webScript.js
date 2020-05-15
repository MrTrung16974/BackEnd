function loadData() {
    $("#lst-product").empty();
    $.ajax({
        url: "http://a701d613.ngrok.io/v1/api/actors",
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

$("#searchActor").on('click', function () {
    let keyword = $('#actorName').val().trim().toLocaleLowerCase();
    if(keyword == null) {
        keyword = '';
    }
    console.log(keyword);
    $.ajax({
        type:"GET",
        url:"http://a701d613.ngrok.io/v1/api/actor/search?page=0&perPage=5&name="+ keyword,
        processData: false,
        contentType: 'application/json',
        success: function(result){
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi
            $("#lst-product").empty();
            result.map(item => {
                $('#lst-product').append(
                `<div class="card">
                      <img width="200" height="250" src="https://saobiz.net/wp-content/uploads/2016/11/ngoc-trinh-trang-da-blogtamsuvn5_01.jpg"
                      alt="Denim Jeans" style="width:100%">
                      <h1>${item.name}</h1>
                      <p class="price">${item.age}</p>
                      <p>${item.country}</p>
                      <p><button id="showDetail" >Detail</button></p>
                      <p><button>Add to Cart</button></p>
                    </div>`
            );
        });
        }
    });
});

$("#detailActor").on('click', function () {

    $.ajax({
        type:"GET",
        url:"http://a701d613.ngrok.io/v1/api/actor/search?name="+  $("#idBook").val(),
        processData: false,
        contentType: 'application/json',
        success: function(result){
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi
            $('#body-actor').append(
            `<div class="form-group">
                <label for="actorName">Tên diễn viên :</label>
                <input value=${item.name}  type="text" class="form-control" id="actorName">
                <input type="hidden" id="productId">
            </div>
            <div class="form-group">
                <label for="actorAge">Tuổi diễn viên :</label>
                <input type="text" value=${item.age} class="form-control" id="actorAge">
            </div>
            <div class="form-group">
                <label for="conutryActor">Đất nước diễn viên :</label>
                <input type="number" value=${item.country} class="form-control" id="conutryActor">
            </div>`);
        }
    });
});

$.ajax({
    url: "http://a701d613.ngrok.io/v1/api/actors",
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
