package com.example.services;

import com.example.exceptions.NotATeacherExcption;
import com.example.models.Course;
import com.example.models.Person;
import com.example.models.Type;
import com.example.repository.CourseDao;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CourseService {

    private CourseDao cd;
    private PersonRepository pr;

    public CourseService(){}

    @Autowired
    public CourseService(CourseDao cd, PersonRepository pr){
        this.cd = cd;
        this.pr = pr;
    }

    public Course createNewCourse(int id, String subject, int number, String name){
        Course c = new Course();
        c.setCourseId(id);
        c.setSubject(subject);
        c.setNumber(number);
        c.setName(name);
        return cd.save(c);
    }

    public Course assignTeacher(Course c, Person t) throws NotATeacherExcption {
        if(t.getType() != Type.TEACHER){
            throw new NotATeacherExcption();
        }

        c.setTeacher(t);
        return cd.save(c);
    }

    public Course addStudents(Course c, Person ... p){
        List<Person> students = c.getStudents();

        Collections.addAll(students, p);

        c.setStudents(students);

        return cd.save(c);
    }

    public Course addTopic(Course c, String ... topics){
        List<String> topicList = c.getTopics();
        Collections.addAll(topicList, topics);

        c.setTopics(topicList);
        return cd.save(c);
    }

    public List<Course> getAllCourses(){
        return cd.findAll();
    }

    public Course getCourseById(int id){
        return cd.getById(id);
    }

}
