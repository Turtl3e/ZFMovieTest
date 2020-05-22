import { Injectable } from '@angular/core';
import { Actor } from 'src/app/models/actor';
import { Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { ActorService } from 'src/app/services/actor.service';

@Injectable({
  providedIn: 'root'
})
export class ActorResolverService implements Resolve<Actor> {

  constructor(private actorService: ActorService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Actor | Observable<Actor> | Promise<Actor> {
    return this.actorService.getActor(+route.paramMap.get('id'));
  }
}
