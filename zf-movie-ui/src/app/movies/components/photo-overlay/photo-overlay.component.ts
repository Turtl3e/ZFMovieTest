import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Actor } from 'src/app/models/actor';

@Component({
  selector: 'app-photo-overlay',
  templateUrl: './photo-overlay.component.html',
  styleUrls: ['./photo-overlay.component.scss']
})
export class PhotoOverlayComponent implements OnInit {

  @Input() actor: Actor;
  @Output() removed = new EventEmitter<Actor>();

  constructor() { }

  ngOnInit(): void {
  }


  removeActorFromMovie() {
    this.removed.emit(this.actor);
  }

}
