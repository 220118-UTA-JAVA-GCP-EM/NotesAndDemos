package com.example.arrsandops;

public class ArrayAndControlFlowDriver {

    public static void main(String[] args) throws Exception{

        Arrays a = new Arrays();

        System.out.println(a.accessIndex(2, a.numbers));

        a.setName(0, "Ethan");
        a.setName(1, "Caroline");
        a.setName(2, "Ben");
        a.setName(3, "Warren");
        a.setName(4, "Noah");

        System.out.println(a.arraySize(a.names));

        System.out.println(a.valueAt2d(a.myOther2dArray, 1,3));



    }

}
