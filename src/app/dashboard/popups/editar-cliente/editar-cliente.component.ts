import { Component, inject, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cliente } from '../../../classes/cliente';
import { ClienteService } from '../../../servicios/cliente.service';

@Component({
  selector: 'app-editar-cliente',
  templateUrl: './editar-cliente.component.html',
  styleUrl: './editar-cliente.component.css'
})
export class EditarClienteComponent {
  private _snackBar = inject(MatSnackBar);
  nombreCliente = new FormControl();
  direccionCliente = new FormControl();
  options: FormGroup;
  resultat: string = "";

  constructor(public dialog: MatDialog, @Inject(MAT_DIALOG_DATA) public data: {cliente: Cliente},private _formBuilder: FormBuilder, private clienteService: ClienteService) {
    this.nombreCliente = new FormControl(this.data.cliente.nombre);
    this.direccionCliente = new FormControl(this.data.cliente.direccion);
    
    this.options = this._formBuilder.group({
      nombreCliente: this.nombreCliente,
      direccionCliente: this.direccionCliente
    });
  }

  submitForm() {
    const cliente = this.data.cliente;
    cliente.nombre = this.nombreCliente.value;
    cliente.direccion = this.direccionCliente.value;

    this.clienteService.putCliente(cliente).subscribe(
      (resultat: string) => {
        console.log(resultat);  // Aquí obtienes el mensaje
        this._snackBar.open(resultat, "Hecho", { duration: 3000 });
        this.options.reset();
      },
      (error) => {
        console.error('Error: ', error);
        this._snackBar.open("Error al enviar el formulario", "Hecho", { duration: 3000 });
      }
    );
  }

  eliminarCliente() {
    this.clienteService.deleteCliente(this.data.cliente).subscribe(
      (resultat: string) => {
        console.log(resultat);  // Aquí obtienes el mensaje
        this._snackBar.open(resultat, "Hecho", { duration: 3000 });
        this.options.reset();
      },
      (error) => {
      }
    );
    
    this.dialog.closeAll();
  }
}
