function helloWord(name){
	alert('Hello ' + name);
}

function demo(){
	alert('Kien dep trai');
}

function myFocus(){
	console.log('Su kien focus vua xay ra');
}

function myBlur(){
	console.log('Su kien blur vua xay ra');
}
function selectGender(obj){
	// console.log(obj);
	let gender = obj.value;
	console.log(typeof(gender));
	gender = Number.parseInt(gender);

	if (gender===1) {
		console.log('Ban vua chon gioi tinh nam');
	}else if (gender===2) {
		console.log('Ban vua chon gioi tinh nu');
	} else {
		console.log('Ban chua chon gioi tinh');
	}
}

function getDataText(obj){
	let data = obj.value;
	console.log(data);
}

function myDBClick(){
	console.log('Ban vua click 2 lan lien tiep vao con chuot');
}

function errorPage(){
	console.log('Khong tai duoc trang web');
}

function loadPage(){
	console.log('Trang web duoc tai thanh cong');
}

function myKeyDown(){
    console.log('Tay vua cao phim');
}

function myKeyPress(){
	console.log('Giu phim lam chi?');
}
function myKeyUp(){
	console.log('Buong doi tay nhau ra');
}
function myMouseDown(){
	console.log('Ban vua nhap');
}
function myMouseUp(){
	console.log('Ban vua nha');
}
function myMouseMove(){
	console.log('Ban vua di chuyen');
}
function myMouseOver(obj){
    obj.width = 500;
    obj.height = 500;
}
function myMouseOut(obj){
	obj.width = 50;
	obj.height = 50;
}
function myResetForm(){
	resetForm();
	
}

function resetForm(){
console.log('form reset');
}

function myResize(){
	console.log('Ban vua thay doi kich thuoc khung trinh duyet');
}
function mySelect(){
	console.log('KDZ');
}

window.onbeforeunload = function(){
	return 'xxx';
}