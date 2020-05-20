import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MoviesRoutingModule } from './movies-routing.module';
import { MoviesComponent } from './components/movies/movies.component';
import { MovieComponent } from './components/movie/movie.component';
import { SharedModule } from '../shared/shared.module';
import { MovieActorsComponent } from './components/movie-actors/movie-actors.component';
import { PhotoOverlayComponent } from './components/photo-overlay/photo-overlay.component';


@NgModule({
  declarations: [MoviesComponent, MovieComponent, MovieActorsComponent, PhotoOverlayComponent],
  imports: [
    CommonModule,
    MoviesRoutingModule,
    SharedModule
  ]
})
export class MoviesModule { }
