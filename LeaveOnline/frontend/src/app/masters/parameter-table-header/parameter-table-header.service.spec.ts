import { TestBed, inject } from '@angular/core/testing';

import { ParameterTableHeaderService } from './parameter-table-header.service';

describe('ParameterTableHeaderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ParameterTableHeaderService]
    });
  });

  it('should be created', inject([ParameterTableHeaderService], (service: ParameterTableHeaderService) => {
    expect(service).toBeTruthy();
  }));
});
