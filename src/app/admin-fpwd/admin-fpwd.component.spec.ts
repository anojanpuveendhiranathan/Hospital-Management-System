import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFpwdComponent } from './admin-fpwd.component';

describe('AdminFpwdComponent', () => {
  let component: AdminFpwdComponent;
  let fixture: ComponentFixture<AdminFpwdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFpwdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFpwdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
