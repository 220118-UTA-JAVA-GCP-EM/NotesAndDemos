import { Injectable } from '@angular/core';
import { IUser } from '../Interfaces/IUser';
import {HttpClient} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs';
import { ICourse } from '../Interfaces/ICourse';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user:IUser = {
    id: 0,
    username: ""
  }

  login(email:string, password:string):Observable<IUser>{
    return this.http.post<IUser>("http://localhost:7000/login", JSON.stringify({email, password}))
    .pipe(catchError((e)=> {
      return throwError(e);
    }));
  }

  constructor(private http:HttpClient) { }
}
