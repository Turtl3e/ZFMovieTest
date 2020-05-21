import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Actor, ActorResponse } from '../models/actor';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ActorService {

  ACTORS_URL: string = "http://127.0.0.1:8080/actors"

  constructor(private http: HttpClient) { }

  searchActors(term: string): Observable<Actor[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<ActorResponse[]>(`${this.ACTORS_URL}/?name=${term}`).pipe(
      map(actorsData => actorsData.map(actor => new Actor(actor)))
      // tap(x => x.length ?
      //   this.log(`found heroes matching "${term}"`) :
      //   this.log(`no heroes matching "${term}"`)),
      // catchError(this.handleError<Hero[]>('searchHeroes', []))
    );
  }
}
