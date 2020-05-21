import { Component, OnInit } from '@angular/core';
import { Actor } from 'src/app/models/actor';

@Component({
  selector: 'app-actor-form',
  templateUrl: './actor-form.component.html',
  styleUrls: ['./actor-form.component.scss']
})
export class ActorFormComponent implements OnInit {

  actor: Actor = new Actor({});
  constructor() { }

  ngOnInit(): void {
  }

}
