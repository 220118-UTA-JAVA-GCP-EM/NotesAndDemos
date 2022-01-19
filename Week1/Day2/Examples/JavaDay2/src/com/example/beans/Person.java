package com.example.beans;

import java.io.Serializable;

public class Person implements Serializable {

    //Order of initialization in Java
    //1. Static fields and variables
    private static String identifaction = "Person";

    //2. Static initializers
    static {
        System.out.println("We could initialize something here if we needed to before the constructor");
        System.out.println("This being indetifies as a " + identifaction);


        //If we tried to access some instance variables they would not be instantiated yet
        //age = 0;
    }

    //3. Instance fields/variables
    private int age;
    private String firstName;
    private String lastName;
    private String gender;
    private String occupation;

    //4. Instance initializers
    {
        System.out.println("Here we can initialize instance values before the constructor");
        age = 0;
        firstName = "first";
        lastName = "last";
        gender = "unspecified";
        occupation= "N/A";
    }

    //5. Constructor
    //Remember to be a bean, we need at least a no args constructor
    public Person(){

    }

    public Person(int age, String firstName, String lastName, String gender, String occupation) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.occupation = occupation;
    }

    public static String getIdentifaction() {
        return identifaction;
    }

    public static void setIdentifaction(String identifaction) {
        Person.identifaction = identifaction;
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

    public static void main(String args[]) throws Exception{

        Person ethan = new Person();
        Person niko = new Person();

        ethan.setIdentifaction("Attack Helicopter");

        System.out.println(ethan.getIdentifaction());
        System.out.println(niko.getIdentifaction());

        Person.setIdentifaction("Person");

        System.out.println(Person.getIdentifaction());

    }

}
