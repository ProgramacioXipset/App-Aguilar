import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { authInterceptorProviders } from './auth/auth.interceptor';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { OpcionesComponent } from './dashboard/opciones/opciones.component';
import { AnadirComponent } from './dashboard/popups/anadir/anadir.component';
import { MatDialogModule } from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import { DateAdapter, MatNativeDateModule } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { DatePipe } from '@angular/common';
import { CustomDateService } from './adapters/custom-date.service';
import { registerLocaleData } from '@angular/common';
import localeEs from '@angular/common/locales/es';
import { ReactiveFormsModule } from '@angular/forms';
import { AnadirUserComponent } from './dashboard/popups/anadir-user/anadir-user.component';
import { AnadirTareaComponent } from './dashboard/popups/anadir-tarea/anadir-tarea.component';
import { AnadirClienteComponent } from './dashboard/popups/anadir-cliente/anadir-cliente.component';
import { AnadirGruaComponent } from './dashboard/popups/anadir-grua/anadir-grua.component';
import {MatButtonModule} from '@angular/material/button';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { ListaGruasComponent } from './dashboard/popups/lista-gruas/lista-gruas.component';
import {MatTableModule} from '@angular/material/table';
import { EditarGruaComponent } from './dashboard/popups/editar-grua/editar-grua.component';
import { EditarComponent } from './dashboard/popups/editar/editar.component';
import { ListaClientesComponent } from './dashboard/popups/lista-clientes/lista-clientes.component';
import { EditarClienteComponent } from './dashboard/popups/editar-cliente/editar-cliente.component';

registerLocaleData(localeEs, 'es');

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    OpcionesComponent,
    AnadirComponent,
    AnadirUserComponent,
    AnadirTareaComponent,
    AnadirClienteComponent,
    AnadirGruaComponent,
    ListaGruasComponent,
    EditarGruaComponent,
    EditarComponent,
    ListaClientesComponent,
    EditarClienteComponent // Declara LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MatInputModule,
    MatTooltipModule,
    MatDialogModule,
    MatButtonModule,
    MatSnackBarModule,
    MatTableModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatFormFieldModule,
    AppRoutingModule,
    HttpClientModule // Añade HttpClientModule a los imports
  ],
  providers: [
    authInterceptorProviders,
    DatePipe,
    CustomDateService,
    { provide: LOCALE_ID, useValue: 'es' },
    { provide: DateAdapter, useClass: CustomDateService },
    provideClientHydration(),
    provideHttpClient(withFetch()),
    provideAnimationsAsync() // Configura HttpClient con fetch
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
