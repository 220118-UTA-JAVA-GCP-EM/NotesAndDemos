package com.example.exceptions;

public class AssignmentPastDueException extends Exception {

    public AssignmentPastDueException(){
        super("Assignment past due");
    }

}
