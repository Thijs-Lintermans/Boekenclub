import { TestBed } from '@angular/core/testing';

import { BoekService } from './boek.service';

describe('BoekService', () => {
  let service: BoekService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BoekService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
