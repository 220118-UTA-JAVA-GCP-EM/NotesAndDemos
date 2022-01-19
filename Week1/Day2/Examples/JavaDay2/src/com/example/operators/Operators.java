package com.example.operators;

public class Operators {

    public static void main(String[] args) throws Exception{

        // Arithmetic
        //Adding
        int mySum = 4 + 5;
        System.out.println(mySum);

        //Subtracting
        int myDiff = mySum - 7;
        System.out.println(myDiff);

        //Multiply
        int myProduct = mySum * myDiff;
        System.out.println(myProduct);

        //Division if both operands are integers, java will round the values every time
        double myQuote = myDiff/mySum;
        System.out.println(myQuote);

        myQuote = 10.0/6;
        System.out.println(myQuote);

        //Modulus
        int myRemainder = 10 % 3;
        System.out.println(myRemainder);

        // Prefix vs postfix
        int x = 5;
        //Add to x then assign y equal to the value of x
        int y = ++x;

        System.out.println(y + " " + x);

        //Assign the value of x to z, then add to the value of x
        int z = x++;

        System.out.println(z + " " + x);

        //Relational Operators
        //These will return true or false depending on how they evaluate
        int a = 0;
        int b = 1;
        int c = 2;
        int d = 3;

        //Greater than, less than, greater than or equal, less than or equals
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(c < d);
        System.out.println(c <= d);
        System.out.println(d >= a);

        //equal and not equals
        System.out.println(c == d);
        System.out.println(a != b);

        //Ternary Operator
        x = 0;
        String s = x > 3 ? "x is greater than 3" : "x is not greater than 3";
        System.out.println(s);

        //Logical vs Bitwise operators and short circuiting in action
        Operators op = new Operators();
        int i = 0;
        boolean bool1 = true;
        boolean bool2 = false;
        boolean bool3 = false;

        bool3 = (bool2 & op.inc(i++)); //Increment i++
        bool3 = (bool2 && op.inc(i++)); //i does not increment because we return before calling the inc method
        bool3 = (bool1 | op.inc(i++)); //Increment i++
        bool3 = (bool1 || op.inc(i++)); //i does not increment because we return before calling the inc method

        System.out.println(i);
    }

    boolean inc(int i){
        return i > 0 ? true : false;
    }

}
