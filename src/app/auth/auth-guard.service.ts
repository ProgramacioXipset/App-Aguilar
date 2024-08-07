import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../servicios/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

  constructor(private loginService: LoginService, private router: Router) {}

  canActivate(): Observable<boolean> | Promise<boolean> | boolean {

    const isAuthenticated = this.loginService.getIsAuthenticated();
    // Verificar si el usuario ha iniciado sesión
    if (isAuthenticated) {
      return true; // Usuario autenticado, permite el acceso a la ruta
    } else {
      this.router.navigate(['/login']); // Redirigir al usuario a la página de inicio de sesión
      return false; // No permite el acceso a la ruta
    }
  }
}
