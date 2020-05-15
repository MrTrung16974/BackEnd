$.ajax({
    url: "http://localhost:8080/v1/api/books",
    success: function (result) {
        console.log("data response", result);
        if(result.code == '200') {
            rederData(result.data);
        }else {
            alert(result.message);
        }
    },
    error: function (result) {
        console.log("error " + result);
    }
});

$.ajax({
    url: "http://localhost:8080/v1/api/categorys",
    success: function (result) {
        console.log("data response", result);
        if(result.code == '200') {
            rederCategory(result.data);
        }else {
            alert(result.message);
        }
    },
    error: function (result) {
        console.log("error " + result);
    }
});

function rederCategory(data) {
    console.log(data);
        data.map(item => {
            $('#categoryBook').append(`
            <option value=${item.id}>${item.name}</option>
            `);
    });
}

function loadData() {
    $("#lst-product").empty();
    $.ajax({
        url: "http://localhost:8080/v1/api/books",
        success: function (result) {
            console.log("data response", result);
            if(result.code == '200') {
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

function forStar(star) {
    for (let i=1; i <= 5; i++) {
        if(i > star) {
            $("#starBook").append("<i class=\"far fa-star\"></i>");
        }else {
            $("#starBook").append("<i class=\"fas fa-star\"></i>");
        }
    }
}

function rederData(data) {
    console.log(data);
    if(data != null) {
        $("#NullBook").text("");
        data.map(item => {
            $('#list-book').append(
            `<input type="hidden" id="idBook">
            <div class="card h-100">
                <input type="hidden" id="getStarBook" value=${item.star} />
                <div class="labels">
                    <div class="label-new bg-success text-white text-center py-1">New</div>
                    <div class="label-sale bg-primary text-white text-center py-1">Sale</div>
                </div>
                <img width="100%" src=${item.image} height="200" class="img-fluid" id="newImageBook" alt="">
                <div class="card-body position-relative d-flex flex-column">
                    <a href="#" class="add-to-cart bg-primary text-white" data-toggle="tooltip" data-placement="left"
                       title="Add To Cart">
                        <i class="fa fa-opencart" aria-hidden="true"></i>
                    </a>
                    <h3 class="text-success">${item.name}</h3>
                    <p >Cửu Bá Đao</p>
                    <div id="starBook" class="rating text-warning">
                        
                    </div>
                    <h4  class="text-success">$ ${item.price}</h4>
                    <p>${item.description}</p>
                    <a class="btn btn-success btn-block mt-auto">
                        <i class="fa fa-eye" aria-hidden="true"></i>
                        Chi tiết
                    </a>

                    <a id="deleteBook"
                       class="btn btn-danger btn-block mt-3"><i class="fa fa-eye" aria-hidden="true"></i>
                        Xóa
                    </a>
                </div>
            </div>`);
            let star = $("#getStarBook").val();
            console.log(star);
            forStar(star);
        });
    }else{
        $("#NullBook").text("Sản phẩm không tồn tại");
    }

}

function searchBook() {
    console.log("OK");
    let keyword = $("#KeyWord").val().trim();
    if(keyword == null) {
        keyword = '';
    }
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/v1/api/search?keyword="+ keyword,
        processData: false,
        contentType: 'application/json',
        success: function(result){
            $("#list-book").empty();
            rederData(result.data);
            // server trả về HTTP status code là 200 => Thành công
            //hàm đc thực thi khi request thành công không có lỗi

        }
    });
}

$(document).ready(function() {
    $("#createBook").on('click', function () {
        let dataJson = {
            name: $("#nameBook").val().trim(),
            description: $("#descriptionBook").val().trim(),
            price: $("#priceBook").val().trim(),
            star: $("#starBook").val().trim(),
            image:  $("#imageBook").attr('src'),
            categoryId: $("#categoryBook").val(),
            nameAuthor: $("#nameAuthorBook").val().trim(),
            birthdayAuthor: $("#birthdayAuthorBook").val().trim()
        };
        console.log(dataJson);
        $.ajax({
            url: "http://localhost:8080/v1/api/book",
            type: "POST",
            data: JSON.stringify(dataJson),
            contentType: "application/json",
            success: function (result) {
                console.log("response" + result.message);
                alert("Bạn đã thêm sản phẩm mới thành công");
                $('#modalAddBook').modal('hide');
                toastr.success('Upload thành công ', 'Haha!');
                loadData();
            },
            error: function (result) {
                alert("Lỗi hệ thống")
                console.log("error " + result.message);
            }
        });
    });

    $("#deleteBook").on('click', function() {
        let idea =  confirm("Bạn chắc muốn xóa chớ ngáo đó !!!!");
        if(idea) {
            $.ajax({
                url: "http://localhost:8080/v1/api/book/" + $("#idBook").val(),
                type: "DELETE",
                success: function (result) {
                    console.log("response" + result.message);
                    alert("Bạn đã xóa thành công!");
                    loadData()
                },
                error: function (result) {
                    console.log("error " + result.message);
                    alert("Lỗi hệ thống!");
                }
            });
        }
    });

    $("#bookImage").on("change", function () {
        var formData = new FormData();
        formData.append('file', $('#bookImage')[0].files[0]);

        $.ajax({
            url: 'http://localhost:8080/v1/api/upload',
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                $("#imageBook").attr("src", data);
                toastr.success('Upload ảnh thành công ', 'Haha!');
            },
            error: function () {
                toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', 'Inconceivable!');
            }
        })
    });
});