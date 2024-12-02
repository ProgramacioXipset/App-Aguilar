import { Component } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { AnadirUserComponent } from '../anadir-user/anadir-user.component';
import { AnadirTareaComponent } from '../anadir-tarea/anadir-tarea.component';
import { AnadirClienteComponent } from '../anadir-cliente/anadir-cliente.component';
import { AnadirGruaComponent } from '../anadir-grua/anadir-grua.component';

@Component({
  selector: 'app-anadir',
  templateUrl: './anadir.component.html',
  styleUrls: ['./anadir.component.css']
})
export class AnadirComponent {

  constructor(public dialog: MatDialog) {}

  openTareaAdd(): void {
    console.log("Hola");
    
    const dialogRef = this.dialog.open(AnadirTareaComponent, {
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  openClienteAdd(): void {
    const dialogRef = this.dialog.open(AnadirClienteComponent, {
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  openUserAdd(): void {
    console.log("Hola");
    
    const dialogRef = this.dialog.open(AnadirUserComponent, {
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  openGruaAdd(): void {
    console.log("Hola");
    
    const dialogRef = this.dialog.open(AnadirGruaComponent, {
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
