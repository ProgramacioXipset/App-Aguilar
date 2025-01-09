export class User implements User {
    id: any;
    constructor(
        public username: string,
        public password: string,
        public email: string,
        public apellidos: string,
        public rol: string
    ) {}
}
