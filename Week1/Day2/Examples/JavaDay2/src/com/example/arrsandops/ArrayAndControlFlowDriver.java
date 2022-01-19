package com.example.arrsandops;

import javax.naming.ldap.Control;

public class ArrayAndControlFlowDriver {

    public static void main(String[] args) throws Exception{

        Arrays a = new Arrays();

        ControlFlow cf = new ControlFlow();

        cf.ifElseIfExample(0);

        System.out.println("----------");

        cf.switchExamples("Fall");

        System.out.println("----------");

        cf.forLoopExample();

        System.out.println("----------");

        System.out.println("----------");

        System.out.println(a.accessIndex(2, a.numbers));

        a.setName(0, "Ethan");
        a.setName(1, "Caroline");
        a.setName(2, "Ben");
        a.setName(3, "Warren");
        a.setName(4, "Noah");

        cf.enhancedForLoop(a.names);

        System.out.println("----------");

        System.out.println(a.arraySize(a.names));

        System.out.println(a.valueAt2d(a.myOther2dArray, 1,2));

        System.out.println("----------");

        a.set2dIndex(0,0,10);
        a.set2dIndex(0,1,20);
        a.set2dIndex(0,2,30);
        a.set2dIndex(1,0,40);
        a.set2dIndex(1,1,50);
        a.set2dIndex(1,2,60);
        a.set2dIndex(2,0,70);
        a.set2dIndex(2,1,80);
        a.set2dIndex(2,2,90);

        cf.twoDLoop(a.my2dArray);

        System.out.println("----------");

        cf.varArgs(1,2,3,4,5,6,2,5,3,6,2,8,4,83,35,94,8,52,7,9,35,8,4,769,35,7);

        System.out.println("----------");

        cf.whileLoopExample();

        System.out.println("----------");

        cf.doWhileLoopExample(10);

    }

}
