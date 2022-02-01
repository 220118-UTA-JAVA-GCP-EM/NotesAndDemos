console.log("Hello functions");

//Lets take a look first at truthy vs falsey
if('0'){
    console.log('truthy');
} else {
    console.log('Ethan retires');
}

//A function that utilizes a simple if statement
function simpleIf(){
    if(5>6){
        console.log('yay');
    } else {
        console.log('boo');
    }
}

simpleIf();

//A function that utilizes a simple if/else statement
function simpleElseIf(num){
    if(num<0){
        console.log('Num is negative');
    } else if(num>0){
        console.log('Num is not negative');
    } else {
        console.log('Num is zero');
    }
}

simpleElseIf(0);

var arr = [1,2,3,4,5,6,7];

//A simple loop
function sumOfArray(){
    var sum=0;
    for(i=0; i<arr.length; i++){
        sum+=arr[i];
    }

    return sum;
}

console.log('The sum of the array is: ', sumOfArray());

//A simple while loop
var num=0;
while(num<10){
    console.log(num);
    num++;
}

//A simple do while loop
do {
    console.log(num);
    num++;
} while(num<=9);

//These are the new loops that you have not seen yet
//For of loops are used for arrays and array like objects
for(num of arr){
    console.log(num);
}

//For in loops are used to access the keys of an object
var obj = {name:'bob', age:23};

for(property in obj){
    console.log(property + ' : ' + obj[property]);
}

//We can assign the return values of a function to a variable
function add(num1, num2){
    return num1 + num2;
}

var answer = add(10, 34);
console.log(answer);

//Functions can be assigned directly to variables, anon functions
var coolFunction = function(){
    console.log("I am anonymous");
}

coolFunction();

//Callback functions are used everywhere, Array methods find(), map(), filter(), and reduce()
//use callback functions to operate on data

//Array find returns the first element that satisfies the callback function
//Returns the first number that it finds greater than 2
var greaterThan = arr.find(function(n){
    return n > 2;
});

console.log(greaterThan);

//Array.filter() works very similarly to find()
//This one will return an array, with all the number that are greater than 3
var greaterThanFilter = arr.filter(function(n){
    return n > 3;
});

console.log(greaterThanFilter);

//Array.map() takes a callback and returns a new array that is the result of calling
// the callback function on the current element of the array
var squares = arr.map(function(n){
    return n*n;
});

console.log(squares);

//Default Parameters
function defaultParams(a, b=1){
    return a*b;
}

console.log('Making use of the default parameter', defaultParams(2));

console.log('Inputting two paremeters', defaultParams(2,3));