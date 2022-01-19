package com.example.polymorphism;

import java.io.IOException;

public class Child extends Parent{

    //we will shadow the parent variables
    public int x;
    public String name;

    public Child(){
        name="child";
    }

    //We will override and take advatnage of covariant return with the child class
    //Lets override the getObj method and make it return a string, which is a child of the object class
    //When overriding we use the same name and same signature of the method from the parent class
    //but we give it different functionality
    @Override
    public String getObj(){
        return "A string is a child of the object class, so this is perfectly legal covariant return";
    }

    //Lets override the changeAccess Method and prove we can change the access level
    @Override
    public void changeAccess(){
        System.out.println("This method is now public");
    }

    //We can change the type of exception thrown by an overriden class
    @Override
    public void changeThrows() throws IOException {
        System.out.println("IOException is a child of the exception class");
    }

    //We cannot override static or private methods, but we can hide them
    //similar to shadowing
    public static String hiding(){
        return "The original is hidden";
    }

}
