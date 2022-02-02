//Lets first look at how to create a closure
const Book = function(t,a){
    let title = t;
    let author = a;

    return {
        summary: () => {
            console.log(`${title} written by ${author}`);
        }
    }
}

const book1 = new Book('HP and the Philosphers Stone', 'J.K Rowling');
book1.summary();

book1.a = 'HP and the Chamber of Secrets';
book1.summary();

//Lets look at pre js class inheritance
let animal = {
    eats: true,
    walk: () => {
        alert('Animal walking!')
    }
};

//Creat a child object
let rabbit = {
    jumps: true,
    __proto__: animal
}

console.log(rabbit.eats);
console.log(rabbit.jumps);

//Using a class to do inheritance
class Animal {

    constructor(name){
        this.name = name;
    }

    static breath(){
        console.log('Breathes');
    }

    speak(){
        console.log(`Hello my name is ${this.name}`);
    }

}

//Inherit the Animal class
class Cat extends Animal{
    constructor(name, color){
        super(name);
        this.color = color;
    }

    //We can even override methods
    speak(){
        console.log('Meow');
    }
}

let a2 = new Animal('Dog');
console.log(a2);
a2.speak();
Animal.breath();

console.log(a2 instanceof Animal);
console.log(a2 instanceof Cat);

let cat = new Cat('Mister Meow Meow', 'Gray');
console.log(cat);
cat.speak();
Cat.breath();

console.log(cat instanceof Animal);
console.log(cat instanceof Cat);