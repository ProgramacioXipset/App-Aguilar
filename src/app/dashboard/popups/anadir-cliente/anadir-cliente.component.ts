import { Component, inject } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cliente } from '../../../classes/cliente';
import { ClienteService } from '../../../servicios/cliente.service';
import { EventosService } from '../../../servicios/eventos.service';

@Component({
  selector: 'app-anadir-cliente',
  templateUrl: './anadir-cliente.component.html',
  styleUrl: './anadir-cliente.component.css'
})
export class AnadirClienteComponent {
  private _snackBar = inject(MatSnackBar);
  nombreCliente = new FormControl();
  direccionCliente = new FormControl();
  options: FormGroup;
  resultat: string = "";

  constructor(private _formBuilder: FormBuilder, private eventosService: EventosService, private clienteService: ClienteService) {
    this.options = this._formBuilder.group({
      nombreCliente: this.direccionCliente,
      direccionCliente: this.direccionCliente
    });
  }

  submitForm() {
    const cliente = new Cliente(this.nombreCliente.value, this.direccionCliente.value);
    this.clienteService.postCliente(cliente).subscribe(
      (resultat: string) => {
        console.log(resultat);  // Aquí obtienes el mensaje
        this._snackBar.open(resultat, "Hecho", { duration: 3000 });
        this.eventosService.emitClienteCreated();
        this.options.reset();
      },
      (error) => {
        console.error('Error: ', error);
        this._snackBar.open("Error al enviar el formulario", "Hecho", { duration: 3000 });
      }
    );
  }
}
