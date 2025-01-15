import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FechaService {
  private fechaSubject: Subject<Date> = new Subject<Date>();
  currentDate$ = this.fechaSubject.asObservable();

  hoy: Date = this.getInicioDelDia(new Date());

  constructor() {
    this.hoy = new Date();
    this.fechaSubject.next(this.hoy);
  }

  diaSiguiente() {
    this.hoy = new Date(this.hoy.getTime() + 24 * 60 * 60 * 1000); // Avanza un día
    this.fechaSubject.next(this.hoy);
  }
  
  diaAnterior() {
    this.hoy = new Date(this.hoy.getTime() - 24 * 60 * 60 * 1000); // Retrocede un día
    this.fechaSubject.next(this.hoy);
  }
  
  setFecha(fecha: Date) {
    this.hoy = new Date(fecha); // Crea una nueva instancia
    this.fechaSubject.next(this.hoy);
  }

  getHoy(): Date {
    return this.hoy;
  }

  private getInicioDelDia(fecha: Date): Date {
    return new Date(fecha.getFullYear(), fecha.getMonth(), fecha.getDate());
  }
}
