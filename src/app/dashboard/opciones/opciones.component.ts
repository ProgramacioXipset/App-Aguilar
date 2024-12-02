import { Component, LOCALE_ID } from '@angular/core';
import { FechaService } from '../../servicios/fecha.service';
import { AnadirComponent } from '../popups/anadir/anadir.component';
import {MatDialog} from '@angular/material/dialog';
import { DatePipe } from '@angular/common';
import { FormControl } from '@angular/forms';
import { LoginService } from '../../servicios/login.service';
import { Router } from '@angular/router';
import { EditarComponent } from '../popups/editar/editar.component';

@Component({
  selector: 'app-opciones',
  templateUrl: './opciones.component.html',
  styleUrl: './opciones.component.css',
  providers: [
    DatePipe,
    { provide: LOCALE_ID, useValue: 'es' }
  ]
})
export class OpcionesComponent {
  
  selectedDate: FormControl = new FormControl();

  constructor(private loginService: LoginService, public fechaService: FechaService, public dialog: MatDialog, private router: Router) {

  }

  diaSiguiente() {
    this.fechaService.diaSiguiente();
  }

  diaAnterior() {
    this.fechaService.diaAnterior();
  }

  sortir() {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }

  setDate(selectedDate: Date) {
    console.log("Me Ejecuto!");
    
    this.selectedDate.setValue(selectedDate);
    this.fechaService.setFecha(selectedDate);
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AnadirComponent, {
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  openEditar(): void {
    const dialogRef = this.dialog.open(EditarComponent, {
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
