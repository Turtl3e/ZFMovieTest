import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AddActorToMovieDialogComponent } from '../../dialogs/add-actor-to-movie-dialog/add-actor-to-movie-dialog.component';

@Component({
  selector: 'app-movie-actors',
  templateUrl: './movie-actors.component.html',
  styleUrls: ['./movie-actors.component.scss']
})
export class MovieActorsComponent implements OnInit {

  movie: Movie;
  constructor(private activatedRoute: ActivatedRoute, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(data => {
      this.movie = data.movie;
    })
  }

  openAddActorToMovieDialog() {
    this.dialog.open(AddActorToMovieDialogComponent)
  }
}
