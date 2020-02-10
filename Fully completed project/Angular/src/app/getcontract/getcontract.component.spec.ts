import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetcontractComponent } from './getcontract.component';

describe('GetcontractComponent', () => {
  let component: GetcontractComponent;
  let fixture: ComponentFixture<GetcontractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetcontractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetcontractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
