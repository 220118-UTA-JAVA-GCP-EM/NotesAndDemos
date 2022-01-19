package com.example.inheritance;

//Our teacher class is going to inherit, or gain access to all the properties and methods from the person that are not private

public class Teacher extends Person{

    //We will shadow the occupcation variable from the Person class
    //Since Teacher is a subtype of Person, the occuptation field of both classes are in the same scope
    //Anytime we create a Teacher if will shadow the occupation field
    private String occupation = "Teacher";

    //Teahcers may also have some specialized fields
    private int teacherId;
    private String[] subjects;

    public Teacher(){

    }

    //In our argument constructor we are going to include
    public Teacher(int age, String firstName, String lastName, String gender, int id, String... subjects){
        //We will use the super() keyword to call the argument constructor of the Person class
        super(age, firstName, lastName, gender);
        System.out.println("In the teacher args constructor");
        this.teacherId = id;
        this.subjects = subjects;
    }

    //Teachers will have some special behaviors not available to the Person class
    public void teach(String[] subjects){
        for(String sub: subjects){
            System.out.println("Teacher teaches: " + sub);
        }
    }

    public double giveGrade(){
        return Math.random() * 100;
    }

    @Override
    public String getOccupation() {
        return occupation;
    }

    @Override
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}
