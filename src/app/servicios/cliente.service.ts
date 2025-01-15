import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../classes/cliente';
import { catchError, map, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  postCliente(cliente: Cliente): Observable<string> {
    const endpoint = "http://localhost:8181/Cliente";

    const requestBody = {
      nombre: cliente.nombre,
      direccion: cliente.direccion
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

  putCliente(cliente: Cliente): Observable<string> {
    const endpoint = "http://localhost:8181/Cliente/" + cliente.id;

    const requestBody = {
      id: cliente.id,
      nombre: cliente.nombre,
      direccion: cliente.direccion
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

  deleteCliente(cliente: Cliente): Observable<string> {
    const endpoint = "http://localhost:8181/Cliente/" + cliente.id;
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

  getClientes (): Observable<Cliente[]> {
    return this.http.get<Cliente []>("http://localhost:8181/Cliente");
  }

  encontrarCliente(id: number, arrayCliente: Cliente[]): Cliente | null {
    for(const cliente of arrayCliente) {
      if (cliente.id === id) {
        return cliente;
      }
    }
    return null;
  }
}
