package com.example.aspects;

import com.example.models.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    public LoggingAspect(){
    }

    /*
     * PointCut expressions are used to select joinpoints, or in other workds, pointcuts target a subset of joinpoints
     * PointCut expression symbols
     * "*" is a wildcard that for return types, methods, and single parameter in a parameter list
     * ".." us a wildcard for the parameter list of a method
     * These examples are from another trainers examples, but you can still take a look to see some examples of more wildcard use
     * @Before("execution(* *(..)") this will execute on all the methods
     * @Before("execution(* draw*(..))") this one will match any method with draw in the name and one or zero parameter
     * @Before("execution(int *aw*(..))") this one will match any method that returns an integer and has aw in the method name, with one or zero parameters
     * @Before("execution(* *(char, int)") this one will match any method that takes in a char and int as its paramaters
     * @Before("execution(* *aw*(..,int))") this one will match any method with aw in its name, and has 1 or 2 paremeters, the second parameter being an int
     * @Before("execution(protected * *(..)") this one will match any method with one or zero parameters that is protected
     */

    //Create a set of joinpoints that gets called before the execution of any method in the application
    /*
    @Before("execution(* *(..))")
    public void printBeforeAllMethods(JoinPoint jp){
        System.out.println("This should print before every method call");
        System.out.println("Method: " + jp.getSignature() + " was called");
    }
     */

    //Execute this advice before any method from PersonService is called
    @Before("execution(* com.example.services.PersonService.*(..))")
    public void beforeAnyPersonService(JoinPoint jp){
        System.out.println("Person service method: " + jp.getSignature() + " was called");
    }

    //Execute this advice after the assign teacher method throws an exception
    @AfterThrowing("execution(* com.example.services.CourseService.assignTeacher(..))")
    public void notATeacher(JoinPoint jp){
        System.out.println("Person is not a teacher");
    }

    //Do some logic after a method successfully returns
    @AfterReturning("execution(com.example.models.Assignment *(..))")
    public void afterReturningAnAssignment(JoinPoint jp){
        System.out.println("An assignment was returned from:");
        System.out.println(jp.getSignature());
    }

    @After("execution(* com.example.services.AssignmentService.*(..))")
    public void afterReturn(JoinPoint jp){
        System.out.println("This will print even if there was an exception");
    }

    @Around("execution(* com.example.services.PersonService.create*(..))")
    public Person aroundCreate(ProceedingJoinPoint pjp) throws Throwable {
        //This half of our advice will act as @Before
        System.out.println("We have a new person registering");
        for(int i=0; i<pjp.getArgs().length; i++){
            System.out.println(pjp.getArgs()[i]);
        }

        //Everything after proceed keyword acts as @After
        Person registered = (Person) pjp.proceed();
        System.out.println("Person: " + registered + " was registered");

        return registered;
    }

}
