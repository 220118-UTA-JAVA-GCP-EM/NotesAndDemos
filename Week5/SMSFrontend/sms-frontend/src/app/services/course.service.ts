import { Injectable } from '@angular/core';
import { ICourse } from '../Interfaces/ICourse';
import { COURSES } from '../mock-courses';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  getCourses(): ICourse[]{
    return COURSES;
  }

  addCourse(course: ICourse): ICourse[]{
    let courses: ICourse[] = COURSES;
    courses.push(course);
    return courses;
  }

  constructor() { }
}
