import { Component, inject, Inject, signal} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { User } from '../../../classes/user';
import { UserService } from '../../../servicios/user.service';
import { EventosService } from '../../../servicios/eventos.service';
import { EditarContrasenaUsuarioComponent } from './editar-contrasena-usuario/editar-contrasena-usuario.component';

const mailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrl: './editar-usuario.component.css'
})
export class EditarUsuarioComponent {
  private _snackBar = inject(MatSnackBar);
  nombreUsuario = new FormControl();
  apellidoUsuario = new FormControl();
  emailUsuario = new FormControl();
  rolUsuario = new FormControl();
  options: FormGroup;
  resultat: string = "";
  hide = signal(true);

  constructor(public dialog: MatDialog, @Inject(MAT_DIALOG_DATA) public data: {user: User},private _formBuilder: FormBuilder, private userService: UserService, private eventosService: EventosService) {
    this.nombreUsuario = new FormControl(this.data.user.username);
    this.apellidoUsuario = new FormControl(this.data.user.apellidos);
    this.emailUsuario = new FormControl(this.data.user.email, Validators.pattern(mailPattern));
    if(this.data.user.rol === "ADMIN"){
      this.rolUsuario = new FormControl(true);
    } else {
      this.rolUsuario = new FormControl(false);
    }

    this.options = this._formBuilder.group({
      nombreUsuario: this.nombreUsuario,
      apellidoUsuario: this.apellidoUsuario,
      emailUsuario: this.emailUsuario,
      rolUsuario: this.rolUsuario
    });
  }

  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }

  submitForm() {
    const user = this.data.user;
    user.username = this.nombreUsuario.value;
    user.apellidos = this.apellidoUsuario.value;
    user.email = this.emailUsuario.value;

    if(this.rolUsuario.value) {
      user.rol = "ADMIN";
    } else {
      user.rol = "USER";
    }

    this.userService.putUser(user).subscribe(
      (resultat: string) => {
        console.log(resultat);  // Aquí obtienes el mensaje
        this._snackBar.open(resultat, "Hecho", { duration: 3000 });
        this.eventosService.emitUserCreated();
      },
      (error) => {
        console.error('Error: ', error);
        this._snackBar.open("Error al enviar el formulario", "Hecho", { duration: 3000 });
      }
    );
  }

  eliminarUsuario() {
    this.userService.deleteUser(this.data.user).subscribe(
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

  openDialog(): void {
    const dialogRef = this.dialog.open(EditarContrasenaUsuarioComponent, {
      data: { user: this.data.user },
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
