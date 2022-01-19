package com.example.inheritance;

import java.io.Serializable;

public class Person implements Serializable {

    private int age;
    private String firstName;
    private String lastName;
    private String gender;
    protected String occupation = "Unspecified";

    public Person() {
    }

    public Person(int age, String firstName, String lastName, String gender) {
        System.out.println("In the person args constructor");
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public void speak(String message){
        System.out.println(message);
    }

    public void walk(int distance){
        System.out.println("The " + occupation + " walked " + distance + " steps");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
