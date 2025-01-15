import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarea } from '../classes/tarea';
import { catchError, map, Observable, of } from 'rxjs';
import { User } from '../classes/user';

@Injectable({
  providedIn: 'root'
})
export class TareaService {

  constructor(private http: HttpClient) { }

  postTarea(tarea: Tarea): Observable<string> {
    const endpoint = "http://localhost:8181/Tarea";

    const requestBody = {
      fecha_inicio: tarea.fecha_inicio,
      fecha_final: tarea.fecha_final,
      duracion: tarea.duracion,
      usuario: { id: +tarea.usuario?.id,
                 rol: tarea.usuario?.rol
               },
      grua: { id: +tarea.grua?.id },
      cliente: { id: +tarea.cliente?.id },
      nota: tarea.nota
    };

    if (endpoint) {
      return this.postFormData(endpoint, requestBody).pipe(
        map((response) => "Formulario enviado correctamente"), // Mapea la respuesta a un mensaje
        catchError((error) => {
          console.error(error);
          return of("Error al enviar el formulario, puede que la grua ya esté ocupada"); // En caso de error, devuelve un mensaje
        })
      );
    } else {
      return of("Endpoint no válido"); // Si no hay endpoint válido, devuelve este mensaje
    }
  }

  postFormData(endpoint: string, formData: any) {
    return this.http.post(endpoint, formData);
  }

  procesarDuracion(duracionStr: string): number {
    switch(duracionStr) {
      case "rapida": {
        return 60;
      }
      case "medio-dia": {
        return 240;
      }
      case "todo-dia": {
        return 480;
      }
      case "itv": {
        return 120;
      }
      default: {
        return 0;
      }
    }
  }

  procesarDuracionInv(duracionNum: number): string {
    switch(duracionNum) {
      case 60: {
        return "rapida";
      }
      case 240: {
        return "medio-dia";
      }
      case 480: {
        return "todo-dia";
      }
      case 120: {
        return "itv";
      }
      default: {
        return "";
      }
    }
  }

  fusionarDates(hora: Date, fecha: Date): Date {
    const combinedDate = new Date(fecha);
    combinedDate.setHours(hora.getHours() + 1);
    combinedDate.setMinutes(hora.getMinutes());
    combinedDate.setSeconds(hora.getSeconds());
    combinedDate.setMilliseconds(hora.getMilliseconds());
    return combinedDate;
  }

  procesarFechaFinal(duracion: number, fechaInicio: Date): Date {
    const fechaFinal = new Date(fechaInicio);
    fechaFinal.setMinutes(fechaFinal.getMinutes() + duracion);
    return fechaFinal;
  }

  encontrarUsuario(id: number, arrayUser: User[]): User | null {
    for(const usuario of arrayUser) {
      if (usuario.id === id) {
        return usuario;
      }
    }
    return null;
  }

  getTareas (): Observable<Tarea[]> {
    return this.http.get<Tarea []>("http://localhost:8181/Tarea");
  }

  putTarea(tarea: Tarea): Observable<string> {
    const endpoint = "http://localhost:8181/Tarea/" + tarea.id;

    const requestBody = {
      id: tarea.id,
      fecha_inicio: tarea.fecha_inicio,
      fecha_final: tarea.fecha_final,
      duracion: tarea.duracion,
      usuario: { id: +tarea.usuario?.id,
                 rol: tarea.usuario?.rol
               },
      grua: { id: +tarea.grua?.id },
      cliente: { id: +tarea.cliente?.id },
      nota: tarea.nota
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

  deleteTarea(tarea: Tarea): Observable<string> {
    const endpoint = "http://localhost:8181/Tarea/" + tarea.id;
    const confirmed = confirm('¿Seguro que quieres eliminar esta tarea?');
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
}
