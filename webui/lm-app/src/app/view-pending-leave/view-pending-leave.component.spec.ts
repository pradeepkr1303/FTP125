import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPendingLeaveComponent } from './view-pending-leave.component';

describe('ViewPendingLeaveComponent', () => {
  let component: ViewPendingLeaveComponent;
  let fixture: ComponentFixture<ViewPendingLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPendingLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPendingLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
