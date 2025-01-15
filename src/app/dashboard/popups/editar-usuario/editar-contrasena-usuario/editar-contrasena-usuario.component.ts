import { Component, Inject, inject, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../../../../servicios/user.service';
import { User } from '../../../../classes/user';
import { EventosService } from '../../../../servicios/eventos.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-editar-contrasena-usuario',
  templateUrl: './editar-contrasena-usuario.component.html',
  styleUrl: './editar-contrasena-usuario.component.css'
})
export class EditarContrasenaUsuarioComponent {
  private _snackBar = inject(MatSnackBar);
  contrasenaUsuario = new FormControl();
  options: FormGroup;
  resultat: string = "";
  hide = signal(true);

  constructor(@Inject(MAT_DIALOG_DATA) public data: {user: User}, private _formBuilder: FormBuilder, private userService: UserService) {
    this.options = this._formBuilder.group({
      contrasenaUsuario: this.contrasenaUsuario
    });
  }

  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }

  submitForm() {
    const user = this.data.user;
    user.password = this.contrasenaUsuario.value;
    
    this.userService.putPassUser(user).subscribe(
      (resultat: string) => {
        console.log(resultat);  // Aquí obtienes el mensaje
        this._snackBar.open(resultat, "Hecho", { duration: 3000 });
      },
      (error) => {
        console.error('Error: ', error);
        this._snackBar.open("Error al enviar el formulario", "Hecho", { duration: 3000 });
      }
    );
  }
}
