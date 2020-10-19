import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservasFormComponent } from './reservas-form.component';

describe('ReservasFormComponent', () => {
  let component: ReservasFormComponent;
  let fixture: ComponentFixture<ReservasFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservasFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservasFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
