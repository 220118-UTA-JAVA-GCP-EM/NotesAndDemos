package com.example.polymorphism;

public class Parent {

    public int x;
    public String name;
    public boolean inherited = true;

    public Parent(){
        x = 5;
        name =  "parent";
    }

    //Method overloading, we can have multiple methods inside of a single class that share
    //the same name, as long as we change the method signatures
    public static void overloadMe(){
        System.out.println("No args method");
    }

    public static void overloadMe(String s){
        System.out.println("method with one string arg: " + s);
    }

    public static void overloadMe(String s, int i){
        System.out.println("method with two args: " + s + " " + i);
    }

    public static void overloadMe(int i, String s){
        System.out.println("method with two args: " + i + " " + s);
    }

    //Covariant return, we can change the return types, and exception thrown if
    //they are children of the orginal throw or return
    //Changing the return type
    public Object getObj(){
        System.out.println("Can we change the return type from Object to something else?");
        return new Object();
    }

    protected void changeThrows() throws Exception {
        System.out.println("Lets try to change the throws");
    }

    //We can even change the access level
    protected void changeAccess(){
        System.out.println("Lets try to change the access level");
    }

    //There is a functionality similar to shadowing but methods called hiding
    //but it is not recommended that you do this
    public static String hiding(){
        return "hide me";
    }

}
