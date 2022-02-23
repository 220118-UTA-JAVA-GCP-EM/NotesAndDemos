package com.example.repository;

import com.example.models.Assignment;
import com.example.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment, Integer> {

    List<Assignment> findAllByStudent(Person p);

}
