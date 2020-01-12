$(document).ready(function() {
	// Cho doi cac ma HTML CSS duoc load xong day du
	// roi moi thuc thi cac ma lenh jQuery
	// vi can phai co DOM Html that de thao tac
	// nen can cho doi HTML va CSS thuc thi xong truoc
	// Cac ma code viet theo Jquery thi nen viet
	// o trong ham nay
	// Ham khoi tao cua Jquery
	

	// $  keyword của Jquery
	let btn = $('#btn');
	// console.log(btn);
	btn.click(function(){
		let id = $('h1').attr('id');
		let id2 = $('h1').prop('id');
	    console.log(id, id2);

	    $('button[name="btn-primary"]').prop('disabled',true);

	    //Xoa width va height cua image
	    $('img').removeAttr('width');
	    $('img').removeAttr('height');

	    // if($('#box').hasClass('box')){
	    // 	$('#box').removeClass('box');
	    // } else {
	    // 	$('#box').addClass('box');
	    // }
	    
	    $('#box').toggleClass('box');
	    let wContent = $('div.content').width();
	    let hContent = $('div.content').height();
	    console.log(wContent, hContent);
	    $('img').width(600);
	    $('img').height(600);

	    let wInC = $('div.content').innerWidth();
	    let hInC = $('div.content').innerHeight();
	    console.log(wInC, hInC);
	});

	// let myBtn = document.getElementsByTagName('button');
	// myBtn[1].addEventListener('click', function(){
	// 	alert("Kien");
	// })

	$('button[name="btn-primary"]').click(function(){
		alert("Kien Dep Trai");
	});

	$('input[name="user"]').keyup(function(){
		let data = $(this).val().trim();
		// $(this) : chinh la the input dang thao tac
		// .val() : Lay ra du lieu trong o text
		// .trim(): Xoa khoang trang 2 dau
		$('p.info').text(data);
		// Gan du lieu vao the p
		// 
		// To mau cho the div.content
		// 
		// css don - single css
		// $('div.content').css('background-color','red');
		// 
		// multi css
	    $('div.content').css({
	    	backgroundColor: 'yellow',
	    	borderRadius: '28px'
	    });
	});

	// Su kien click btn3
	$('#btn-3').click(function(){
		$('ul li').eq(1).css('color', 'blue');

		if ($('input[name="agree"]').is(':checked')) {
			console.log('Ban da tich chon');
		} else{
			console.log('Ban chua tich chon');
		}

		$('div.container').find('h2.title').css('color','red');

		$('div.container').next().css({
			width: '200px',
			height: '200px',
			backgroundColor: 'blue'
		});
		$('div.container').prev().css({
			width: '200px',
			height: '200px',
			backgroundColor: 'red'
		});

		let dt = $('h3').text();
		let dt2 = $('h3').html();
		console.log(dt, dt2);
		$('h3').html('Sap ket thuc roi');
		$('h3').empty();
		$('h3').remove();
		// Empty: Xoa noi dung trong the
		// Remove : Xoa ca cai the do
		
		// $('#my-box').fadeOut(5000);
		// $('#my-box').hide(5000);
		$('#my-box').fadeToggle(5000);
	});

	$('#btn-4').click(function(){
		// $('#my-box').fadeIn(5000);
		// $('#my-box').show(5000);
		// $('#my-box').slideDown(5000);
	});

	$('#keybroad').keyup(function(event) {
		let key = event.which;
		// console.log(key);
		
		let sefl = $(this);
		let input = $(this).val().trim();
		if (!$.isNumeric(input)) {
			alert('Vui long nhap so');
			sefl.val('');
		}
	});
});
	
