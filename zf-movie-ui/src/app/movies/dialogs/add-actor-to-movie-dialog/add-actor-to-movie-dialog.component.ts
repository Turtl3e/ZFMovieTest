import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-add-actor-to-movie-dialog',
  templateUrl: './add-actor-to-movie-dialog.component.html',
  styleUrls: ['./add-actor-to-movie-dialog.component.scss']
})
export class AddActorToMovieDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<AddActorToMovieDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: Movie) { }

  ngOnInit(): void {
  }

}
