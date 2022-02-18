import { ComponentFixture, TestBed } from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import {HttpClientTestingModule} from '@angular/common/http/testing';

import { CoursePageComponent } from './course-page.component';
import {NewCourseComponent} from '../new-course/new-course.component';
import {CourseService} from '../../services/course.service';

import {Subject} from 'rxjs';
import {ICourse} from '../../Interfaces/ICourse';
import { By } from '@angular/platform-browser';

class MockCourseService {
  subject:Subject<ICourse[]> = new Subject<ICourse[]>();

  getCourses(){
    return [
      {
        id: 0,
        subject: 'Test',
        number: 100,
        name: 'Test'
      }
    ]
  }

  addCourse(num:number, name:string, subject:string){
    return {
        id: 0,
        subject: 'Test',
        number: 100,
        name: 'Test'
      }
  }

}

describe('CoursePageComponent', () => {
  let component: CoursePageComponent;
  let fixture: ComponentFixture<CoursePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursePageComponent, NewCourseComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [{provide: CourseService, useClass:MockCourseService}]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //The first thing our component should do, is make a call to the CourseService in ngOnInit
  it('should call the CourseService getCourses on init', () => {
    let service = fixture.debugElement.injector.get(CourseService);

    let serviceSpy = spyOn(service, 'getCourses').and.callThrough();

    component.ngOnInit();

    expect(serviceSpy).toHaveBeenCalled();

  });

  it('should call the addCourse() function in CourseService when it receives a course from new-course component', () => {
    let service = fixture.debugElement.injector.get(CourseService);

    let serviceSpy = spyOn(service, 'addCourse').and.callThrough();

    const newCourse = fixture.debugElement.query(By.directive(NewCourseComponent));

    newCourse.triggerEventHandler('sendCourse', {
      id: 0,
      subject: 'Testing',
      number: 100,
      name: 'Testing',
      teacher : {}
    });

    fixture.detectChanges();
    expect(serviceSpy).toHaveBeenCalled();
  })

});
