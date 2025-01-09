import { Component } from '@angular/core';
import { Tarea } from '../../../classes/tarea';
import { TareaService } from '../../../servicios/tarea.service';
import { MatDialog } from '@angular/material/dialog';
import { EditarTareaComponent } from '../editar-tarea/editar-tarea.component';
import { Subscription } from 'rxjs';
import { EventosService } from '../../../servicios/eventos.service';

@Component({
  selector: 'app-lista-tarea',
  templateUrl: './lista-tarea.component.html',
  styleUrl: './lista-tarea.component.css'
})
export class ListaTareaComponent {
  tareas: Tarea[] = [];
  private tareaCreatedSubscription!: Subscription;

  constructor(private tareaService: TareaService, public dialog: MatDialog, private eventosService: EventosService) {}

  ngOnInit(): void {
    this.cargarTareas();

    this.tareaCreatedSubscription = this.eventosService.tareaCreated$.subscribe(() => {
      this.cargarTareas();
    });
  }

  cargarTareas() {
    this.tareaService.getTareas().subscribe(
      (tareas: any[]) => {
        this.tareas = tareas;
      },
      (error) => {
        console.error('Error al cargar las tareas:', error);
      }
    );
  }

  openDialog(tarea: Tarea): void {
    const dialogRef = this.dialog.open(EditarTareaComponent, {
      data: { tarea: tarea },
      height: '800px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
