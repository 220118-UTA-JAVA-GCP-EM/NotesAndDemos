package com.example.constructors;

public class ConstructorsAndStrings {

    String str1;
    String str2;

    //Constructors are special methods that are used to initialize objects from a class
    ConstructorsAndStrings(){
        //The first implicit line of every constructor is the super(), we can choose to include it or not
        //We can also use the this() to chain/call other constructors in this same class
        this("");

        System.out.println("We are in our no args constructor");
    }

    ConstructorsAndStrings(String arg1){
        //We can chain togeter multiple constructors, we will chain from the no arg to the one arg
        this(arg1, "");

        System.out.println("We are in the single are constructor");
    }

    ConstructorsAndStrings(String arg1, String arg2){
        //This constructor will provide a value to our variables str1 and str2
        this.str1 = arg1;
        this.str2 = arg2;

        System.out.println("We are in the two arg constructor");

    }

    public static void main(String[] args) throws Exception{
        /*
            With constructor chaining we will call the single argument constructor it will call
            the one arg, which will call the two arg
            This will set the default values of str1 and str2 to empty strings
         */

        ConstructorsAndStrings cas1 = new ConstructorsAndStrings();

        //Look at the values of str1 and str2
        System.out.println("str1: " + cas1.str1 + " str2: " + cas1.str2);
        System.out.println();

        ConstructorsAndStrings cas2 = new ConstructorsAndStrings("Hello");

        System.out.println("str1: " + cas2.str1 + " str2: " + cas2.str2);
        System.out.println();

        ConstructorsAndStrings cas3 = new ConstructorsAndStrings("Hello", "World");

        System.out.println("str1: " + cas3.str1 + " str2: " + cas3.str2);
        System.out.println();

        //More String fun

        //We are declaring a string literal, so it will be stored in the string pool
        String s1 = "hi";

        //This will reference the string literal that is already stored in the string pool
        String s2 = "hi";

        //For some reason if we absolutely want a new string object we can use the new keyword
        String s3 = new String("hi");

        String s4 = "hi";

        //When we use == with Strings it is going to check if the objects are the exact same, or aka they are referencing the same object
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);

        System.out.println("s2 changed to be hello");
        s2 = "hello";

        System.out.println(s1 == s2);
        System.out.println(s1 == s4);

        System.out.println("Lets make s4 point at s3");
        s4 = s3;

        System.out.println(s4 == s3);

        //To check if the value held inside of the char sequence is the same instead of the reference objects are the same
        //We can use the .equals()
        System.out.println(s1.equals(s3));

        //Concatenation
        String s5 = "Hello";
        s5 = s5.concat(", whats up?");
        System.out.println(s5);

        String s6 = "Hey";
        s6 = s6 + ", whats up? Hello!";

        System.out.println(s6);
    }

}
