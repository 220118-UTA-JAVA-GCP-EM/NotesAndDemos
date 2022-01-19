package com.example.inheritance;

public class PersonDriver {

    public static void main(String args[]) throws Exception{
        System.out.println("Creating a regular person object");
        Person p = new Person(24, "Ethan", "McGill", "Male");

        System.out.println("Creating a teacher");
        Teacher t = new Teacher(69, "Rick", "Sanchez", "Male", 1, "Math", "Science");

        System.out.println("Creating a student");
        Student s = new Student(13, "Morty", "Smith", "Male", 1, 2.14);

        //Every single class that is an instance/subclass of person has access to the person methods
        p.speak("Hello from person");
        t.speak("Hello from teacher");
        s.speak("Hello from student");

        //The occupation variable should be shadowed
        System.out.println(p.getOccupation());
        System.out.println(t.getOccupation());
        System.out.println(s.getOccupation());

        //Teacher class only has access to Person and Teacher methods, not methods from the student
        System.out.println("Student " + s.getFirstName() + " gets the grade " + t.giveGrade());
        //If we try to access a student method thats a no no
        //t.askQuestion();

        //The same goes for students, we cannot access the teachers methods
        s.askQuestion("Mr. Sanchez I have a question");
        //s.giveGrade();
    }

}
