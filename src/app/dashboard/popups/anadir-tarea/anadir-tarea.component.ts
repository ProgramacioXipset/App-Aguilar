import { Component, inject } from '@angular/core';
import { User } from '../../../classes/user';
import { FechaService } from '../../../servicios/fecha.service';
import { UserService } from '../../../servicios/user.service';
import { EventosService } from '../../../servicios/eventos.service';
import { Subscription } from 'rxjs';
import { Cliente } from '../../../classes/cliente';
import { ClienteService } from '../../../servicios/cliente.service';
import { Grua } from '../../../classes/grua';
import { GruaService } from '../../../servicios/grua.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { TareaService } from '../../../servicios/tarea.service';
import { Tarea } from '../../../classes/tarea';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';
import { AnadirClienteComponent } from '../anadir-cliente/anadir-cliente.component';

@Component({
  selector: 'app-anadir-tarea',
  templateUrl: './anadir-tarea.component.html',
  styleUrl: './anadir-tarea.component.css'
})
export class AnadirTareaComponent {
  private _snackBar = inject(MatSnackBar);
  usuarios: User[] = [];
  clientes: Cliente[] = [];
  gruas: Grua[] = [];
  options: FormGroup;
  private userCreatedSubscription!: Subscription;
  private clienteCreatedSubscription!: Subscription;

  usuarioControl = new FormControl();
  fechaControl = new FormControl();
  horaControl = new FormControl();
  clienteControl = new FormControl();
  gruaControl = new FormControl();
  duracionControl = new FormControl();
  notaControl = new FormControl();

  constructor(private _formBuilder: FormBuilder, public user: UserService, private eventosService: EventosService, private clientesService: ClienteService, private gruasService: GruaService, private tareasService: TareaService, public dialog: MatDialog) {
    this.options = this._formBuilder.group({
      usuarioControl: this.usuarioControl,
      fechaControl: this.fechaControl,
      horaControl: this.horaControl,
      clienteControl: this.clienteControl,
      gruaControl: this.gruaControl,
      duracionControl: this.duracionControl,
      notaControl: this.notaControl
    });
  }

  ngOnInit(): void {
    this.cargarUsuarios();
    this.cargarClientes();

    this.userCreatedSubscription = this.eventosService.userCreated$.subscribe(() => {
      this.cargarUsuarios();
    });

    this.clienteCreatedSubscription = this.eventosService.clienteCreated$.subscribe(() => {
      this.cargarClientes();
    });

    this.gruasService.getGruas().subscribe(
      (gruas: any[]) => {
        this.gruas = gruas;
      },
      (error) => {
        console.error('Error al cargar los clientes:', error);
      }
    );
  }

  cargarUsuarios() {
    this.user.getUsers().subscribe(
      (usuarios: any[]) => {
        this.usuarios = usuarios;
      },
      (error) => {
        console.error('Error al cargar los usuarios:', error);
      }
    );
  }

  cargarClientes() {
    this.clientesService.getClientes().subscribe(
      (clientes: any[]) => {
        this.clientes = clientes;
      },
      (error) => {
        console.error('Error al cargar los usuarios:', error);
      }
    );
  }

  submitForm() {   
    const duracion = this.tareasService.procesarDuracion(this.duracionControl.value);
    const fechaInicio = this.tareasService.fusionarDates(this.horaControl.value, this.fechaControl.value);
    const fechaFinal = this.tareasService.procesarFechaFinal(duracion, this.fechaControl.value);
    const usuario = this.tareasService.encontrarUsuario(this.usuarioControl.value, this.usuarios);
    const grua = this.gruasService.encontrarGrua(this.gruaControl.value, this.gruas);
    const cliente = this.clientesService.encontrarCliente(this.clienteControl.value, this.clientes);
    const tarea = new Tarea(fechaInicio, fechaFinal, duracion, usuario, grua, cliente, this.notaControl.value);
    this.tareasService.postTarea(tarea).subscribe(
      (resultat: string) => {
        console.log(resultat);  // Aquí obtienes el mensaje
        this._snackBar.open(resultat, "Hecho", { duration: 3000 });
        this.options.reset();
        this.eventosService.emitTareaCreated();
      },
      (error) => {
        console.error('Error: ', error);
        this._snackBar.open("Error al enviar el formulario, puede que la grua ya esté ocupada", "Hecho", { duration: 3000 });
      }
    );
  }

  openClienteAdd(): void {
    const dialogRef = this.dialog.open(AnadirClienteComponent, {
      height: '500px',
      width: '1000px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
