import { Injectable } from '@angular/core';
import { Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { Movie } from '../models/movie';
import { Observable } from 'rxjs';
import { MovieService } from '../services/movie.service';
import { catchError } from 'rxjs/operators';
import { tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class MovieResolverService implements Resolve<Movie> {

  constructor(private movieService: MovieService) { }
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Movie | Observable<Movie> | Promise<Movie> {
    return this.movieService.getMovie(+route.paramMap.get('id'));
  }
}
