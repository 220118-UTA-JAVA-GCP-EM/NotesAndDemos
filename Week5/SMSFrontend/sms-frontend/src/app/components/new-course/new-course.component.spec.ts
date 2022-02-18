import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';

import { NewCourseComponent } from './new-course.component';

describe('NewCourseComponent', () => {
  let component: NewCourseComponent;
  let fixture: ComponentFixture<NewCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCourseComponent ],
      imports: [RouterTestingModule, FormsModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should emit a new course when the form is submitted', () => {
    //Set the fields in the form
    component.courseNum = 100;
    component.courseName = 'Testing';
    component.courseSubject = 'Testing';

    //We will spy on the event emitter that we set up in the new course component
    spyOn(component.sendCourse, 'emit');

    //Get our submit button
    const button = fixture.nativeElement.querySelector('button');
    button.dispatchEvent(new Event('click'));

    fixture.detectChanges();

    expect(component.sendCourse.emit).toHaveBeenCalledWith({
      id: 0,
      subject: 'Testing',
      number: 100,
      name: 'Testing',
      teacher: ''
    });

  });

});
