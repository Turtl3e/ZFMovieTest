import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { ActorsRoutingModule } from './actors-routing.module';
import { ActorComponent } from './components/actor/actor.component';
import { ActorsComponent } from './components/actors/actors.component';
import { ActorDetailsComponent } from './components/actor-details/actor-details.component';



@NgModule({
  declarations: [ActorsComponent, ActorComponent, ActorDetailsComponent],
  imports: [
    CommonModule,
    ActorsRoutingModule,
    SharedModule
  ]
})
export class ActorsModule { }
