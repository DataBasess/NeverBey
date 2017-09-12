import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AutoCompleteDropdownComponent } from "app/commons/auto-complete-dropdown/auto-complete-dropdown.component";


describe('AutoCompleteDropdownComponent', () => {
  let component: AutoCompleteDropdownComponent;
  let fixture: ComponentFixture<AutoCompleteDropdownComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoCompleteDropdownComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoCompleteDropdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
