import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddActorToMovieDialogComponent } from './add-actor-to-movie-dialog.component';

describe('AddActorToMovieDialogComponent', () => {
  let component: AddActorToMovieDialogComponent;
  let fixture: ComponentFixture<AddActorToMovieDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddActorToMovieDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddActorToMovieDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
