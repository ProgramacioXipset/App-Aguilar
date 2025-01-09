import { Cliente } from "../classes/cliente";
import { Grua } from "../classes/grua";
import { User } from "../classes/user";

export interface Tarea {
    id: number;
    fecha_inicio: Date;
    fecha_final: Date;
    duracion: number;
    usuario: User;
    grua: Grua;
    cliente: Cliente;
}
