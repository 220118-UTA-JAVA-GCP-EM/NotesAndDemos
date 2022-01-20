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
                    System.out.println("You chose addition");
                    System.out.println("Input the first operand");
                    Integer first = Integer.parseInt(input.nextLine());
                    System.out.println("Input the second operand");
                    Integer second = Integer.parseInt(input.nextLine());
                    System.out.println("Your output is: " + calc.addition(first, second));
                    break;
                case "-":
                    System.out.println("Subtracting");
                    System.out.println("Input the first operand");
                    first = Integer.parseInt(input.nextLine());
                    System.out.println("Input the second operand");
                    second = Integer.parseInt(input.nextLine());
                    System.out.println("Your output is: " + calc.subtraction(first, second));
                    break;
                case "*":
                    System.out.println("Multiplying");
                    System.out.println("Input the first operand");
                    Double firstD = Double.parseDouble(input.nextLine());
                    System.out.println("Input the second operand");
                    Double secondD = Double.parseDouble(input.nextLine());
                    System.out.println("Your output is: " + calc.multiplication(firstD, secondD));
                    break;
                case "/":
                    System.out.println("Dividing");
                    System.out.println("Multiplying");
                    System.out.println("Input the first operand");
                    firstD = Double.parseDouble(input.nextLine());
                    System.out.println("Input the second operand");
                    secondD = Double.parseDouble(input.nextLine());
                    System.out.println("Your output is: " + calc.division(firstD, secondD));
                    break;
            }

            //After calculcating the output, we can ask if they want to continue y/n, if yest
            //We will continue the loop, otherwise we will break out of the loop
            System.out.println("Are you done calculating?");
            String fin = input.nextLine();

            done = fin.equals("y") ? true : false;
        }

        System.out.println("Thank you for using our calculator. Goodbye :)");

    }



}
