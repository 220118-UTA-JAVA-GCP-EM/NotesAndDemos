package com.example.controllers;

import com.example.models.Person;
import com.example.models.Type;
import com.example.repository.PersonRepository;
import com.example.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/person")
@CrossOrigin("*")
public class PersonController {

    private PersonService ps;

    public PersonController(){

    }

    @Autowired
    public PersonController(PersonService ps){
        this.ps = ps;
    }

    //To map our methods to a controller uri we use @PostMapping, @GetMapping, @PutMapping...
    @PostMapping("/")
    @ResponseBody
    public Person createUser(@RequestBody Person p){
        //Here we would go about storing the person in our database
        return ps.createNewPerson(p.getPersonId(), p.getType(), p.getFirst(), p.getLast(), p.getPassword());
    }

    @GetMapping("/")
    @ResponseBody
    public List<Person> getAllPeople(){
        return ps.getAllPeople();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Person getPersonById(@PathVariable("id")int id){
        return ps.getPersonById(id);
    }

}
