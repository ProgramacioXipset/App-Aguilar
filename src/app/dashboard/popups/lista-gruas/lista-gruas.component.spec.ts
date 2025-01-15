import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaGruasComponent } from './lista-gruas.component';

describe('ListaGruasComponent', () => {
  let component: ListaGruasComponent;
  let fixture: ComponentFixture<ListaGruasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListaGruasComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaGruasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
