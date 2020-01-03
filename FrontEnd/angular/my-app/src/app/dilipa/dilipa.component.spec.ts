import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DilipaComponent } from './dilipa.component';

describe('DilipaComponent', () => {
  let component: DilipaComponent;
  let fixture: ComponentFixture<DilipaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DilipaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DilipaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
