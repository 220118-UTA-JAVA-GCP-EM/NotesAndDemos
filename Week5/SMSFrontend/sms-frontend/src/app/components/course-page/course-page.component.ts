import { Component, OnInit } from '@angular/core';
import { ICourse } from 'src/app/Interfaces/ICourse';
import { CourseService } from 'src/app/services/course.service';

@Component({
  selector: 'course-page',
  templateUrl: './course-page.component.html',
  styleUrls: ['./course-page.component.css']
})
export class CoursePageComponent implements OnInit {

  courses:ICourse[] = [];

  hide:boolean = true;

  course: ICourse = {
    id: 0,
    number: 0,
    name: "",
    subject: "",
    teacher: ""
  }

  showOrHideCourseForm(): void {
    this.hide = !this.hide;
  }

  getCourseFromNewCourse($event: any):void{

    console.log("called getCourseFromNewCourse");
    console.log($event);
    this.course = $event;
    this.addCourse(this.course);
    this.hide=!this.hide;

  }

  addCourse(course:ICourse): void {
    this.courses = this.courseService.addCourse(course);
  }

  //We need to tell angular that we want to use the service in our component
  //We do that with injection
  constructor(private courseService:CourseService) { }

  ngOnInit(): void {
    //We will use ngOnInit lifecycle method to grab the posts from our service, and display them
    this.courses = this.courseService.getCourses();
  }

}
