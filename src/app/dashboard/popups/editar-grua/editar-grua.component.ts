import { Component, inject, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';
import { Grua } from '../../../classes/grua';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { GruaService } from '../../../servicios/grua.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-editar-grua',
  templateUrl: './editar-grua.component.html',
  styleUrl: './editar-grua.component.css'
})
export class EditarGruaComponent {
  private _snackBar = inject(MatSnackBar);
  nombreGrua = new FormControl();
  options: FormGroup;
  resultat: string = "";


  constructor(public dialog: MatDialog, @Inject(MAT_DIALOG_DATA) public data: {grua: Grua},private _formBuilder: FormBuilder, private gruaService: GruaService) {
    this.nombreGrua = new FormControl(this.data.grua.nombre);
    
    this.options = this._formBuilder.group({
      nombreGrua: this.nombreGrua
    });
  }

  submitForm() {
    const grua = this.data.grua;
    grua.nombre = this.nombreGrua.value;

    this.gruaService.putGrua(grua).subscribe(
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
  
  eliminarGrua() {
    this.gruaService.deleteGrua(this.data.grua).subscribe(
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
