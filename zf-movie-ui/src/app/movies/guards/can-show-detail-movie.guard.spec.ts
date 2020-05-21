import { TestBed } from '@angular/core/testing';

import { CanShowDetailMovieGuard } from './can-show-detail-movie.guard';

describe('CanShowDetailMovieGuard', () => {
  let guard: CanShowDetailMovieGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(CanShowDetailMovieGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
