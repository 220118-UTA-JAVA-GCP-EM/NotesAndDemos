package com.example.abstraction;

import sun.text.bidi.BidiLine;

public abstract class Course {

    public int id;
    public int room;
    public String name;

    //You can use constructors of the abstract class to enforce class constraints
    public Course(String name, int id, int roomNum){
        this.id = id;
        this.room = roomNum;
        this.name = name;
    }

    //Concrete method
    public void startCourse(){
        System.out.println("The teacher started teaching");
    }

    abstract void endCourse();

}
