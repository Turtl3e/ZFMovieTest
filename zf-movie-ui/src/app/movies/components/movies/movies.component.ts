import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';
import { MovieDialogFormComponent } from '../../dialogs/movie-dialog-form/movie-dialog-form.component';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
export class MoviesComponent implements OnInit {

  movies: Movie[];

  constructor(private movieService: MovieService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(): void {
    this.movieService.getMovies().subscribe((movies: Movie[]) => this.movies = movies);
  }

  onMovieDelete(movieToDeleteId: number): void {
    this.movieService.deleteMovie(movieToDeleteId).subscribe(() => this.removeMovieFromList(movieToDeleteId))
  }

  private removeMovieFromList(id: number) {
    this.movies = this.movies.filter(movie => movie.pieceId != id);
  }

  openCreateMovieDialog() {
    this.dialog.open(MovieDialogFormComponent).afterClosed().subscribe((createdMovie: Movie) => {
      if (createdMovie) {
        this.movies.push(createdMovie);
      }
    })
  }
}
