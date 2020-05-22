import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InlineActorComponent } from './inline-actor.component';

describe('InlineActorComponent', () => {
  let component: InlineActorComponent;
  let fixture: ComponentFixture<InlineActorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InlineActorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InlineActorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
