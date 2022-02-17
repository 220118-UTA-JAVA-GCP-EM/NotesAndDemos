import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';
import { Router, RouterModule } from '@angular/router';
import { CoursePageComponent } from './components/course-page/course-page.component';
import { LoginComponent } from './components/login/login.component';
import { SecretComponent } from './components/secret/secret.component';
import { SecretGuard } from './guards/secret.guard';

const routes = 
    [
        {path:'', redirectTo:'/home', pathMatch:'full'},
        {path:'home', component: WelcomePageComponent},
        {path: 'courses', component: CoursePageComponent},
        {path: 'login', component: LoginComponent},
        {path: 'secret', component:SecretComponent, canActivate:[SecretGuard]}
    ]

@NgModule({
    declarations: [],
    imports: [
        CommonModule,
        RouterModule.forRoot(routes)
    ],
    exports: [RouterModule],
})

export class AppRoutingModule{}