import { TestBed, inject } from '@angular/core/testing';

import { AutoCompleteDropdownService } from './auto-complete-dropdown.service';

describe('AutoCompleteDropdownService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AutoCompleteDropdownService]
    });
  });

  it('should be created', inject([AutoCompleteDropdownService], (service: AutoCompleteDropdownService) => {
    expect(service).toBeTruthy();
  }));
});
