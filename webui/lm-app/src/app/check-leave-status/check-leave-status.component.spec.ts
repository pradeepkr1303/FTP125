import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckLeaveStatusComponent } from './check-leave-status.component';

describe('CheckLeaveStatusComponent', () => {
  let component: CheckLeaveStatusComponent;
  let fixture: ComponentFixture<CheckLeaveStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckLeaveStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckLeaveStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
