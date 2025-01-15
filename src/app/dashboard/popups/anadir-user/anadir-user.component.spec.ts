import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnadirUserComponent } from './anadir-user.component';

describe('AnadirUserComponent', () => {
  let component: AnadirUserComponent;
  let fixture: ComponentFixture<AnadirUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AnadirUserComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnadirUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
