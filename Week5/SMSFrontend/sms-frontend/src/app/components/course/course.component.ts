import { Component, OnInit, Input } from '@angular/core';
import { ICourse } from 'src/app/Interfaces/ICourse';

@Component({
  selector: 'course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  @Input() course:ICourse = {
    id: 0,
    subject: "",
    number: 0,
    name: "",
    teacher: ""
  };

  //We will use the selected var to play with the ngIf
  selected: boolean = false;

  selectCourse(): void{
    this.selected = !this.selected;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
