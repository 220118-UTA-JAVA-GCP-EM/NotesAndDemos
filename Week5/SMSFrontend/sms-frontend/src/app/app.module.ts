import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CoursePageComponent } from './components/course-page/course-page.component';
import { NewCourseComponent } from './components/new-course/new-course.component';
import { CourseComponent } from './components/course/course.component';
import { TeacherPipe } from './pipes/teacher/teacher.pipe';
import { LoginComponent } from './components/login/login.component';
import { SecretComponent } from './compontents/secret/secret.component';


@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    NavbarComponent,
    CoursePageComponent,
    NewCourseComponent,
    CourseComponent,
    TeacherPipe,
    LoginComponent,
    SecretComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
