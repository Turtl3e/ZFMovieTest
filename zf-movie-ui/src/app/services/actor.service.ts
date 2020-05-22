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
    let stringParam = term.split(" ");
    const res = stringParam.reduce((a, b) => (a[b] = '', a), {});
    return this.http.get<ActorResponse[]>(`${this.ACTORS_URL}`,
      {
        params: this.prepareParamsObject(stringParam)
      }).pipe(map(actorsData => actorsData.map(actor => new Actor(actor))));
  }

  private prepareParamsObject(words: string[]) {
    if (words.length == 1) {
      return { stringParam: words[0] }
    }
    return { firstName: words[0], secondName: words[1] }
  }
}
