import { Component, OnInit } from '@angular/core';
import { ActorService } from 'src/app/services/actor.service';
import { Actor } from 'src/app/models/actor';

@Component({
  selector: 'app-actors',
  templateUrl: './actors.component.html',
  styleUrls: ['./actors.component.scss']
})
export class ActorsComponent implements OnInit {

  actors: Actor[];
  constructor(private actorService: ActorService) { }

  ngOnInit(): void {
    this.getActors();
  }

  getActors(): void {
    this.actorService.getActors().subscribe((actors: Actor[]) => { this.actors = actors })
  }
}
