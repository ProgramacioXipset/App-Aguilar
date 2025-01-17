import { Component, Input } from '@angular/core';
import { User } from '../../classes/user';
import { Tarea } from '../../classes/tarea';
import { Subscription } from 'rxjs';
import { EventosService } from '../../servicios/eventos.service';
import { TareaService } from '../../servicios/tarea.service';
import { MatDialog } from '@angular/material/dialog';
import { AnadirTareaComponent } from '../popups/anadir-tarea/anadir-tarea.component';

@Component({
  selector: 'app-tarea',
  templateUrl: './tarea.component.html',
  styleUrl: './tarea.component.css'
})
export class TareaComponent {
  @Input() usuario: User | undefined; // Tipo adecuado, como objeto o string
  private _fecha: Date | string | undefined | null;
  @Input()
  set fecha(value: Date | string | undefined | null) {
    this._fecha = value;
    this.actualizarFechaDate(); // Llama a la función al cambiar la fecha
  }
  get fecha(): Date | string | undefined | null {
    return this._fecha;
  }

  private _hora: string | undefined | null;
  @Input()
  set hora(value: string | undefined | null) {
    this._hora = value;
    this.actualizarFechaDate(); // Llama a la función al cambiar la hora
  }
  get hora(): string | undefined | null {
    return this._hora;
  }
  fechaDate: Date | undefined;

  tareas: Tarea [] = [];
  tareasVisibles: any[] = [];
  visibleIndex: number = 0;
  
  private tareaCreatedSubscription!: Subscription;

  constructor(private eventosService: EventosService, public tarea: TareaService, public dialog: MatDialog) {}

  contarTareasValidas() {
    this.tareasVisibles = this.tareas.filter(
      (tarea) =>
        this.usuario?.id === tarea.usuario?.id &&
        this.fechaDate &&
        this.compararFechas(tarea.fecha_inicio, tarea.fecha_final, this.fechaDate)
    );    
  }

  ngOnInit(): void {
    this.cargarTareas();

    this.tareaCreatedSubscription = this.eventosService.tareaCreated$.subscribe(() => {
      this.cargarTareas();
    });
  }

  compararFechas(fechaInicioTarea: Date, fechaFinalTarea: Date, fechaCasilla: Date): boolean {
    const fecha1 = fechaInicioTarea instanceof Date ? fechaInicioTarea : new Date(fechaInicioTarea);
    const fecha2 = fechaCasilla instanceof Date ? fechaCasilla : new Date(fechaCasilla);
    const fecha3 = fechaFinalTarea instanceof Date ? fechaFinalTarea : new Date(fechaFinalTarea);
  
    // Validar si ambas fechas son válidas
    if (isNaN(fecha1.getTime()) || isNaN(fecha2.getTime()) || isNaN(fecha3.getTime())) {
      return false;
    }
  
    // Comparar día, mes y año
    const mismaFecha = 
      fecha1.getDate() === fecha2.getDate() &&
      fecha1.getMonth() === fecha2.getMonth() &&
      fecha1.getFullYear() === fecha2.getFullYear()&&
      fecha3.getDate() === fecha2.getDate() &&
      fecha3.getMonth() === fecha2.getMonth() &&
      fecha3.getFullYear() === fecha2.getFullYear();
  
    if (!mismaFecha) {
      return false;
    }
  
    // Comparar si ambas fechas son por la mañana o por la tarde
    const esManana = (hora: number) => hora >= 0 && hora < 12;
    const hora1 = fecha1.getHours();
    const hora2 = fecha2.getHours();
    const hora3 = fecha3.getHours();
  
    const mismaSesion = ((esManana(hora1) && esManana(hora2)) || (!esManana(hora1) && !esManana(hora2)) || (esManana(hora3) && esManana(hora2)) || (!esManana(hora3) && !esManana(hora2)));
  
    return mismaSesion;
  }

  cargarTareas() {
    this.tarea.getTareas().subscribe(
      (tareas: Tarea[]) => {
        this.tareas = tareas;
        this.contarTareasValidas();
      },
      (error) => {
        console.error('Error al cargar los usuarios:', error);
      }
    );
  }


  actualizarFechaDate(): void {
    this.fechaDate = this.convertirADate(this._fecha, this._hora);
    this.contarTareasValidas();
  }

  convertirADate(fecha: Date | string | undefined | null, hora: string | undefined | null): Date | undefined {
    if (typeof fecha === "undefined") {
      return undefined;  // O devolver una fecha por defecto si lo prefieres
    } else if (fecha instanceof Date) {     
      return new Date(fecha);
    } else if (typeof fecha === "string") {
      const meses: { [key: string]: number } = {
        'ene': 0, 'feb': 1, 'mar': 2, 'abr': 3, 'may': 4, 'jun': 5,
        'jul': 6, 'ago': 7, 'sep': 8, 'oct': 9, 'nov': 10, 'dic': 11
      };
  
      const partes = fecha.split(' '); // Divide la fecha en partes
      const dia = parseInt(partes[0], 10); // Día de la fecha
      const mes = meses[partes[1].toLowerCase() as keyof typeof meses]; // Mes correspondiente
      const año = parseInt(partes[2], 10); // Año
      var horaInt = 0;
      if (typeof hora === "string") {
        horaInt = parseInt(hora);
      }
  
      // Crea una nueva fecha con los valores obtenidos
      return new Date(año, mes, dia, horaInt);
    }
    return undefined;
  }

  siguienteTarea(tarea: Tarea){
    if (this.visibleIndex < this.tareasVisibles.length - 1) {
      this.visibleIndex++;
    }
  }

  anteriorTarea(tarea: Tarea){
    if (this.visibleIndex > 0) {
      this.visibleIndex--;
    }
  }

  dividido(tarea: Tarea): string {
    let fechaInicio = tarea.fecha_inicio instanceof Date ? tarea.fecha_inicio : new Date(tarea.fecha_inicio);
    let fechaFinal = tarea.fecha_final instanceof Date ? tarea.fecha_final : new Date(tarea.fecha_final);
    var horaInt = 1;
    
    if (typeof this._hora === "string") {
       horaInt = parseInt(this._hora);
    }
    if (fechaInicio.getHours() < 12 && fechaFinal.getHours() > 12) {
      if(horaInt === 0) {
        return "despues";
      } else if (horaInt === 12) {
        return "antes";
      } else {
        return "";
      }
    } else {
      console.log("nada " + fechaInicio + " - " + horaInt);  
      return "";
    }
  }

  nuevaTarea(){
    console.log(this.usuario?.id + "-" + this.fechaDate);
    
    const dialogRef = this.dialog.open(AnadirTareaComponent, {
      data: { 
        usuario: this.usuario,
        dia: this.fechaDate
       },
      height: '800px',
      width: '2000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
