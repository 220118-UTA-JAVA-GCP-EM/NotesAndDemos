package com.example.controllers;

import com.example.exceptions.AssignmentPastDueException;
import com.example.models.Assignment;
import com.example.models.Person;
import com.example.services.AssignmentService;
import com.example.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private AssignmentService as;
    private PersonService ps;

    public AssignmentController(){}

    @Autowired
    public AssignmentController(AssignmentService as, PersonService ps){
        this.as = as;
        this.ps = ps;
    }

    @PostMapping("/")
    public Assignment createAssignment(@RequestBody LinkedHashMap<String, String> body){
        Person s = ps.getPersonById(Integer.parseInt(body.get("person")));

        Date d = Date.valueOf(body.get("due"));

        return as.createNewAssignment(0, s, d);
    }

    @GetMapping("/student/{id}")
    public List<Assignment> getAssignmentsByStudent(@PathVariable("id")int id){
        Person s = ps.getPersonById(id);
        return as.getStudentsAssignment(s);
    }

    @PutMapping("/submit/{id}")
    public ResponseEntity<Object> turnInAssignment(@PathVariable("id")int id){
        Assignment a= as.getAssignmentById(id);
        try{
            as.turnInAssignment(a);
        } catch (AssignmentPastDueException e){
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(as.getAssignmentById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/grade")
    public Assignment gradeAssignment(@RequestBody LinkedHashMap<String, String> body){
        Assignment a = as.getAssignmentById(Integer.parseInt(body.get("assignment")));

        return as.gradeAssignment(Double.parseDouble(body.get("grade")), a);
    }


}
