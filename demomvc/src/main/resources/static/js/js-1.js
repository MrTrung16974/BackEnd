//Comment tren 1 dong cua JS
/*Comment tren nhieu dong cua JS */

//Hien thi ra cac chuoi ra trinh duyet
document.write("<h2>Hello World</h2>")

/* bat ra hoi thoai thong bao
alert("Hello World")
*/

//Hien thi thong bao cho phep nguoi dung nhap du lieu
// var name = prompt('Vui long nhap ho ten');
// Hien thi thong tin o debug tool cua trinh duyet(Luu y tab console)
// console.log(name);

//*************** Kieu du lieu co ban trong JS*********************//
//1-Number
var number = 10;
console.log(typeof(number));

var number2 = 1232.2133;
console.log(typeof(number2));

// 2-String
var string = 'Hello';
console.log(typeof string);
var number3 ='20'; //Number string
console.log(typeof(number3));
var sum = number+number3; //Uu tien la phep toan noi chuoi(+)
console.log(sum);

// 3 - boolean
var check = false;
console.log(typeof(check));
// false ==''== 0 ve mat gia tri
// true == 1 ve mat gia tri
if (check == '') {
	console.log('A');
}
else {
	console.log('B')
}

var test;
console.log(typeof(test));

var demo=null;
console.log(typeof(demo));
/*********************** Khai bao bien trong JS ***********************/
var myName = 'Kien';
// Bien trong JS khong bat dau bang so va khong duoc phep trung voi cac tu khoa trong lap trinh
//var 1name ='asass'; //sai
// var _1name='assas'; //dung
 var myClass = 'java'; //JS khuyen dung
 // var MyClass = 'Java'; //Khong khuyen dung
 // var my_class = 'Java';
 var myClass = '.Net';//Gia tri hien tai la .Net
 myClass='.Net';

 let monney = 100;
 monney=300;
 console.log(monney);

 var x = 10;
 if (true) {
 	var x= 20;
 	console.log(x);
 }
 console.log(x);

 let y = 10;
 if (true) {
 	let y= 20;
 	if (true) {
 		let y=30;
 		console.log(y);
 	}
 	console.log(y);
 }
 console.log(y);

 function checkMyNumber()
 {
 	let t=10;
 	if (true) {
 		let t=20;
 		console.log(t);
 	}
 	console.log(t);
 }
 // console.log(t);
 checkMyNumber();

 // Tu khoa const
 const PI = 3.14;
 const MY_NAME = 'Kien';
 // PI= 5.13;
 console.log(PI);

 /////////////////////////////////////////
 let u = 10;
 if (u==10) {
 	console.log('OK')
 }
 else{
 	console.log('ERR')
 }

 if (u > 100) {
 	//do something
 } else if (u>120) {
 	//dosomething
 } else if (u>8) {
 	//dosomething
 } else if (u>50) {
 	//dosomething
 } else{
 	//dosomething
 }

switch (u) {
	case 100:
		// statements_1
		break;
	default:
		// statements_def
		break;
}

for(let i =1; i<=50; i++){
	console.log(i);
}

let k =10;
while (k<100) {
	// statement
	console.log(k);
	k++;
}

let v=10;
let z=9;
let s=(v++) - (++z) + (--v) - (z--) + (++v) - (z++);
console.log(s);