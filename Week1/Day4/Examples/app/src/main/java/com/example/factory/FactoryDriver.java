package com.example.factory;

import java.util.ArrayList;

public class FactoryDriver {

    public static void main(String args[]){

        //Our school needs a Principle
        Person principle = PersonFactory.getPerson("principle");
        System.out.println(principle.getInfo());

        //Our school probably needs a couple vp's
        ArrayList<Person> vps = new ArrayList<>();
        vps.add(PersonFactory.getPerson("vp"));
        vps.add(PersonFactory.getPerson("vp"));
        for(Person p: vps){
            System.out.println(p.getInfo());
        }

        //Our school will need some teachers
        ArrayList<Person> teachers = new ArrayList<>();
        for(int i=0; i<10; i++){
            teachers.add(PersonFactory.getPerson("teacher"));
        }
        System.out.println(teachers);

        //Schools typically have a few kids
        ArrayList<Person> students = new ArrayList<>();
        for(int i=0; i<100; i++){
            students.add(PersonFactory.getPerson("student"));
        }

        System.out.println(students);

        //Default case
        Person parent = PersonFactory.getPerson("Not a student");
        System.out.println(parent.getInfo());

    }

}
