import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllEmployeeComponent } from './list-all-employee.component';

describe('ListAllEmployeeComponent', () => {
  let component: ListAllEmployeeComponent;
  let fixture: ComponentFixture<ListAllEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListAllEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAllEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
