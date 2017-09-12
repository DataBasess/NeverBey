import { TestBed, inject } from '@angular/core/testing';

import { MenuAuthoritiesService } from './menu-authorities.service';

describe('MenuAuthoritiesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MenuAuthoritiesService]
    });
  });

  it('should be created', inject([MenuAuthoritiesService], (service: MenuAuthoritiesService) => {
    expect(service).toBeTruthy();
  }));
});
