import { TestBed } from '@angular/core/testing';

import { RecensieService } from './recensie.service';

describe('RecensieService', () => {
  let service: RecensieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecensieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
