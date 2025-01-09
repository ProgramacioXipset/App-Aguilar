import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarContrasenaUsuarioComponent } from './editar-contrasena-usuario.component';

describe('EditarContrasenaUsuarioComponent', () => {
  let component: EditarContrasenaUsuarioComponent;
  let fixture: ComponentFixture<EditarContrasenaUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditarContrasenaUsuarioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarContrasenaUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
