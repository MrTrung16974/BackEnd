// Định nghĩa hàm trong JS
// Cú pháp: function + nameFunction(param...)
function sumNumber(a, b = 5){
    // Tham số truyền vào hàm ko cần từ khóa khai báo biến dùng đằng trước
    return a+b;
    // Từ khóa return trả về kết quả về cho hàm và sẽ thoát khỏi hàm - các câu lệnh bên dưới sẽ không được thực thi
}
//Gọi hàm ra sử dụng
let total = sumNumber(4, 8);
console.log(total);

// Viet ham cho biet từ 1 - 100 có bao nhiêu số nguyên tố
function checkPrime(a){
	if(a<=1){
		return false;
	}
	if(a==2){
		return true;
	}
	let flagCheck = true;
	for(let i=2; i<= Math.sqrt(a);i++){
		if (a % i == 0) {
			flagCheck = false;
			break;
		}
	}
	return flagCheck;
}

function countPrime(i, j){
 let count = 0;
 let number = '';
 for(let k=i; k <= j; k++){
 	if(checkPrime(k)){
 		count++;
 		number += (number == '') ? k : ',' + k;
 	}
 }
 return number;
}

let snt = countPrime(1,100);
console.log(snt);

///////////////////////////////////////////////////////////////////////
let kiemTraChanLe = function(number){
	if(number % 2 ==0){
		return true;
	}
	return false;
}
// Tên biến chính là tên hàm
let chk = kiemTraChanLe(25);
if (chk) {
	console.log('số chẵn')
}
else {
	console.log('số lẻ')
}

console.log(typeof(kiemTraChanLe))

// Định nghĩa theo hàm vô danh - giai phương trình bậc 2
let phuongTrinhB2 = function(a,b,c){
	let d = b*b - 4*a*c;
	let x = 0;
	let y = 0;
	if(d<0){
		console.log('Phương trình vô nghiệm');
	}
	else if(d=0){
        x = (-b/(2*a));
		console.log('Phương trình có nghiệm kép là x1 = x2 ='+x);
	}
	else if(d>0){
		x = ((-b + Math.sqrt(d))/(2*a));
			console.log('x1='+x);
		y = ((-b - Math.sqrt(d))/(2*a));
			console.log('x2='+y);
	}
}
phuongTrinhB2(1,5,-3);
/////////////////////////////////////////////////////
function sHinhThang(a,b,h){
	// Viet ham tinh tong 2 day
	function sum(){
		return a+b;
	}

	function phepNhan(){
		return sum()*h;
	}
	function phepChia(){
		return phepNhan()/2;
	}

	return phepChia();
}

let kq = sHinhThang(4,5,6);
console.log(kq);
/////////////// Arrow function  ////////////////////////////////////////////////////////
let sHinhVuong = (a) =>{
     return a*a;
}
let result = sHinhVuong(10);
console.log(result);

// Viet ham arrow function tìm BSCLN cửa 2,3 từ 1-->200
timBSCLN = (a,b,i,j) =>{
	let max = 0;
	for(let k = i;k <= j;k++){
		if(k % a == 0 && k%b==0){
			max=k;
		}
	}
	return max;
}
let ketqua = timBSCLN(2,3,1,200);
console.log(ketqua);
////////////////////// Đối tượng Number////////////////////////////
let myNumber = '100';
let n = Number.parseInt(myNumber);
console.log(n, typeof(n));

let n1 = prompt('moi nhap so a');
let n2 = prompt('Moi nhap so b');
n1 = Number.parseInt(n1);
n2 = Number.parseInt(n2);
let n3 = n1 + n2;
// alert(n3);
if(Number.isInteger(n3)){
	console.log('Y');
} else{
	console.log('N');
}

let  test = 3/0;
console.log(typeof test);