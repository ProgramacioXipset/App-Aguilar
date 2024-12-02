import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ListaGruasComponent } from '../lista-gruas/lista-gruas.component';
import { ListaClientesComponent } from '../lista-clientes/lista-clientes.component';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrl: './editar.component.css'
})
export class EditarComponent {

  constructor(public dialog: MatDialog) {}

  openEditarGrua() {
    const dialogRef = this.dialog.open(ListaGruasComponent, {
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
  openEditarCliente() {
    const dialogRef = this.dialog.open(ListaClientesComponent, {
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
