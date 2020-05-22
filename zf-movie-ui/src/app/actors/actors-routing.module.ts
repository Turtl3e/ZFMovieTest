import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActorsComponent } from './components/actors/actors.component';
import { ActorDetailsComponent } from './components/actor-details/actor-details.component';
import { ActorResolverService } from './resolvers/actor-resolver.service';


const routes: Routes = [
  { path: '', component: ActorsComponent },
  { path: ':id', component: ActorDetailsComponent, resolve: { actor: ActorResolverService } },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ActorsRoutingModule { }
