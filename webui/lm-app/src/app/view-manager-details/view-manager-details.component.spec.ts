import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewManagerDetailsComponent } from './view-manager-details.component';

describe('ViewManagerDetailsComponent', () => {
  let component: ViewManagerDetailsComponent;
  let fixture: ComponentFixture<ViewManagerDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewManagerDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewManagerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
