import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MoviesComponent } from './components/movies/movies.component';
import { MovieActorsComponent } from './components/movie-actors/movie-actors.component';


const routes: Routes = [
  { path: '', component: MoviesComponent },
  { path: ':id', component: MovieActorsComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MoviesRoutingModule { }
