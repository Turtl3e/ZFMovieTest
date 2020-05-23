import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Actor, ActorRequest } from 'src/app/models/actor';
import { MovieRequest } from 'src/app/models/movie';
import { ActorService } from 'src/app/services/actor.service';
import { ActorFormComponent } from 'src/app/shared/actor-form/actor-form.component';

@Component({
  selector: 'app-actor-dialog',
  templateUrl: './actor-dialog.component.html',
  styleUrls: ['./actor-dialog.component.scss']
})
export class ActorDialogComponent implements OnInit {

  @ViewChild(ActorFormComponent, { static: true }) actorForm: ActorFormComponent;
  editingOrNewActor: Actor;

  isEditing = false;

  constructor(public dialogRef: MatDialogRef<ActorDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: Actor, private actorService: ActorService) { }

  ngOnInit(): void {
    this.data instanceof Actor ? this.editingOrNewActor = this.data : this.editingOrNewActor = new Actor({});
    this.isEditing = !!Object.keys(this.editingOrNewActor).length;
  }

  submitForm(actorToCreate: ActorRequest) {
    this.isEditing ? this.updateActor(this.editingOrNewActor) : this.createActor(this.editingOrNewActor);
  }


  createActor(actorToCreate: ActorRequest) {
    this.actorService.createActor(actorToCreate).subscribe((createdActor: Actor) => {
      this.dialogRef.close(createdActor);
    },
      (e) => {
        console.log("error");
        this.actorForm.actorForm.reset();
      })
  }


  updateActor(newActor: Actor) {
    this.actorService.updateActor(newActor.actorId, newActor).subscribe((updatedActor: Actor) => {
      this.dialogRef.close(updatedActor);
    },
      (e) => {
        console.log("error");
        this.actorForm.actorForm.reset();
      });
  }
}
