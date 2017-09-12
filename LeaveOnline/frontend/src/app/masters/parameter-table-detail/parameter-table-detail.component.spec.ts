import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParameterTableDetailComponent } from './parameter-table-detail.component';

describe('ParameterTableDetailComponent', () => {
  let component: ParameterTableDetailComponent;
  let fixture: ComponentFixture<ParameterTableDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParameterTableDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParameterTableDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
