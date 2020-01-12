//1 - DOM element
//Tim phan tu html thong qua id cua no
let title = document.getElementById('title');
console.log(title);

let title2 = document.getElementsByClassName('title');
console.log(title2[1]);

let title3 = document.getElementsByTagName('h1');
console.log(title3[0]);

let title4 = document.querySelectorAll('.title');
console.log(title4[1]);

//2 - DOM Event

//Truy cap vao the button
 // let myBtn = document.getElementById('clickMe');
 // let myBtn = document.getElementsByClassName('btn');
 let myBtn = document.getElementsByTagName('button');
 // Bat su kien
 // myBtn.onclick = function() {
 // 	alert('Kiên Đẹp Trai');
 // }
 

 // Gan cho no 1 su kien
 myBtn[0].addEventListener('click', function(){
 	// alert('Hello, Its me');
 	let text = document.getElementById('title').innerHTML = 'Learning Java';
 	// alert(text);
 	let input = document.getElementsByTagName('input');
 	// input[0].type = 'button';
 	input[0].setAttribute('type','button');
    
    let box = document.getElementsByClassName('box');
    box[0].style.width = '100px';
    box[0].style.height = '100px';
    box[0].style.border = ' 3px solid yellow';
    box[0].style.backgroundColor = 'pink';
 })

 let myImages = document.getElementsByTagName('img');
 // myImages[0].src='Images/Kien.png';

 myImages[0].addEventListener('mouseover', function(){
 	this.width = 200;
 	this.height = 200;
 })
myImages[0].addEventListener('mouseout', function(){
 	this.width = 50;
 	this.height = 50;
 })

