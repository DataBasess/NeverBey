import { TestBed, inject } from '@angular/core/testing';

import { ParameterTableDetailService } from './parameter-table-detail.service';

describe('ParameterTableDetailService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ParameterTableDetailService]
    });
  });

  it('should be created', inject([ParameterTableDetailService], (service: ParameterTableDetailService) => {
    expect(service).toBeTruthy();
  }));
});
