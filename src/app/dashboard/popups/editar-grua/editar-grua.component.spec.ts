import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarGruaComponent } from './editar-grua.component';

describe('EditarGruaComponent', () => {
  let component: EditarGruaComponent;
  let fixture: ComponentFixture<EditarGruaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditarGruaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarGruaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
