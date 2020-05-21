import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MovieResolverService } from 'src/app/resolvers/movie-resolver.service';
import { MovieService } from 'src/app/services/movie.service';
import { first, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CanShowDetailMovieGuard implements CanActivate {

  constructor(private movieService: MovieService, private router: Router) { }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.movieService.getMovie(+next.paramMap.get('id')).pipe(
      first(),
      map(el => !!el || this.router.createUrlTree(['/movies']))
    );
  }

}
