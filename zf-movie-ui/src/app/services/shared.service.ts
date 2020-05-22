import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Actor } from '../models/actor';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  actorAdded = new Subject<Actor>();
  checkIfActorExistInMovie = new Subject<Actor>();

  constructor() { }
}
