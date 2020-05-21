import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MoviesComponent } from './components/movies/movies.component';
import { MovieActorsComponent } from './components/movie-actors/movie-actors.component';
import { MovieResolverService } from '../resolvers/movie-resolver.service';
import { CanShowDetailMovieGuard } from './guards/can-show-detail-movie.guard';


const routes: Routes = [
  { path: '', component: MoviesComponent },
  { path: ':id', component: MovieActorsComponent, resolve: { movie: MovieResolverService }, canActivate: [CanShowDetailMovieGuard] },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MoviesRoutingModule { }
