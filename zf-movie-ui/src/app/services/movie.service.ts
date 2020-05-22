import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { Movie, MovieResponse, MovieRequest } from '../models/movie';
import { map, catchError } from 'rxjs/operators';
import { Actor, ActorRequest, ActorResponse } from '../models/actor';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  MOVIE_PATH: string = "http://127.0.0.1:8080/movies"
  constructor(private http: HttpClient) { }

  getMovies(): Observable<Movie[]> {
    return this.http.get<MovieResponse[]>(this.MOVIE_PATH).pipe(
      map((moviesData) => moviesData.map(movie => new Movie(movie)))
    )
  }

  getMovie(movieId: number): Observable<Movie> {
    return this.http.get<MovieResponse>(`${this.MOVIE_PATH}/${movieId}`).pipe(
      map(movie => {
        movie.actors = movie.actors.map(actor => new Actor(actor));
        return new Movie(movie)
      }),
      catchError(e => of(null))
    )
  }

  deleteMovie(movieToDeleteId: number): Observable<any> {
    return this.http.delete<any>(`${this.MOVIE_PATH}/${movieToDeleteId}`);
  }

  createMovie(movie: MovieRequest): Observable<Movie> {
    return this.http.post<MovieResponse>(this.MOVIE_PATH, movie).pipe(
      map(createdMovie => new Movie(createdMovie))
    )
  }

  updateMovie(oldMovieId: number, newMovie: MovieRequest): Observable<Movie> {
    return this.http.put<MovieResponse>(`${this.MOVIE_PATH}/${oldMovieId}`, newMovie).pipe(
      map(createdMovie => new Movie(createdMovie))
    )
  }

  addActorToMovie(movieId: number, actor: ActorRequest): Observable<Actor> {
    return this.http.post(`${this.MOVIE_PATH}/${movieId}/actors`, actor).pipe(
      map((addedActor: ActorResponse) => new Actor(addedActor))
    )
  }

  deleteActorFromMovie(movieId: number, actorId: number): Observable<any> {
    return this.http.delete(`${this.MOVIE_PATH}/${movieId}/actors/${actorId}`)
  }
}
