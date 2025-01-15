import { Component, inject, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../../../servicios/user.service';
import { User } from '../../../classes/user';
import { EventosService } from '../../../servicios/eventos.service';

const mailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

@Component({
  selector: 'app-anadir-user',
  templateUrl: './anadir-user.component.html',
  styleUrl: './anadir-user.component.css'
})
export class AnadirUserComponent {
  private _snackBar = inject(MatSnackBar);
  nombreUsuario = new FormControl();
  apellidoUsuario = new FormControl();
  contrasenaUsuario = new FormControl();
  emailUsuario;
  rolUsuario = new FormControl();
  options: FormGroup;
  resultat: string = "";
  hide = signal(true);

  constructor(private _formBuilder: FormBuilder, private userService: UserService, private eventosService: EventosService) {
    this.emailUsuario = new FormControl("", Validators.pattern(mailPattern));
    
    this.options = this._formBuilder.group({
      nombreUsuario: this.nombreUsuario,
      apellidoUsuario: this.apellidoUsuario,
      contrasenaUsuario: this.contrasenaUsuario,
      emailUsuario: this.emailUsuario,
      rolUsuario: this.rolUsuario,
    });
  }

  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }

  submitForm() {
    var rolString: string;
    if (this.rolUsuario.value) {
      rolString = "ADMIN";
    } else {
      rolString = "USER";
    }
    const user = new User(this.nombreUsuario.value, this.contrasenaUsuario.value, this.emailUsuario.value ?? "", this.apellidoUsuario.value, rolString);
    this.userService.postUser(user).subscribe(
      (resultat: string) => {
        console.log(resultat);  // Aquí obtienes el mensaje
        this._snackBar.open(resultat, "Hecho", { duration: 3000 });
        this.options.reset();
        this.eventosService.emitUserCreated();
      },
      (error) => {
        console.error('Error: ', error);
        this._snackBar.open("Error al enviar el formulario", "Hecho", { duration: 3000 });
      }
    );
  }
}
