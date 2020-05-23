import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Actor } from 'src/app/models/actor';
import { MatDialog } from '@angular/material/dialog';
import { ActorDialogComponent } from '../../dialogs/actor-dialog/actor-dialog.component';

@Component({
  selector: 'app-actor',
  templateUrl: './actor.component.html',
  styleUrls: ['./actor.component.scss']
})
export class ActorComponent implements OnInit {

  @Output() actorDeleted = new EventEmitter<number>();
  @Input() actor: Actor;
  isDetailsComponent: boolean;

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
    this.isDetailsComponent = !!this.actor.movies;
  }

  deleteActor(event: MouseEvent) {
    event.preventDefault();
    event.stopPropagation();
    this.actorDeleted.emit(this.actor.actorId);
  }

  openEditActorDialog() {
    this.dialog.open(ActorDialogComponent, { data: this.actor }).afterClosed().subscribe((updatedActor: Actor) => {
      if (updatedActor) {
        this.actor = updatedActor;
      }
    })
  }

}
