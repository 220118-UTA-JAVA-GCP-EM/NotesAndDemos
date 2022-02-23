package com.example.controllers;

import com.example.exceptions.NotATeacherExcption;
import com.example.models.Course;
import com.example.models.Person;
import com.example.services.CourseService;
import com.example.services.PersonService;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService cs;
    private PersonService ps;

    public CourseController() {}

    @Autowired
    public CourseController(CourseService cs, PersonService ps){
        this.cs = cs;
        this.ps = ps;
    }

    @GetMapping("/")
    public List<Course> getAllCourses(){
        return cs.getAllCourses();
    }

    @PostMapping("/")
    public Course createCourse(@RequestBody Course c){
        return cs.createNewCourse(c.getCourseId(), c.getSubject(), c.getNumber(), c.getName());
    }

    @PutMapping("/teacher")
    //We have these objects called ResponseEntity, which allow to set things like the response status as well as the body
    public ResponseEntity<Object> addTeacherToCourse(@RequestBody LinkedHashMap<String, Integer> body){

        System.out.println(body);

        Course c = cs.getCourseById(body.get("courseId"));
        Person t = ps.getPersonById(body.get("teacherId"));

        try{
            c = cs.assignTeacher(c, t);
        } catch(NotATeacherExcption e){
            return new ResponseEntity<>("This is not a teacher" , HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(c, HttpStatus.ACCEPTED);
    }

    @PutMapping("/students")
    public Course addStudentsToCourse(@RequestBody LinkedHashMap<String, List<Person>> students, @RequestParam("courseId")int courseId){
        Course c = cs.getCourseById(courseId);

        List<Person> s = students.get("students");

        Person[] pList = new Person[s.size()];

        for(int i=0; i<s.size(); i++){
            pList[i] = s.get(i);
        }

        cs.addStudents(c, pList);

        return cs.getCourseById(courseId);
    }

    @PutMapping("/topics")
    public Course addTopics(@RequestBody LinkedHashMap<String, List<String>> topics, @RequestParam("courseId")int courseId){
        Course c = cs.getCourseById(courseId);

        List<String> topicList = topics.get("topics");

        String[] tList = new String[topicList.size()];

        for(int i=0; i<topicList.size(); i++){
            tList[i] = topicList.get(i);
        }

        return cs.addTopic(c, tList);
    }

}
