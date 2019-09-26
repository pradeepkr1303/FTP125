import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveOrdenyComponent } from './approve-ordeny.component';

describe('ApproveOrdenyComponent', () => {
  let component: ApproveOrdenyComponent;
  let fixture: ComponentFixture<ApproveOrdenyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveOrdenyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveOrdenyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
