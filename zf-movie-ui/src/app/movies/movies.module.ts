import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MoviesRoutingModule } from './movies-routing.module';
import { MoviesComponent } from './components/movies/movies.component';
import { MovieComponent } from './components/movie/movie.component';
import { SharedModule } from '../shared/shared.module';
import { MovieActorsComponent } from './components/movie-actors/movie-actors.component';
import { PhotoOverlayComponent } from './components/photo-overlay/photo-overlay.component';
import { MovieDialogFormComponent } from './dialogs/movie-dialog-form/movie-dialog-form.component';
import { AddActorToMovieDialogComponent } from './dialogs/add-actor-to-movie-dialog/add-actor-to-movie-dialog.component';
import { SearchActorsComponent } from './actors/search-actors/search-actors.component';
import { InlineActorComponent } from './actors/inline-actor/inline-actor.component';



@NgModule({
  declarations:
    [
      MoviesComponent,
      MovieComponent,
      MovieActorsComponent,
      PhotoOverlayComponent,
      MovieDialogFormComponent,
      AddActorToMovieDialogComponent,
      SearchActorsComponent,
      InlineActorComponent,
    ],
  imports:
    [
      CommonModule,
      MoviesRoutingModule,
      SharedModule
    ],
  entryComponents: [MovieDialogFormComponent]
})
export class MoviesModule { }
