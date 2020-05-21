import { Component, OnInit, Input } from '@angular/core';
import { Actor } from 'src/app/models/actor';

@Component({
  selector: 'app-photo-overlay',
  templateUrl: './photo-overlay.component.html',
  styleUrls: ['./photo-overlay.component.scss']
})
export class PhotoOverlayComponent implements OnInit {

  @Input() actor: Actor;
  constructor() { }

  ngOnInit(): void {
  }

}
