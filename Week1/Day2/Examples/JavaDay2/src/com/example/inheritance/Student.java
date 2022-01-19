package com.example.inheritance;

public class Student extends Person{

    private int studentId;
    private String occupation = "Full time student";
    private double gpa;

    public Student(){

    }

    public Student(int age, String firstName, String lastName, String gender, int id, double gpa){
        super(age, firstName, lastName, gender);
        System.out.println("In the student args constructor");
        this.studentId = id;
        this.gpa = gpa;
    }

    public void askQuestion(String question){
        System.out.println(question);
    }

    public void handInAssignment(){
        System.out.println("Assignment complete");
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getOccupation() {
        return occupation;
    }

    @Override
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
