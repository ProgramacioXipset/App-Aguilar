import { Component } from '@angular/core';
import { Grua } from '../../../classes/grua';
import { GruaService } from '../../../servicios/grua.service';
import {MatDialog} from '@angular/material/dialog';
import { EditarGruaComponent } from '../editar-grua/editar-grua.component';

@Component({
  selector: 'app-lista-gruas',
  templateUrl: './lista-gruas.component.html',
  styleUrl: './lista-gruas.component.css'
})
export class ListaGruasComponent {
  gruas: Grua[] = [];

  constructor(private gruaService: GruaService, public dialog: MatDialog) {}

  ngOnInit(): void {
    this.gruaService.getGruas().subscribe((data) => {
      this.gruas = data; // La respuesta debe ajustarse a la interfaz Usuario
    });
  }

  openDialog(grua: Grua): void {
    const dialogRef = this.dialog.open(EditarGruaComponent, {
      data: { grua: grua },
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
