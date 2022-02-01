//This is a single line comment

/* This is a multiline comment
*/

//We can print to the console with console.log
console.log("Hello JS");

/*
Javascript Datatypes
Javascript is loosely typed so you can change the variable to anytype you want
*/
//Numbers
//Integers
var n1 = 21;
console.log(n1);

//Floating point
var n2 = 15.5;

console.log(n2);

//Exponential Notation
var n3 = 1.5e-4;
var n4 = 1.5e4;

console.log(n3, n4);

//What happens when we do this?
var n5 = -6/0;
console.log(n5);

//There is also a number called bigInt which stores numbers larger than 2^53
var bigInt = 12345678901234567890n; //the n at the end denotes this as a big int

//Variable type switching
var a = 12;

console.log(a);

a = null;

console.log(a);

a = undefined;

console.log(a);


//Strings
a = "a string";

console.log(a);

//Strings we can use single or double quotes

//Single quote example
var name = 'Rick';

//Double quote example
var last = "Sanchez";

//Single quote inside of a string
var c = "Let's go on an adventure";

//Double quotes inside of a single quote
var d = 'He said "Hello" then left';

//You are also able to escape quotes
var e = 'We\'ll never give up';

console.log(name, last, c, d, e);

//Booleans can be true or false
var t = true;
var f = false;

//Objects in JS
var obj = {
    name: 'Tiny Rick',
    age: 16
}

//Access the values inside of the object
//obj.key notation
console.log('name: ' , obj.name);
//object['key'] notation
console.log('age: ', obj['age']);

//We can also create a "blank" object with the constructor
var obj2 = new Object();

//Then we can manually assign values in 2 different ways
obj2.name = 'Morty';
obj2['age'] = 15;
console.log(obj2);

//Arrays
//You can create an array by predefining its indexes
var arr1 = ['Bob', 'Shirley', 'Tom'];
//You can also use the new keyword
var arr2 = new Array(1,2,3,4,5);
//You can also mix and match datatypes
var arr3 = ['bob', false, 23, {name:'bob'}];
console.log(arr3);

//You can find the amount of objects in an array with the length property
console.log(arr3.length);

//You can access indexes with the bracket notation
console.log(arr3[0]);

//You can add elements to the array at a given index
//We can also change the value at a given index
arr3[4] = 'new element';
arr3[1] = true;
console.log(arr3);

//You can also use the .push() method provided by the array object to add elements at the end of the array
arr3.push(53);
console.log(arr3);

//shift() method will remove the first element of the array
arr3.shift();
console.log(arr3);

var arr4 = [100, 11, 12, 10];

arr4.sort();
console.log(arr4);

//indexOf and lastIndexOf will search for an item in the array
console.log(arr4.indexOf(100));
arr4.push(12);
console.log(arr4.lastIndexOf(12));