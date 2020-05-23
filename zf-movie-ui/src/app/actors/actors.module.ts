import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { ActorsRoutingModule } from './actors-routing.module';
import { ActorComponent } from './components/actor/actor.component';
import { ActorsComponent } from './components/actors/actors.component';
import { ActorDetailsComponent } from './components/actor-details/actor-details.component';
import { ActorDialogComponent } from './dialogs/actor-dialog/actor-dialog.component';



@NgModule({
  declarations: [ActorsComponent, ActorComponent, ActorDetailsComponent, ActorDialogComponent],
  imports: [
    CommonModule,
    ActorsRoutingModule,
    SharedModule
  ]
})
export class ActorsModule { }
