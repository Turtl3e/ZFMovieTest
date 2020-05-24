import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Actor } from 'src/app/models/actor';
import { ActorService } from 'src/app/services/actor.service';

@Component({
  selector: 'app-actor-details',
  templateUrl: './actor-details.component.html',
  styleUrls: ['./actor-details.component.scss']
})
export class ActorDetailsComponent implements OnInit {

  actor: Actor;

  constructor(private router: Router, private activatedRoute: ActivatedRoute, private actorService: ActorService) { }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(data => {
      !!data.actor ? this.actor = data.actor : this.router.navigate(['./..'], { relativeTo: this.activatedRoute });
    })
  }

  onActorDelete(actorToDeleteId: number): void {
    this.actorService.deleteActor(actorToDeleteId).subscribe(() => this.router.navigate(['./..'], { relativeTo: this.activatedRoute }));
  }

}
