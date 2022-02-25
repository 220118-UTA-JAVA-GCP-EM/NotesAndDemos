package com.example.services;

import com.example.models.Person;
import com.example.models.Type;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private PersonRepository pr;

    public PersonService() {}

    @Autowired
    public PersonService(PersonRepository pr){
        this.pr = pr;
    }

    public Person createNewPerson(int id, Type t, String first, String last, String password){
        String email = first + "." + last + "@school.edu";
        email = email.toLowerCase();
        Person p = new Person(id, t, first, last, email, password);
        //We can use the prepackaged crud method from JPA Repo to save our person
        return pr.save(p);
    }

    //We can use the crud function findAll that comes with JPARepo to get all the users
    public List<Person> getAllPeople(){
        return pr.findAll();
    }

    public Person getPersonById(int id){
        return pr.getById(id);
    }

    public Person getPersonByEmail(String email){
        return pr.findPersonByEmail(email);
    }

    public void updatePerson(Person p){
        //If the entity in the database exists, save updates the given entity
        pr.save(p);
    }

    public void deletePerson(Person p){
        pr.delete(p);
    }

}
