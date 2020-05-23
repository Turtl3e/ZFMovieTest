import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActorDialogComponent } from './actor-dialog.component';

describe('ActorDialogComponent', () => {
  let component: ActorDialogComponent;
  let fixture: ComponentFixture<ActorDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActorDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
