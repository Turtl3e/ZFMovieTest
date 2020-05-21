import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { MatDialogRef, MatDialog } from '@angular/material/dialog';
import { MovieDialogFormComponent } from '../../dialogs/movie-dialog-form/movie-dialog-form.component';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss']
})
export class MovieComponent implements OnInit {

  @Output() deleted = new EventEmitter<number>();
  @Input() movie: Movie;
  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  deleteMovie() {
    this.deleted.emit(this.movie.pieceId);
  }

  openEditMovieDialog() {
    this.dialog.open(MovieDialogFormComponent, { data: this.movie }).afterClosed().subscribe((updatedMovie: Movie) => {
      if (updatedMovie) {
        this.movie = updatedMovie;
      }
    })
  }

}
