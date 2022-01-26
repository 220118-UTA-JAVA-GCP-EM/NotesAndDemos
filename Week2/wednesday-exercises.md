#Wednesday - 26 January 2022

The following exercises can be done individually or in a group.

## 1. Normalization 

Review the data model for the School Management System. 

Go through each of the first three normal forms. Does this data model satisfy the criteria for each? 

Are there any redundancies that could be removed or represented better? If so, draw an ERD to represent the refactored data model. The goal is third normal form.

## 2. SQL Practice

Using the sms data model, write the following SQL queries.

#### DML Practice 
1. Add a new course record to the db

2. Update General Relativity to PHYS 205 

3. Try to delete the General Physics I course. What happens? Why?

#### Writing Queries

1. Find all of the courses offered. Sort the results alphabetically by subject.

2. Find the earliest due date for an assignment.

3. Show how many people are the sms with each role.


#### Using Joins 

1. Display all of the courses and the topics associated with each course. All courses should be displayed, regardless of whether they have any topics in the db.

2. Display the student name and grade for each assignment that scored under 80. Display from lowest to highest score.

*challenge questions* 

1. Display all student and their corresponding courses. This should show every student name, and and matching courses where applicable. Teachers should not be displayed.

2. Display student names and their teacher's names side by side based on the courses they're enrolled in.


3. Self Study Topics
Explore the following topics:

#### Transaction Isolation Levels and Read Phenomena
Be able to follow the following questions:
- Why are there multiple transaction isolation levels?
- What are the different transaction isolation levels?
- What are the different read phenomena?
- Which read phenomena are prevented by each isolation level?

#### Functions and Stored Procedures
Be able to follow the following questions: 
- What is a function and a stored procedure?

#### Set Operators
Be able to follow the following questions: 
- What are set operators used for?
- What are the roles of the UNION, INTERSECT, and EXCEPT keywords?
- What is the difference between a UNION and a UNION ALL?

#### Indexes and Views
- read notes posted on these topics in sql


3. Project Work

If you have any additional time, feel free to work on your project 0.