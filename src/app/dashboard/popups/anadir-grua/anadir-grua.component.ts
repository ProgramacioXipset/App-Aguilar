import { Component, inject } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { GruaService } from '../../../servicios/grua.service';
import { Grua } from '../../../classes/grua';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-anadir-grua',
  templateUrl: './anadir-grua.component.html',
  styleUrl: './anadir-grua.component.css'
})
export class AnadirGruaComponent {
  private _snackBar = inject(MatSnackBar);
  nombreGrua = new FormControl();
  options: FormGroup;
  resultat: string = "";

  constructor(private _formBuilder: FormBuilder, private gruaService: GruaService) {
    this.options = this._formBuilder.group({
      nombreGrua: this.nombreGrua
    });
  }

  submitForm() {
    const grua = new Grua(this.nombreGrua.value);
    this.gruaService.postGrua(grua).subscribe(
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
}
