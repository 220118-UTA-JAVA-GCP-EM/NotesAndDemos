import { Component, OnInit } from '@angular/core';
import { ICourse } from 'src/app/Interfaces/ICourse';

@Component({
  selector: 'course-page',
  templateUrl: './course-page.component.html',
  styleUrls: ['./course-page.component.css']
})
export class CoursePageComponent implements OnInit {

  hide:boolean = true;

  courses:ICourse[] = [
    {
      id: 1,
      subject: "Art",
      number: 120,
      name: "Intro to Art",
      teacher: "Bob Ross"
    },
    {
      id: 2,
      subject: "Reading",
      number: 110,
      name: "Intro to Reading",
      teacher: "Veronica Vaughn"
    },
    {
      id: 3,
      subject: "Science",
      number: 230,
      name: "Intro to Science",
      teacher: "Valerie Frizzle"
    },
    {
      id: 4,
      subject: "Music",
      number: 230,
      name: "Intro to Rock",
      teacher: "Dewey Finn"
    }
  ];

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
    this.courses.push(this.course);
    this.hide = !this.hide;

  }

  constructor() { }

  ngOnInit(): void {
  }

}
