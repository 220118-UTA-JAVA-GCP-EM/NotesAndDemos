package com.example.encapmodifiers;

public class SamePackageModiferTest {

    //Lets first take a look at what happens when trying to access variables from within the same package
    //public, protected, and default can all be accessed from within the same package

    Person p = new Person();

    //age is a public variable, so it is available everywhere
    int age = p.age;

    //firstName is a protected variable, so it can be accessed from sub classes and inside the package
    String first = p.firstName;

    //lastName is default so it can be accessed in class and package only
    String last = p.lastName;

    //private is only in the class
    //If we want access to the email, we must use the getter
    //String email = p.email;

}
