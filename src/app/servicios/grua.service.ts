import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Grua } from '../classes/grua';
import { catchError, map, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GruaService {

  constructor(private http: HttpClient) { }

  postGrua(grua: Grua): Observable<string> {
    const endpoint = "http://localhost:8181/Grua";

    const requestBody = {
      nombre: grua.nombre
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

  putGrua(grua: Grua): Observable<string> {
    const endpoint = "http://localhost:8181/Grua/" + grua.id;

    const requestBody = {
      id: grua.id,
      nombre: grua.nombre
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

  deleteGrua(grua: Grua): Observable<string> {
    const endpoint = "http://localhost:8181/Grua/" + grua.id;
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

  getGruas (): Observable<Grua[]> {
    return this.http.get<Grua []>("http://localhost:8181/Grua");
  }
}
