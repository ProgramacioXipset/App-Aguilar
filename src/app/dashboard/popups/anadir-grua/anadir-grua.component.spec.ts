import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnadirGruaComponent } from './anadir-grua.component';

describe('AnadirGruaComponent', () => {
  let component: AnadirGruaComponent;
  let fixture: ComponentFixture<AnadirGruaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AnadirGruaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnadirGruaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
