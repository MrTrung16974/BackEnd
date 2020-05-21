var listProductCart = [];
let listProduct = getCookie("productCart");
$("#total-cast").text(getTotalCast(listProduct));

// var x = document.cookie;
// console.log("Giá trị trước khi thêm cookie là " + x);
// document.cookie = "Username-trung";
// console.log("Giá trị sau khi thêm cookie là " + x);


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
function getTotalCast(listProduct) {
    let count = 0;
    for(var i = 0; i <listProduct.length; i++) {
        var c = listProduct.charAt(i);
        if(c == ",") {
            count++;
        }else {
            count;
        }
    }
    if(count != 0){
        count++;
    }else if(listProduct.charAt(1) != "") {
        count++;
    }
    return count;
}
function addToCast(id) {
    //123,445,123
    console.log("ListProduct befor in cookie " + id)
    let listProduct = getCookie("productCart");
    let nameId = '"id":"';
    let lastId = '"';
    if(listProduct.indexOf(nameId +id +  lastId) != -1) {
        let pos = listProduct.indexOf(nameId +id +  lastId);
        console.log(pos);
        let number = listProduct.substring(pos-2, pos-1);
        console.log(number);
        console.log(parseInt(number, 10));
        let newArrOne = listProduct.slice(0,pos-2);
        newArrOne+=(parseInt(number, 10)+1);
        let newArrTwo = listProduct.slice(pos-1);
        listProduct = newArrOne.concat(newArrTwo);
        console.log(listProduct);
    }else {
        if(listProduct) {
            listProduct += ",{\"number\":" + 1 + ".\"id\":\"" + id + "\"}";
        }else {
            listProduct += "{\"number\":" + 1 + ".\"id\":\"" + id + "\"}";
        }
    }
    $("#total-cast").text(getTotalCast(listProduct));
    setCookie("productCart", listProduct);
    console.log(getTotalCast(listProduct))
}