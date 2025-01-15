import { Component, OnInit, Input } from '@angular/core';
import { Observer } from 'rxjs';
import { Router } from '@angular/router';
import { LoginService } from '../servicios/login.service';
import { UserService } from '../servicios/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  token: any = 'token inicial'; // Variable para almacenar el token inicial
  isLoggedIn = false; // Indicador de estado de inicio de sesión
  isLoginFailed = false; // Indicador de estado de inicio de sesión fallido
  rememberUser = false; // Estado de la casilla de verificación "Recordar usuario"

  login: any = {
    username: '',
    password: ''
  }; // Objeto para almacenar los datos de inicio de sesión

  submitted = false; // Indicador de estado de envío de formulario

  constructor(private loginService: LoginService, private servicioPerfil: UserService, private router: Router) { }

  ngOnInit(): void {
    const authToken = sessionStorage.getItem('auth-token');
    const authUsername = sessionStorage.getItem('auth-username');

    if (authToken && authUsername) {
      // Aquí puedes realizar una verificación adicional del token si es necesario
      this.isLoggedIn = true;
      this.loginService.login();
      // Redirigir al dashboard después de un inicio de sesión exitoso
      this.router.navigate(['/dashboard']);
    }

    const savedUsername = sessionStorage.getItem('rememberedUsername');
    if (savedUsername) {
      this.login.username = savedUsername;
      this.rememberUser = true;
    }
  }

  logUser(): void {
    const data = {
      username: this.login.username,
      password: this.login.password,
    };

    const observer: Observer<any> = {
      next: (response) => {
        this.token = response;
        this.submitted = true;
        window.sessionStorage.setItem('auth-token', this.token.token);
        window.sessionStorage.setItem('auth-username', this.login.username);
        this.isLoginFailed = false;
        this.isLoggedIn = true;

        if (this.rememberUser) {
          localStorage.setItem('rememberedUsername', this.login.username);
        } else {
          localStorage.removeItem('rememberedUsername');
        }

        // Redirigir al dashboard después de un inicio de sesión exitoso
        this.router.navigate(['/dashboard']);
      },
      error: (error) => {
        console.log(error);
        this.isLoginFailed = true;
      },
      complete: () => {
        // Aquí puedes realizar alguna acción cuando la suscripción se completa
      }
    };

    this.loginService.signup(data).subscribe(observer);
  }
}
