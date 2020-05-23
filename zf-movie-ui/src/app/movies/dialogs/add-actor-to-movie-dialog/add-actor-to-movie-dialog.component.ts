import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Actor } from 'src/app/models/actor';
import { ActorFormComponent } from 'src/app/shared/actor-form/actor-form.component';
import { SharedService } from 'src/app/services/shared.service';

@Component({
  selector: 'app-add-actor-to-movie-dialog',
  templateUrl: './add-actor-to-movie-dialog.component.html',
  styleUrls: ['./add-actor-to-movie-dialog.component.scss']
})
export class AddActorToMovieDialogComponent implements OnInit {

  @ViewChild(ActorFormComponent, { static: true }) actorForm: ActorFormComponent;
  selectedMovieActors: Actor[];
  selectedTabIndex: number = 0;

  constructor(public dialogRef: MatDialogRef<AddActorToMovieDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: Actor[], private sharedService: SharedService) { }

  ngOnInit(): void {
    this.selectedMovieActors = this.data;
  }

  addActorToMovie() {
    this.sharedService.actorAdded.next(this.actorForm.actorForm.value);
    this.actorForm.actorForm.reset();
  }

  setSelectedTabIndex(index: number) {
    this.selectedTabIndex = index;
  }
}
