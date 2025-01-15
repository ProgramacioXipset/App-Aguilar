import { UserService } from '../servicios/user.service';
import { FechaService } from './../servicios/fecha.service';
import { Component } from '@angular/core';
import { User } from '../interfaces/user'
import { EventosService } from '../servicios/eventos.service';
import { Subscription } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { EditarUsuarioComponent } from './popups/editar-usuario/editar-usuario.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  hoy: Date = this.getInicioDelDia(new Date());
  usuarios: User [] = [];
  private userCreatedSubscription!: Subscription;

  constructor(public dialog: MatDialog, public fechaService: FechaService, public user: UserService, private eventosService: EventosService) {}

  ngOnInit(): void {
    this.fechaService.currentDate$.subscribe(date => {
      this.hoy = this.fechaService.getHoy();
    });

    this.cargarUsuarios();

    this.userCreatedSubscription = this.eventosService.userCreated$.subscribe(() => {
      this.cargarUsuarios();
    });
  }

  cargarUsuarios() {
    this.user.getUsers().subscribe(
      (usuarios: User[]) => {
        this.usuarios = usuarios;
      },
      (error) => {
        console.error('Error al cargar los usuarios:', error);
      }
    );
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

  esPorLaTarde(date: number | Date):string {
    const horas = new Date(date).getHours();
    if(horas >= 12) {
      return "Tarde"
    } else {
      return "Mañana"
    }
  }

  private getInicioDelDia(fecha: Date): Date {
    return new Date(fecha.getFullYear(), fecha.getMonth(), fecha.getDate());
  }
}
