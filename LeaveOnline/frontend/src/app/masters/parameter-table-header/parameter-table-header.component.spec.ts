import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParameterTableHeaderComponent } from './parameter-table-header.component';

describe('ParameterTableHeaderComponent', () => {
  let component: ParameterTableHeaderComponent;
  let fixture: ComponentFixture<ParameterTableHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParameterTableHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParameterTableHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
