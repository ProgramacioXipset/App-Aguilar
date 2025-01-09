import { Cliente } from "./cliente";
import { Grua } from "./grua";
import { User } from "./user";

export class Tarea {
    id: any;
    constructor(
        public fecha_inicio: Date,
        public fecha_final: Date,
        public duracion: number,
        public usuario: User | null,
        public grua: Grua | null,
        public cliente: Cliente | null
    ) {}
}
