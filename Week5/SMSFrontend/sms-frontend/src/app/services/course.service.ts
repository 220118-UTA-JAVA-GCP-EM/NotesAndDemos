import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Subject, throwError } from 'rxjs';
import { ICourse } from '../Interfaces/ICourse';
//import { COURSES } from '../mock-courses';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  //We saw how to make a request and return an observable, now lets use a subject

  courses: ICourse[] = [];

  subject:Subject<ICourse[]> = new Subject<ICourse[]>();

  constructor(private http:HttpClient) { }

  getCourses(): void{
    this.http.get<ICourse[]>('http://localhost:7000/courses')
      .pipe(
        catchError((e) => {
          return throwError(e);
        })
      ).subscribe((data) => {
        console.log(data);
        this.courses = data;
        this.subject.next(this.courses);
      });
  }

  addCourse(num:number, name:string, subject:string){
    let course = {
      courseId: 0,
      subject,
      number: num,
      name,
      teacher: {},
      topics: [],
      students: []
    }

    this.http.post<ICourse>('http://localhost:7000/course', JSON.stringify(course))
      .pipe(
        catchError((e) => {
          return throwError(e);
        }))
        .subscribe((data) => {
          this.courses.push(data);
          this.subject.next(this.courses);
        })

  }
}
