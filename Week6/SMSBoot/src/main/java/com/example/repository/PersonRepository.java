package com.example.repository;

import com.example.models.Person;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    //Custom query to get a user by email
    Person findPersonByEmail(String email);

}
