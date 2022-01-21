package com.example.garbage;

public class GarbageDriver {

    public static void main(String[] args){
        System.out.println("Instantiate a new Garbage Object");
        Garbage a = new Garbage();

        System.out.println("Garbage object created");

        System.out.println("Assign a the variable to a different object");
        a = new Garbage();

        //We can suggest that the system do garbage, but that does not mean it will immediately
        System.gc();

        for(;;){
            System.out.println("Waiting for garbage collection");
        }

    }

}
