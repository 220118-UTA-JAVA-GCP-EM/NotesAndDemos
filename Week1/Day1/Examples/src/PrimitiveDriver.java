public class PrimitiveDriver {

    //Use this convetion for single line comments
    /*
    Create multiline comments
     */
    public static void main(String arg[]) throws Exception{

        //Lets take a look at our primitives in action
        byte littleByte = 127;
        short shortStuff = 32_767;
        int bitBiggerInt = 76_543_678;

        //Java will automatially try to convert long to integers, so you must give thew number
        //a literal suffix to prevent this from happening, the literal suffix for long is L
        long bigBoi = 1234567890L;

        //Java will also automatically try to convert floats to doubles, so you must use the f literal suffix
        float floatingPoint = 3.14159f;

        double biggerFloatingPoint = 45.234;

        char payRespect = 'f';

        boolean yesOrNo = false;

        /*
            System is a class that is provided within the java.lang package, we dont need to include this package
            when creating our classes
            The System class contains several useful methods that can be invoked for our uses
            Here we can use the out class variabl, then invoke the println method witch prints things to the terminal
         */

        System.out.println("Hello this is our second java class");
        System.out.println("We can even print our variables from above");
        System.out.println("byte: " + littleByte);
        System.out.println("short " + shortStuff);
        System.out.println("int " + bitBiggerInt);
        System.out.println("long " + bigBoi);
        System.out.println("float " + floatingPoint);
        System.out.println("double " + biggerFloatingPoint);
        System.out.print("Press F to pay repect: ");
        System.out.println(payRespect);
        System.out.println("boolean " + yesOrNo);

    }

}
