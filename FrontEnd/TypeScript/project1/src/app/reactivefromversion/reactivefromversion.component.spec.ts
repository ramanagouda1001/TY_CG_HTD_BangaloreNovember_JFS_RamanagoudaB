import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReactivefromversionComponent } from './reactivefromversion.component';

describe('ReactivefromversionComponent', () => {
  let component: ReactivefromversionComponent;
  let fixture: ComponentFixture<ReactivefromversionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReactivefromversionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReactivefromversionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
