package com.example.scanner;

import com.example.calculator.Calculator;
import org.checkerframework.checker.units.qual.C;

import java.util.Scanner;

public class ScannerExample {

    //We can use the scanner class from Java utils to take in user input
    //and do some logic, we will create a super quick user input calculator
    //We first need the scanner class
    //The scanner needs an input string, we are using System.in
    static Scanner input = new Scanner(System.in);

    static Calculator calc = new Calculator();

    public static void main(String args[]){

        //We will setup a simple infinite loop that will continually ask for user input
        boolean done = false;
        while(!done){

            //We will print some information to the user, and ask them what they would like to do
            System.out.println("Welcome to our calculator");
            System.out.println("What would you like to do today?");
            System.out.println("Options: + - * /");

            //We want to use the .nextLine() which will wait until the user sends an enter command
            String op = input.nextLine();

            //We are not doing any strict checking for correctness
            //But we will use the switch statement to switch between the input types
            switch(op){
                case "+":
                    System.out.println("Adding");
                    break;
                case "-":
                    System.out.println("Subtracting");
                    break;
                case "*":
                    System.out.println("Multiplying");
                    break;
                case "/":
                    System.out.println("Dividing");
                    break;
            }

        }

    }



}
