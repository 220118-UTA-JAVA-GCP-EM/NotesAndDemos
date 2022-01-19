package com.example.encapmodifiers;

//With encapsulation we want to hide states and behaviors of classes, to do so we use access modifers
//We also have no-access modifiers
//An encapsulated class will have all states private, and only the needed behaviors accessible
public class Person {

    //public means that we can access this property from anywhere
    //This variable is instance scoped
    public int age = 24;

    //protected means that we are capable of accessing this property withing the package
    //and subclasses
    //This variable is in instance scope
    protected String firstName = "Ethan";

    //default (no keyword) means that we can access this property within the same package only
    //This variable is instance scope
    String lastName = "McGill";

    //private means we can only access this variable from inside of this class
    //This variable is instance scope
    private String email = "ethan.mcgill@revature.com";

    //This variable is in static/class scope
    //It will be shared with every instance of this class
    private static String company = "Revature";

    //The final keyword makes it so we cannot reassign the value of the property
    //once it is set
    private final int id = 1;

    //Method scope applies to variable that are inside of method blocks
    //You cannot use these variables outside of the method
    protected void printName(){
        //This variable is in method scope
        String fullName = firstName + " " + lastName;

        if(company.equals("revature")){
            //Any variable declared inside of a block of code such as an if statement,
            //is considered block scope and cannot be used outside of its scope
            String title = "Trainer";
            System.out.println(fullName + " is a " + title + " at " + company);
        }

        //System.out.println(title);

    }

    //private String full = fullName;

    public int getAge(){
        return age;
    }

    public void setAge(int age){
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getCompany() {
        return company;
    }

    public static void setCompany(String company) {
        Person.company = company;
    }

    public int getId() {
        return id;
    }
}
