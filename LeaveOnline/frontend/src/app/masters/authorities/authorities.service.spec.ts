import { TestBed, inject } from '@angular/core/testing';
import { AuthoritiesService } from "app/masters/authorities/authorities.service";


describe('AuthoritiesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthoritiesService]
    });
  });

  it('should be created', inject([AuthoritiesService], (service: AuthoritiesService) => {
    expect(service).toBeTruthy();
  }));
  
});
