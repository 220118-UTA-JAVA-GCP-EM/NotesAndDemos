package com.example.outofpackagemodifer;

import com.example.encapmodifiers.Person;

public class EncapsulationDriverOutOfPackage extends Person{

    public static void main(String args[]){
        Person p = new Person();

        //p.age is a public variable so it can be accessed everywhere still
        System.out.println(p.age);

        //If we try to access any other variables it will be a no no
        /*
        System.out.println(p.firstName);
        System.out.println(p.lastName);
        */

        EncapsulationDriverOutOfPackage ed = new EncapsulationDriverOutOfPackage();

        //We access protected variables through the class that extends the person class
        //However, there is no way to gain access to private or default out of package
        System.out.println(ed.firstName);

    }

}
