import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RamanagoudaComponent } from './ramanagouda.component';

describe('RamanagoudaComponent', () => {
  let component: RamanagoudaComponent;
  let fixture: ComponentFixture<RamanagoudaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RamanagoudaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RamanagoudaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
