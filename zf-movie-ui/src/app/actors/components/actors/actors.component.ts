import { Component, OnInit } from '@angular/core';
import { ActorService } from 'src/app/services/actor.service';
import { Actor } from 'src/app/models/actor';
import { MatDialog } from '@angular/material/dialog';
import { ActorDialogComponent } from '../../dialogs/actor-dialog/actor-dialog.component';

@Component({
  selector: 'app-actors',
  templateUrl: './actors.component.html',
  styleUrls: ['./actors.component.scss']
})
export class ActorsComponent implements OnInit {

  actors: Actor[];
  constructor(private actorService: ActorService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getActors();
  }

  getActors(): void {
    this.actorService.getActors().subscribe((actors: Actor[]) => { this.actors = actors })
  }

  onActorDelete(actorToDeleteId: number): void {
    this.actorService.deleteActor(actorToDeleteId).subscribe(() => this.removeActorFromList(actorToDeleteId));
  }

  openCreateActorDialog() {
    this.dialog.open(ActorDialogComponent).afterClosed().subscribe((createdActor: Actor) => {
      if (createdActor) this.actors.push(createdActor);
    })
  }

  removeActorFromList(index: number) {
    this.actors = this.actors.filter(actor => actor.actorId != index);
  }
}
