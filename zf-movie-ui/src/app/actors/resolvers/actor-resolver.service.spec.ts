import { TestBed } from '@angular/core/testing';

import { ActorResolverService } from './actor-resolver.service';

describe('ActorResolverService', () => {
  let service: ActorResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ActorResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
