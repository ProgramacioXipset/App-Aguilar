import { Component } from '@angular/core';
import { User } from '../../../classes/user';
import { UserService } from '../../../servicios/user.service';
import { EditarUsuarioComponent } from '../editar-usuario/editar-usuario.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrl: './lista-usuario.component.css'
})
export class ListaUsuarioComponent {
  usuarios: User[] = [];

  constructor(private usuarioService: UserService, public dialog: MatDialog) {}

  ngOnInit(): void {
    this.usuarioService.getUsers().subscribe((data) => {
      this.usuarios = data;
    });
  }

  openDialog(user: User): void {
    const dialogRef = this.dialog.open(EditarUsuarioComponent, {
      data: { user: user },
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
