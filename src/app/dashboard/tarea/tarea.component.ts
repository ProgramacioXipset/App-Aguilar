import { Component, Input } from '@angular/core';
import { User } from '../../classes/user';
import { Tarea } from '../../classes/tarea';
import { Subscription } from 'rxjs';
import { EventosService } from '../../servicios/eventos.service';
import { TareaService } from '../../servicios/tarea.service';

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

  constructor(private eventosService: EventosService, public tarea: TareaService) {}

  contarTareasValidas() {
    this.tareasVisibles = this.tareas.filter(
      (tarea) =>
        this.usuario?.id === tarea.usuario?.id &&
        this.fechaDate &&
        this.compararFechas(tarea.fecha_inicio, this.fechaDate)
    );    
  }

  ngOnInit(): void {
    this.cargarTareas();

    this.tareaCreatedSubscription = this.eventosService.tareaCreated$.subscribe(() => {
      this.cargarTareas();
    });
  }

  compararFechas(fechaTarea: Date, fechaCasilla: Date): boolean {
    const fecha1 = fechaTarea instanceof Date ? fechaTarea : new Date(fechaTarea);
    const fecha2 = fechaCasilla instanceof Date ? fechaCasilla : new Date(fechaCasilla);
  
    // Validar si ambas fechas son válidas
    if (isNaN(fecha1.getTime()) || isNaN(fecha2.getTime())) {
      return false;
    }
  
    // Comparar día, mes y año
    const mismaFecha = 
      fecha1.getDate() === fecha2.getDate() &&
      fecha1.getMonth() === fecha2.getMonth() &&
      fecha1.getFullYear() === fecha2.getFullYear();
  
    if (!mismaFecha) {
      return false;
    }
  
    // Comparar si ambas fechas son por la mañana o por la tarde
    const esManana = (hora: number) => hora >= 0 && hora < 12;
    const hora1 = fecha1.getHours();
    const hora2 = fecha2.getHours();
  
    const mismaSesion = (esManana(hora1) && esManana(hora2)) || (!esManana(hora1) && !esManana(hora2));
  
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
}
