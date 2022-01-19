package com.example.polymorphism;

public class PolyDriver {

    public static void main(String[] args){

        Parent.overloadMe();
        Parent.overloadMe("Hello");
        Parent.overloadMe("Hello", 1);
        Parent.overloadMe(2, "Hello");

        Child c = new Child();
        Parent p1 = new Child();
        Parent p2 = new Parent();

        //Doesnt work
        //Child c2 = new Parent();
        //You can try to force but you will have a bad time
        //Child c2 = (Child) new Parent();

        //We can cast object to get their parent variables
        System.out.println("Child x variable: " + c.x);
        //This is the parents variable due to casting
        System.out.println("Parent x variable: " + p1.x);
        System.out.println("Parent x variable: " + p2.x);

        // Explicit Downcasting will give us the childs field value
        System.out.println("Child x variable: " + ((Child)p1).x);

        // We can't use casting to get parents method when the actual object is a child
        System.out.println("Child getObj() method: " + c.getObj());
        System.out.println("Child getObj() method: " + p1.getObj());
        System.out.println("Parent getObj() method: " + p2.getObj());

        //Since we don't inherit static methods, we can only hide them not overide
        //because they belong to the class, we can techincally cast to get them, but it isn't
        //neccesarily the same traditional casting
        System.out.println("Child static method: " + c.hiding());
        System.out.println("Parent static method: " + p1.hiding());
        System.out.println("Parent static method: " + p2.hiding());
        System.out.println("Child static method: " + ((Child)p1).hiding());

        // The variable will be the same through our due to inheritance
        final String i = "inherited boolena: ";
        System.out.println(i + c.inherited);
        System.out.println(i + p1.inherited);
        System.out.println(i + p2.inherited);

    }

}
