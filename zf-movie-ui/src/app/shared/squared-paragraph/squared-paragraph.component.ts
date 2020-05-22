import { Component, OnInit, ViewChild, ElementRef, Renderer2, Input } from '@angular/core';
import { SquaredButtonComponent } from '../squared-button/squared-button.component';

@Component({
  selector: 'app-squared-paragraph',
  templateUrl: './squared-paragraph.component.html',
  styleUrls: ['./squared-paragraph.component.scss']
})
export class SquaredParagraphComponent implements OnInit {

  @Input() squaredButtonClassName: string = "";

  constructor() { }

  ngOnInit(): void {
  }

}
