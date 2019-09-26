import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListByEmployeeIdComponent } from './list-by-employee-id.component';

describe('ListByEmployeeIdComponent', () => {
  let component: ListByEmployeeIdComponent;
  let fixture: ComponentFixture<ListByEmployeeIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListByEmployeeIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListByEmployeeIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
