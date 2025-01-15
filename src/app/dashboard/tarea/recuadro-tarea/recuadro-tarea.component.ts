import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Tarea } from '../../../classes/tarea';
import { EditarClienteComponent } from '../../popups/editar-cliente/editar-cliente.component';
import { MatDialog } from '@angular/material/dialog';
import { EditarTareaComponent } from '../../popups/editar-tarea/editar-tarea.component';

@Component({
  selector: 'app-recuadro-tarea',
  templateUrl: './recuadro-tarea.component.html',
  styleUrl: './recuadro-tarea.component.css'
})
export class RecuadroTareaComponent {
  @Input() tarea?: Tarea;
  @Input() nTareas?: number;

  @Output() diaSiguiente = new EventEmitter<void>();
  @Output() diaAnterior = new EventEmitter<void>();

  constructor(public dialog: MatDialog) {}

  openDialog(tarea: Tarea | undefined): void {
    const dialogRef = this.dialog.open(EditarTareaComponent, {
      data: { tarea: tarea },
      height: '800px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  siguienteTarea(event: MouseEvent) {
    event.stopPropagation();
    this.diaSiguiente.emit();
  }

  anteriorTarea(event: MouseEvent) {
    event.stopPropagation();
    this.diaAnterior.emit();
  }
}
