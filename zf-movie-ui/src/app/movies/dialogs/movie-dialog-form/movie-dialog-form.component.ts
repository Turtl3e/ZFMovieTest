import { Component, OnInit, Inject, ViewChild, Input } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { NgForm } from '@angular/forms';
import { MovieService } from 'src/app/services/movie.service';
import { MovieRequest, Movie } from 'src/app/models/movie';

@Component({
  selector: 'app-movie-dialog-form',
  templateUrl: './movie-dialog-form.component.html',
  styleUrls: ['./movie-dialog-form.component.scss']
})
export class MovieDialogFormComponent implements OnInit {

  editingOrNewMovie: Movie;
  isEditing = false;

  constructor(public dialogRef: MatDialogRef<MovieDialogFormComponent>, @Inject(MAT_DIALOG_DATA) public data: Movie, private movieService: MovieService) { }

  ngOnInit(): void {
    this.data instanceof Movie ? this.editingOrNewMovie = this.data : this.editingOrNewMovie = new Movie({});
    this.isEditing = !!Object.keys(this.editingOrNewMovie).length;
  }

  onSubmit(movieForm: NgForm) {
    console.log("X")
    this.isEditing ? this.updateMovie(this.editingOrNewMovie) : this.createMovie(this.editingOrNewMovie);
  }

  createMovie(movieToCreate: MovieRequest) {
    console.log("X")
    this.movieService.createMovie(movieToCreate).subscribe((createdMovie: Movie) => {
      this.dialogRef.close(createdMovie);
    })
  }

  updateMovie(newMovie: Movie) {
    console.log("X")
    this.movieService.updateMovie(newMovie.pieceId, newMovie).subscribe((updatedMovie: Movie) => {
      this.dialogRef.close(updatedMovie);
    });
  }
}
