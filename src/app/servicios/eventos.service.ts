import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventosService {
  private userCreatedSource = new Subject<void>();
  private tareaCreatedSource = new Subject<void>();

  userCreated$ = this.userCreatedSource.asObservable();
  tareaCreated$ = this.tareaCreatedSource.asObservable();

  emitUserCreated() {
    this.userCreatedSource.next();
  }

  emitTareaCreated() {
    this.tareaCreatedSource.next();
  }
}
