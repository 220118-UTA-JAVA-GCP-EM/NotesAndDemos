package com.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDriver {

    public static void main(String args[]) throws Exception{

        Bicycle bike = new Bicycle();

        System.out.println("gear: " + bike.gear +", speed: " + bike.speed);

        bike.speedUp(24);

        System.out.println("gear: " + bike.gear +", speed: " + bike.speed);

        bike.speedUp(2);
        System.out.println("gear: " + bike.gear +", speed: " + bike.speed);

        try{
            bike.slowDown(26);
        } catch(NegativeSpeedException e){
            System.out.println("A exception was caught");
            bike.speed = 0;
            bike.gear = 1;
            e.printStackTrace();
        }

        System.out.println("gear: " + bike.gear + ", speed: " + bike.speed);

        try{
            throwManyExceptions(4);
        } catch (FileNotFoundException e){
            System.out.println("File not found exception thrown");
        } catch (IOException e){
            System.out.println("IO Exception was caught");
        } catch (Exception e){
            System.out.println("Some other exception was thrown");
        } finally {
            System.out.println("This will be ran no matter what");
        }

    }

    public static void throwManyExceptions(int i) throws Exception {
        switch(i){
            case 1: throw new IOException();
            case 2: throw new ClassCastException();
            case 3: throw new FileNotFoundException();
            default: throw new Exception();
        }
    }

}
