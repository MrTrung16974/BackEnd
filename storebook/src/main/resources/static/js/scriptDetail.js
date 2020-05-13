function editProduct() {
    let updateData = {
        name: $("#nameBook").val().trim(),
        description: $("#descriptionBook").val().trim(),
        price: $("#priceBook").val().trim(),
        star: $("#starBook").val().trim(),
        image:  $("#bookImage").attr('src'),
        categoryId: $("#categoryBook").val(),
        nameauthor: $("#nameAuthorBook").val().trim(),
        birthdayAuthor: $("#birthdayAuthorBook").val().trim()
    }
    $.ajax({
        url: "http://localhost:8080/v1/api/book/" + $("#idProduct").val(),
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

    $("#imageBook").on("change", function () {
        var formData = new FormData();
        formData.append('file', $('#imageBook')[0].files[0]);

        $.ajax({
            url: 'http://localhost:8080/book/upload',
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                console.log(data);
                $("#bookImage").attr("src", data);
                toastr.success('Upload ảnh thành công ', 'Haha!');
            },
            error: function () {
                toastr.error('có lỗi xảy ra . Xin vui lòng thử lại', 'Inconceivable!');
            }
        })
    })
}