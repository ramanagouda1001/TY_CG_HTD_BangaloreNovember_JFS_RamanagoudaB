import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetlandComponent } from './getland.component';

describe('GetlandComponent', () => {
  let component: GetlandComponent;
  let fixture: ComponentFixture<GetlandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetlandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetlandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
