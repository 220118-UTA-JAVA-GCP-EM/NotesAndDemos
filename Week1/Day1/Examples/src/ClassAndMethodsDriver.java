//ignore the public keyword for now
//The class keyword denotes that this code block is a java class
//Naming convention for classes is TitleCase
public class ClassAndMethodsDriver {

    //Classes define states and behaviors of an object
    //The states are our "local" variable for example we  can make this class have a couple of states
    int myInt = 24;
    double pi = 3.14;
    boolean isMonday = false;

    //Our behaviors are our methods inside of the class

    //Methods can take in 0 to as many parameter as you want, the parameters can be of any type
    //The void keyword denotes that the method will return nothing
    void printHello(){
        System.out.println("Hello");
    }

    int returnMyInt(){
        //The return keyword tells the method to exit and return the data/object
        return myInt;
    }

    void changeIsMonday(boolean monday){
        isMonday = monday;
    }

    int passByValueTest(int value){
        value = value + 1;
        return value;
    }

    public static void main(String args[]) throws Exception{
        //To create a new object from a class you use the new keyword
        ClassAndMethodsDriver camd = new ClassAndMethodsDriver();

        //After creating a new instance of our ClassAndMethodDriver we can now access
        //The variables and methods of the class through the object
        camd.printHello();

        System.out.println(camd.returnMyInt());

        System.out.println(camd.isMonday);

        camd.changeIsMonday(true);

        System.out.println(camd.isMonday);

        camd.passByValueTest(camd.myInt);

        camd.myInt = camd.passByValueTest(camd.myInt);

        System.out.println(camd.myInt);
    }

}
