"use strict";
//We create classes using the class keyword and an instance of a class is created with the new keyword
//TS suports getters and setters to access and set class members, getters and setters
//Are created by using the get and set keywords
class Animal {
    //Constructor
    constructor(name, species) {
        this.name = name;
        this.species = species;
    }
    //Getters and setters
    get getSpecies() {
        return this.species;
    }
    set setSpecies(sp) {
        this.species = sp;
    }
    //Create methods
    move(feet) {
        console.log(`The animal ${this.name} moved a total of ${feet} feet`);
    }
}
let an = new Animal('Peri', 'Cat');
an.move(5);
//Instead of using mutators as methods, we set them like properties
//In java it would look like this an.setSpecies('dog')
an.setSpecies = 'Dog';
console.log(an.getSpecies);
//Inheritance, implemented through the extends keyword
class Dog extends Animal {
    bark() {
        console.log('Arf arf');
    }
}
let d = new Dog('Leia', 'Shihpoo');
d.bark();
d.move(50);
//name is readonly, we cannot change it once it is set in the constructor
//d.name = 'Doug';
//We can also create abstract classes
class Car {
    alarm() {
        console.log('BEEEEEEEEEEEEEPPPPPPPPPPPPPPPPPPPPP');
    }
}
class SportsCar extends Car {
    drive() {
        console.log('Drive fast');
    }
}

let sc = new SportsCar();
sc.drive();
sc.alarm();
let user1;
user1 = {
    username: 'Leroy',
    password: 'Jenkins',
    login: () => { return true; }
};
let user2;
user2 = {
    username: 'Steve',
    password: 'I mine blocks',
    phone: 1112223333,
    login: () => { return true; }
};
