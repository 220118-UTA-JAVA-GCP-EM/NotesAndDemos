import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email:string = "";
  password:string = "";
  error: boolean = false;

  onSubmit(): void{
    console.log(this.email, this.password);
    this.userService.login(this.email, this.password)
    .subscribe(data => {
      let mail="";
      if(data.email){
        mail = data.email;
      }
      this.userService.user = {
        id: data.personId,
        username: mail
      };
      this.error = false;
      this.router.navigateByUrl('/home');
    },(error) => this.error =true);

    this.email = "";
    this.password = "";
  }

  constructor(private userService:UserService, private router:Router) { }

  ngOnInit(): void {
  }

}
