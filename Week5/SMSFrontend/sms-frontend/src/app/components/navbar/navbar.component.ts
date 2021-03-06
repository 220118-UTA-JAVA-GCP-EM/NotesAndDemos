import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  navigateLogin():void{
    this.router.navigate(['login']);
  }

  constructor(private router:Router) {
    console.log("In the constructor of the navbar");
   }

  ngOnInit(): void {
    console.log("In the ngOnInit of the navbar");
  }

}
