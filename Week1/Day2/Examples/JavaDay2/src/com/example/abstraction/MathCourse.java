package com.example.abstraction;

public class MathCourse extends Course implements SimpleMath{

    public MathCourse(int classId, int roomNum){
        super("Intro to Basic Math", classId, roomNum);
    }

    @Override
    void endCourse() {
        System.out.println("This course is complete");
    }

    @Override
    public void teachAdding(int a, int b) {
        System.out.println("We add a and be to get: " + (a+b));
    }

    @Override
    public void teachSubtraction(int a, int b) {
        System.out.println("We sub b by a to get: " + (a-b));
    }

    @Override
    public void teachDivision(double a, double b) {
        System.out.println("We can divide a and b to get: " + (a/b));
    }

    @Override
    public void teachMultiplication(double a, double b) {
        System.out.println("We can mulitply a and b to get: " + (a*b));
    }

    @Override
    public String[] getTopics() {
        return this.topics;
    }
}
