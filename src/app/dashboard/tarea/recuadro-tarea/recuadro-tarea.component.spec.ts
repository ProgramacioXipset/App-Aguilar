import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecuadroTareaComponent } from './recuadro-tarea.component';

describe('RecuadroTareaComponent', () => {
  let component: RecuadroTareaComponent;
  let fixture: ComponentFixture<RecuadroTareaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RecuadroTareaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecuadroTareaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
