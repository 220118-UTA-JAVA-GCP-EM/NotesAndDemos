import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'new-course',
  templateUrl: './new-course.component.html',
  styleUrls: ['./new-course.component.css']
})
export class NewCourseComponent implements OnInit {

  //To send data from the new course component to the course page we
  //need to use @Output and create a new event emitter
  @Output() sendCourse = new EventEmitter();

  //We need to declare the variables we want to store the user data into
  courseNum:Number = 0;
  courseName:String="";
  courseSubject:String="";

  onSubmit(): void {
    console.log("called:", this.courseNum, this.courseName, this.courseSubject);

    const course = {
      id: 0,
      subject: this.courseSubject,
      number: this.courseNum,
      name: this.courseName,
      teacher: ""
    }

    this.sendCourse.emit(course);

    this.courseName = "";
    this.courseNum = 0;
    this.courseSubject = "";

  }

  constructor() { }

  ngOnInit(): void {
  }

}
