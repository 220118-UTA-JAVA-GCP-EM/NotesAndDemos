//Scopes
//Anything out here is global
var sc1 = 'I am global scope';

//Anything inside of a block of code is local scope
function scopes(){
    var sc2 = 'I am functional scope';
    if(sc2){
        let sc3 = 'I am block scope';
    }

    //console.log(sc3);
}

scopes();

hoistEx();

//Hoisting Example
function hoistEx(){
    console.log('I hoisted myself');
}

//Any variable without let or const will be hoisted out of block scope
function varHoist(){
    if(1>0){
        var hoistMe = 'I got hoisted outside of the if block';
    }

    console.log(hoistMe);
}

varHoist();

//We can create disembodied functions with arrow notation since es6
//A simple arrow function
var simpleArrow = () => console.log('Hello I am an arrow function');

simpleArrow();

var paramArrow = (num) => {
    console.log('We were given the number: ', num);
    console.log('The square of ', num, 'is', num*num);
    return num * num;
}

paramArrow(3);

//Lets refactor with our template literals
var template = (num) => {
    console.log(`We were given the number ${num}`);
    console.log(`The square of ${num} is ${num * num}`);
}

template(3);

//Another great thing with arrow functions is that they make great callbacks
/*let squares = arr.map(function(n){
    return n*n;
});
*/

let arr = [1,2,3,4,5,6,7];

let squares = arr.map((n) => n*n);
console.log(squares);