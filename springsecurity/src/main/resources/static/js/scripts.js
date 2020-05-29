$( document ).ready(function () {
    var pathname = window.location.pathname; // Returns path only (/path/example.html)
    console.log($($(".main-content-wrapper .header-area .amado-nav>li")));
    $(".main-content-wrapper .header-area .amado-nav>li").click(function () {
        console.log("Ok");
    });
});