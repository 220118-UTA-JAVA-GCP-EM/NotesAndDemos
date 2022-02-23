package com.example.services;

import com.example.exceptions.AssignmentPastDueException;
import com.example.models.Assignment;
import com.example.models.Person;
import com.example.repository.AssignmentRepo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class AssignmentService {

    private AssignmentRepo ar;

    public AssignmentService(){}

    @Autowired
    public AssignmentService(AssignmentRepo ar){
        this.ar = ar;
    }

    public Assignment createNewAssignment(int id, Person s, Date due){
        Assignment a = new Assignment(id, s, 0.0, false, false, due);

        return ar.save(a);
    }

    public List<Assignment> getStudentsAssignment(Person p){
        return ar.findAllByStudent(p);
    }

    public Assignment getAssignmentById(int id){
        return ar.getById(id);
    }

    public void turnInAssignment(Assignment a) throws AssignmentPastDueException {
        long today = System.currentTimeMillis();
        Date turnInDate = new Date(today);

        //Check to see if it was turned in on time
        if(turnInDate.compareTo(a.getDue()) > 0){
            a.setPastDue(true);
            a.setDone(true);
            ar.save(a);
            throw new AssignmentPastDueException();
        }
        a.setDone(true);
        ar.save(a);
    }

    public Assignment gradeAssignment(double grade, Assignment a){
        if(a.isPastDue()){
            grade = grade * .8;
            a.setGrade(grade);
        } else {
            a.setGrade(grade);
        }

        return ar.save(a);
    }

}
