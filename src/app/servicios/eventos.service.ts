import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventosService {
  private userCreatedSource = new Subject<void>();
  private tareaCreatedSource = new Subject<void>();
  private clienteCreatedSource = new Subject<void>();

  userCreated$ = this.userCreatedSource.asObservable();
  tareaCreated$ = this.tareaCreatedSource.asObservable();
  clienteCreated$ = this.clienteCreatedSource.asObservable();

  emitUserCreated() {
    this.userCreatedSource.next();
  }

  emitTareaCreated() {
    this.tareaCreatedSource.next();
  }

  emitClienteCreated() {
    this.clienteCreatedSource.next();
  }
}
