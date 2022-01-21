package com.example.lambdas;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Locale;

public class LambdaDriver {

    public static void main(String args[]){

        preJavaEightFunction();

        System.out.println("Calling the add function we created in Java");
        System.out.println(add(2,3));

        System.out.println("Calling the sub function we created in Java");
        System.out.println(sub(10,3));

        //Many of the collections api datastructures has the method called foreach, that allows you loop through the collection
        //And do some logic on each element
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("WORLD");
        words.add("For");
        words.add("EaCh");
        words.add("LOOPING");

        words.forEach((String word) -> {
            word = word.toLowerCase();
            System.out.println(word);
        });

    }

    //Before java 8, this is how we would create disembodied methods
    public static void preJavaEightFunction(){

        Calculator c = new Calculator() {
            @Override
            public int calculate() {
                return 1+1;
            };
        };

        System.out.println("Calling the pre java 8 function");
        System.out.println(c.calculate());

    }

    //In java 8 we can now use lamdas to shrink the code from above
    public static int add(int x, int y){
        //We are providing the only method in the interface functionality with the lambda
        Calculator c = () -> x+y;
        return c.calculate();
    }

    public static int sub(int x, int y){
        Calculator c = () -> x-y;
        return c.calculate();
    }


}
