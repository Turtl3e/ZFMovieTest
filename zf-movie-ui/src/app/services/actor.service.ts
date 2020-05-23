import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Actor, ActorResponse, ActorRequest } from '../models/actor';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ActorService {

  ACTORS_URL: string = "http://127.0.0.1:8080/actors"

  constructor(private http: HttpClient) { }


  getActors(): Observable<Actor[]> {
    return this.http.get<ActorResponse[]>(this.ACTORS_URL).pipe(
      map((actorsData) => actorsData.map(actor => new Actor(actor)))
    )
  }

  getActor(actorId: number): Actor | Observable<Actor> | Promise<Actor> {
    return this.http.get<ActorResponse>(`${this.ACTORS_URL}/${actorId}`).pipe(
      map(actor => new Actor(actor)),
      catchError(e => of(null))
    )
  }

  deleteActor(actorToDeleteId: number): Observable<any> {
    return this.http.delete<any>(`${this.ACTORS_URL}/${actorToDeleteId}`);
  }

  createActor(actor: ActorRequest): Observable<Actor> {
    return this.http.post<ActorResponse>(this.ACTORS_URL, actor).pipe(
      map(createdActor => new Actor(createdActor))
    )
  }

  updateActor(oldActorId: number, newActor: ActorRequest): Observable<Actor> {
    return this.http.put<ActorResponse>(`${this.ACTORS_URL}/${oldActorId}`, newActor).pipe(
      map(createdActor => new Actor(createdActor))
    )
  }

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
