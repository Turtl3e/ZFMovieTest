import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieDialogFormComponent } from './movie-dialog-form.component';

describe('CreateMovieComponent', () => {
  let component: MovieDialogFormComponent;
  let fixture: ComponentFixture<MovieDialogFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [MovieDialogFormComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieDialogFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
