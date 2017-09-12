import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAuthorityComponent } from './menu-authority.component';

describe('MenuAuthorityComponent', () => {
  let component: MenuAuthorityComponent;
  let fixture: ComponentFixture<MenuAuthorityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuAuthorityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAuthorityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
