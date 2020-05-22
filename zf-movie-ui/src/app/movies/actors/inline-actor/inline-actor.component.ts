import { Component, OnInit, Input } from '@angular/core';
import { Actor } from 'src/app/models/actor';
import { SharedService } from 'src/app/services/shared.service';

@Component({
  selector: 'app-inline-actor',
  templateUrl: './inline-actor.component.html',
  styleUrls: ['./inline-actor.component.scss']
})
export class InlineActorComponent implements OnInit {

  @Input() actor: Actor;
  @Input() disabled: boolean = false;
  constructor(private sharedService: SharedService) { }

  ngOnInit(): void {
  }

  addActorToMovie() {
    this.sharedService.actorAdded.next(this.actor);
  }

}
