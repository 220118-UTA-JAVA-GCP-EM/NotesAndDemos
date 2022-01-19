package com.example.abstraction;

public class AbstractionDriver {

    public static void main(String args[]) throws Exception{
        //We can now create an instance of our MathCourse and have access to all of the methods from the abstract
        //class and the interfaces
        MathCourse mc = new MathCourse(201, 4);

        //We can get access to the name and school year properties from the abstract class
        System.out.println(mc.name + " is meant for sudents in grade: " + mc.schoolYear);

        //We can call the concrete method of the abstract class
        mc.startCourse();

        //We have access to the methods and properties from Subject Interface
        mc.printCourseIsActive();

        System.out.println("It includes topics such as: ");
        for(String topic: mc.getTopics()){
            System.out.println(topic);
        }

        //Then we provided implementation for each of the SimpleMath methods in the MathCourse
        mc.teachAdding(2,4);
        mc.teachSubtraction(5,4);
        mc.teachDivision(9,4);
        mc.teachMultiplication(5,5);

        //We are done teaching math for the day
        mc.endCourse();
    }

}
