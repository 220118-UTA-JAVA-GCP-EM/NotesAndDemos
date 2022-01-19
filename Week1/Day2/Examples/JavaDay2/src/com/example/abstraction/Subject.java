package com.example.abstraction;

public interface Subject {

    boolean isActive = true;

    //This is also a abstract method
    String[] getTopics();

    default void printCourseIsActive(){
        System.out.println("This course is currently being taught t/f: " + isActive);
    }

}
