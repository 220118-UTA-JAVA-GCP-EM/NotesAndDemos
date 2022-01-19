package com.example.wrappers;

public class Wrappers {

    public static void main(String args[]){

        //There are multiple ways to create a wrapper instance
        //1. The same way you would create a primitive
        Integer sirSavageTheTwentyFirst = 21;
        Character polo = 'G';

        //2. Parsing them from other data types
        Integer bobbyBrackins = Integer.parseInt("143");
        Double nickelBack = Double.parseDouble(".05");

        //3. Using a constructor
        Double fiftyCent = new Double(.50);

        int primInt = 5;
        double primCDouble = 10.0;

        Wrappers rap = new Wrappers();

        rap.autoboxing(primInt, primCDouble);
        rap.unboxing(sirSavageTheTwentyFirst, nickelBack);

        //The other advantange of using wrapper classes is the methods that come with them
        int primeTwentyOneSavage = sirSavageTheTwentyFirst.intValue();

        char letterG = polo.charValue();

        String lookAtThisPrim = nickelBack.toString();

        Byte maxByte = Byte.MAX_VALUE;

    }
    public void autoboxing(Integer x, Double y){
        System.out.println("We can automatically convert primitives to wrappers in Java");
        System.out.println(x + y);
    }

    public void unboxing(int x, double y){
        System.out.println("We can automatically convert wrappers to primitives in Java");
        System.out.println(x + y);
    }

}
