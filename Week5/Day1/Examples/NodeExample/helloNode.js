console.log('Hello node');

//ES6 gave us modules
//Actually being able to use modules are a great feature of node
//Modules are essentially a unit of js code that is meant to reused by exporting and then importing
function greeting(name){
    return `Hello my name is ${name}`;
}

module.exports = greeting;