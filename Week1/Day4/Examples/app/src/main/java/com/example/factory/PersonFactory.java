package com.example.factory;

public class PersonFactory {

    public static Person getPerson(String type){
        switch(type){
            case "student":
                return new Student();
            case "teacher":
                return new Teacher();
            case "vp":
                return new VicePrinciple();
            case "principle":
                return new Principle();
            default:
                return new Parent();
        }
    }


}
