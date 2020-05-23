import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { Actor } from 'src/app/models/actor';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-actor-form',
  templateUrl: './actor-form.component.html',
  styleUrls: ['./actor-form.component.scss']
})
export class ActorFormComponent implements OnInit {

  @ViewChild('createActorForm', { static: true }) actorForm: NgForm;
  @Input() actor = new Actor({});

  // actor: Actor = new Actor({});
  constructor() { }

  ngOnInit(): void {
  }

}
