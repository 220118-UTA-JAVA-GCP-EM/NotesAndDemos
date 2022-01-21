package com.example.garbage;

public class Garbage {

    //Finalize is a method we can call right before we destroy and object in java
    @Override
    protected void finalize(){
        System.out.println("Garbage finalize method called");
        System.out.println("Goodbye cruel world");
        System.exit(0);
    }

}
