import { TestBed } from '@angular/core/testing';

import { BesprekingService } from './bespreking.service';

describe('BesprekingService', () => {
  let service: BesprekingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BesprekingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
