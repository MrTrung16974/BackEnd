function loadData() {
    $("#lst-product").empty();
    $.ajax({
        url: "http://localhost:8080/v1/api/books",
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
        console.log($("#imageBook").attr('src'));
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
                window.location.reload();
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
                    window.location.reload();
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
            url: 'http://localhost:8080/book/upload',
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
    })

    $("#searchBook").on('click', function () {
        let keyword = $('#BookKeyWord').val().trim().toLocaleLowerCase();
        if(keyword == null) {
            keyword = '';
        }
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/book/search?keyword="+ keyword,
            processData: false,
            contentType: 'application/json',
            success: function(){
                // server trả về HTTP status code là 200 => Thành công
                //hàm đc thực thi khi request thành công không có lỗi
                window.location.href = "http://localhost:8080/book/search?keyword="+ keyword;
            }
        });
    });
});