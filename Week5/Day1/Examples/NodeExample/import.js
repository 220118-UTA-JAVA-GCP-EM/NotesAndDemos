let greeting = require('./helloNode.js');
//There are also prebuilt in packages that we can use with node, such as the os package
let oss = require('os');

console.log(greeting('Bob'));
console.log(oss.totalmem());

//npm init creates the package.json
//npm install: will install any packages listed in the package.json
//npm install packagename: install a specified package
//npm install -g packagename: install a package globally
//npm install -D package: install a package as a dev dependency

//We can also use things like setTimeout and setInterval in node with the global
global.setTimeout(()=> {
    console.log('Hello after 3 seconds')
}, 3000);

//We can also gain access to our environment variables through node
console.log(process.env.DB_URL);