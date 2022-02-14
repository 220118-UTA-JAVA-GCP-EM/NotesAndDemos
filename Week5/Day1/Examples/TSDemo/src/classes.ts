//We create classes using the class keyword and an instance of a class is created with the new keyword
//TS suports getters and setters to access and set class members, getters and setters
//Are created by using the get and set keywords
class Animal{
    //fields
    readonly name: string;
    private species: string;

    //Constructor
    constructor(name: string, species: string){
        this.name = name;
        this.species = species;
    }

    //Getters and setters
    get getSpecies(): string {
        return this.species;
    }

    set setSpecies(sp: string){
        this.species = sp;
    }

    //Create methods
    move(feet: number): void{
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
    bark():void {
        console.log('Arf arf');
    }
}

let d = new Dog('Leia', 'Shihpoo');

d.bark();
d.move(50);
//name is readonly, we cannot change it once it is set in the constructor
//d.name = 'Doug';

//We can also create abstract classes
abstract class Car{
    abstract drive(): void;

    alarm(): void {
        console.log('BEEEEEEEEEEEEEPPPPPPPPPPPPPPPPPPPPP');
    }
}

class SportsCar extends Car{
    drive(): void {
        console.log('Drive fast');
    }
}

let sc = new SportsCar();

sc.drive();
sc.alarm();

//Interfaces allow us to create contracts that other classes or objects must implement

interface User{
    username: string;
    password: string;
    phone?:number;
    login():boolean;
}

let user1: User;

user1 = {
    username: 'Leroy',
    password: 'Jenkins',
    login: () => {return true}
}

let user2: User;

user2 = {
    username: 'Steve',
    password: 'I mine blocks',
    phone: 1112223333,
    login: () => {return true}
}