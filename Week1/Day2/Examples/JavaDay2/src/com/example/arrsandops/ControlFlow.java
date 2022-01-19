package com.example.arrsandops;

public class ControlFlow {

    public void ifElseIfExample(int a){
        if(a < 0){
            System.out.println("The number is negative");
        } else if(a > 0){
            System.out.println("The number is positive");
        } else {
            System.out.println("The number is zero");
        }
    }

    public void switchExamples(String season){
        //Evereyone of the cases can be thought of as an individual else if block
        switch(season){
            case "Summer":
                System.out.println("Lets go to the pool/lake");
                break;
            case "Fall":
                System.out.println("Trick-or-treat");
                break;
            case "Winter":
                System.out.println("It's snowing");
                break;
            case "Spring":
                System.out.println("Springgg Breakkk");
                break;
            default:
                System.out.println("Season is not recognized");
        }
    }

    public void forLoopExample(){
        // When using a for loop, we use three things
        //Looping variable, boolean condition, increment
        for(int i=0; i<10; i++){
            System.out.println(i);
        }
    }

    public void arrayLoop(int[] arr){
        //This is how we create a standard for loop to go through an array
        //Instead of a set number in the boolean condition, we use the length of the array
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    //Enhanced for loops are essentially just for loops that are quicker to writ
    //and only loop through the length of an array
    public void enhancedForLoop(String[] arr){
        //For each item of the array
        //Store the current item in this variable
        for(String name: arr){
            System.out.println(name);
        }
    }

    public void twoDLoop(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.println(arr[i][j]);
            }
        }
    }

    //The ... gets treated as a variable sized array, you can input as many integers as you wish
    public void varArgs(int... values){
        for(int val: values){
            System.out.println(val);
        }
    }

    public void whileLoopExample(){
        //Declaring a looping variable
        int i = 10;

        //boolean expression, we run the while loop until this is false
        while(i<10){
            System.out.println(i);
            //It it important that we add to i after each iteration, otherwise with will run forever
            i++;
        }
    }

    public void doWhileLoopExample(int i){
        do{
            //Inside of these brackets is where our looping logic goes
            System.out.println(i);
            i++;
        } while(i < 10);
    }

}
