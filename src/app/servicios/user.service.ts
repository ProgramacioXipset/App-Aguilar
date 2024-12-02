import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private user: any;
  private user$: Subject<any>;

  constructor(private http: HttpClient) {
    this.user$ = new Subject();
  }

  addUser(rol: any){
    this.user = rol;
    this.user$.next(this.user);
  }

  getUser$(): Observable<any> {
    return this.user$.asObservable();
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User []>("http://localhost:8181/users/");
  }
}
