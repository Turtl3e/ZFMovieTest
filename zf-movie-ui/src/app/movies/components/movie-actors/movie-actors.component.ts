import { Component, OnInit, OnDestroy } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AddActorToMovieDialogComponent } from '../../dialogs/add-actor-to-movie-dialog/add-actor-to-movie-dialog.component';
import { Actor } from 'src/app/models/actor';
import { SharedService } from 'src/app/services/shared.service';
import { Subject } from 'rxjs';
import { MovieService } from 'src/app/services/movie.service';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-movie-actors',
  templateUrl: './movie-actors.component.html',
  styleUrls: ['./movie-actors.component.scss']
})
export class MovieActorsComponent implements OnInit, OnDestroy {

  componentDestroyed: Subject<boolean> = new Subject()
  movie: Movie;

  constructor(private activatedRoute: ActivatedRoute, public dialog: MatDialog, private sharedService: SharedService, private movieService: MovieService) { }

  ngOnInit(): void {
    this.setSubscribtions();
  }

  private setSubscribtions() {
    this.activatedRoute.data.subscribe(data => { this.movie = data.movie; })
    this.sharedService.actorAdded.pipe(takeUntil(this.componentDestroyed)).subscribe((actor: Actor) => this.onActorAdd(actor));
  }

  onActorAdd(actor: Actor) {
    this.movieService.addActorToMovie(this.movie.pieceId, actor).subscribe((addedActor: Actor) => {
      this.movie.actors.push(addedActor);
    })
  }

  openAddActorToMovieDialog() {
    this.dialog.open(AddActorToMovieDialogComponent, { data: this.movie.actors });
  }

  ngOnDestroy(): void {
    this.componentDestroyed.next(true);
    this.componentDestroyed.complete();
  }

  onActorRemoved(actor: Actor) {
    this.movieService.deleteActorFromMovie(this.movie.pieceId, actor.actorId).subscribe(() => this.movie.removeActor(actor));
  }
}
