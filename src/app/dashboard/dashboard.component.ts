import { UserService } from '../servicios/user.service';
import { FechaService } from './../servicios/fecha.service';
import { Component } from '@angular/core';
import { User } from '../interfaces/user'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  hoy: Date = new Date();
  usuarios: User [] = [];

  constructor(public fechaService: FechaService, public user: UserService) {}

  ngOnInit(): void {
    this.fechaService.currentDate$.subscribe(date => {
      this.hoy = this.fechaService.getHoy();
    });

    this.user.getUsers().subscribe((data) => {
      this.usuarios = data; // La respuesta debe ajustarse a la interfaz Usuario
    });
  }
}
