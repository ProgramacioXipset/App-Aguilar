import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

const baseUrl = 'http://localhost:8181';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private user: any; // Variable para almacenar la información del usuario actual
  private user$: Subject<any>; // Subject que emite información a componentes
  private isAuthenticated = false;

  constructor(private http: HttpClient) {
    this.user$ = new Subject(); // Inicializar el Subject user$
    this.loadAuthenticationState(); // Cargar el estado de autenticación al inicializar el servicio
  }

  signup(data: any): Observable<any> {
    // Método para realizar la autenticación del usuario
    this.user = data; // Actualizar la información del usuario
    this.user$.next(this.user); // Emitir la información del usuario a través del Subject user$
    this.isAuthenticated = true;

    // Guardar el token de autenticación en el almacenamiento local
    localStorage.setItem('auth-token', this.user.token);
    localStorage.setItem('auth-username', this.user.username);

    return this.http.post(`${baseUrl}/login`, data); // Realizar una solicitud HTTP POST para autenticar al usuario
  }

  logout(): void {
    this.isAuthenticated = false;
    this.user = null; // Restablecer la información del usuario
    this.user$.next(this.user); // Notificar a los componentes suscritos sobre el cambio de estado de autenticación

    // Realizar cualquier otra acción necesaria para cerrar la sesión del usuario
    sessionStorage.removeItem('auth-token');
    sessionStorage.removeItem('auth-username');
    localStorage.removeItem('auth-token'); // También eliminamos el token del almacenamiento local
    localStorage.removeItem('auth-username'); // También eliminamos el nombre de usuario del almacenamiento local
  }

  login() {
    this.isAuthenticated = true;
  }

  getByName(name: string): Observable<any> {
    // Método para obtener información del usuario por nombre
    return this.http.get(`${baseUrl}/users/${name}`); // Realizar una solicitud HTTP GET para obtener información del usuario
  }

  add(data: any) {
    // Método para agregar un nuevo usuario
    return this.http.post(`${baseUrl}/users/`, data); // Realizar una solicitud HTTP POST para agregar un nuevo usuario
  }

  getUser$(): Observable<any> {
    // Método para obtener el Subject user$
    return this.user$.asObservable(); // Devolver el Subject user$
  }

  getIsAuthenticated(): boolean {
    return this.isAuthenticated;
  }

  loadAuthenticationState(): void {
    const authTokenSession = sessionStorage.getItem('auth-token');
    const authUsernameSession = sessionStorage.getItem('auth-username');
    const authTokenLocal = localStorage.getItem('auth-token');
    const authUsernameLocal = localStorage.getItem('auth-username');

    if ((authTokenSession && authUsernameSession) || (authTokenLocal && authUsernameLocal)) {
      this.isAuthenticated = true;
    } else {
      this.isAuthenticated = false;
    }
  }
}
