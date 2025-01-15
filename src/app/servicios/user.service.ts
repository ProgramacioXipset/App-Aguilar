import { Injectable } from '@angular/core';
import { catchError, map, Observable, of, Subject } from 'rxjs';
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

  postUser(user: User): Observable<string> {
    const endpoint = "http://localhost:8181/users/";

    const requestBody = {
      username: user.username,
      password: user.password,
      email: user.email,
      apellidos: user.apellidos,
      rol: user.rol
    };

    if (endpoint) {
      return this.postFormData(endpoint, requestBody).pipe(
        map((response) => "Formulario enviado correctamente"), // Mapea la respuesta a un mensaje
        catchError((error) => {
          console.error(error);
          return of("Error al enviar el formulario"); // En caso de error, devuelve un mensaje
        })
      );
    } else {
      return of("Endpoint no válido"); // Si no hay endpoint válido, devuelve este mensaje
    }
  }

  postFormData(endpoint: string, formData: any) {
    return this.http.post(endpoint, formData);
  }

  putUser(user: User): Observable<string> {
    const endpoint = "http://localhost:8181/users/" + user.id;

    const requestBody = {
      id: user.id,
      username: user.username,
      email: user.email,
      apellidos: user.apellidos,
      rol: user.rol
    };

    if (endpoint) {
      return this.putFormData(endpoint, requestBody).pipe(
        map((response) => "Formulario enviado correctamente"), // Mapea la respuesta a un mensaje
        catchError((error) => {
          console.error(error);
          return of("Error al enviar el formulario"); // En caso de error, devuelve un mensaje
        })
      );
    } else {
      return of("Endpoint no válido"); // Si no hay endpoint válido, devuelve este mensaje
    }
  }

  putPassUser(user: User): Observable<string> {
    const endpoint = "http://localhost:8181/users/pass/" + user.id;

    const requestBody = {
      password: user.password
    };

    if (endpoint) {
      return this.putFormData(endpoint, requestBody).pipe(
        map((response) => "Formulario enviado correctamente"), // Mapea la respuesta a un mensaje
        catchError((error) => {
          console.error(error);
          return of("Error al enviar el formulario"); // En caso de error, devuelve un mensaje
        })
      );
    } else {
      return of("Endpoint no válido"); // Si no hay endpoint válido, devuelve este mensaje
    }
  }

  putFormData(endpoint: string, formData: any) {
    return this.http.put(endpoint, formData);
  }

  deleteUser(user: User): Observable<string> {
    const endpoint = "http://localhost:8181/users/" + user.id;
    const confirmed = confirm('¿Seguro que quieres eliminar esta grúa?');
    if (confirmed) {
      if (endpoint) {
        return this.deleteFormData(endpoint).pipe(
          map((response) => "Formulario enviado correctamente"), // Mapea la respuesta a un mensaje
          catchError((error) => {
            console.error(error);
            return of("Error al enviar el formulario"); // En caso de error, devuelve un mensaje
          })
        );
      } else {
        return of("Endpoint no válido"); // Si no hay endpoint válido, devuelve este mensaje
      }
    } else {
      return of ("")
    }
  }

  deleteFormData(endpoint: string) {
    return this.http.delete(endpoint);
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
