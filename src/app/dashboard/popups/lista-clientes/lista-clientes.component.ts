import { Component } from '@angular/core';
import { Cliente } from '../../../classes/cliente';
import { ClienteService } from '../../../servicios/cliente.service';
import { MatDialog } from '@angular/material/dialog';
import { EditarClienteComponent } from '../editar-cliente/editar-cliente.component';

@Component({
  selector: 'app-lista-clientes',
  templateUrl: './lista-clientes.component.html',
  styleUrl: './lista-clientes.component.css'
})
export class ListaClientesComponent {
  clientes: Cliente[] = [];

  constructor(private clienteService: ClienteService, public dialog: MatDialog) {}

  ngOnInit(): void {
    this.clienteService.getClientes().subscribe((data) => {
      this.clientes = data.reverse(); // La respuesta debe ajustarse a la interfaz Usuario
    });
  }

  openDialog(cliente: Cliente): void {
    const dialogRef = this.dialog.open(EditarClienteComponent, {
      data: { cliente: cliente },
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
