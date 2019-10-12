import { TestBed } from '@angular/core/testing';

import { PrimeMarketService } from './prime-market.service';

describe('PrimeMarketService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PrimeMarketService = TestBed.get(PrimeMarketService);
    expect(service).toBeTruthy();
  });
});
