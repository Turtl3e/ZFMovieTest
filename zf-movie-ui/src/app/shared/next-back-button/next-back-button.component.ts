import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-next-back-button',
  templateUrl: './next-back-button.component.html',
  styleUrls: ['./next-back-button.component.scss']
})
export class NextBackButtonComponent implements OnInit {

  @Input() arrowDirection = "right";
  constructor() { }

  ngOnInit(): void {
  }

}
