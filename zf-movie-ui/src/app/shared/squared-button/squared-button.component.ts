import { Component, OnInit, Input, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'app-squared-button',
  templateUrl: './squared-button.component.html',
  styleUrls: ['./squared-button.component.scss']
})
export class SquaredButtonComponent implements OnInit {

  @Input() size = "1.5rem";
  @ViewChild('front', { static: true }) frontSquare;
  @ViewChild('back', { static: true }) backSquare;

  constructor(private renderer: Renderer2) { }

  ngOnInit(): void {
    this.setSize();
  }

  private setSize() {
    this.renderer.setStyle(this.frontSquare.nativeElement, 'width', this.size)
    this.renderer.setStyle(this.frontSquare.nativeElement, 'height', this.size)
    this.renderer.setStyle(this.backSquare.nativeElement, 'width', this.size)
    this.renderer.setStyle(this.backSquare.nativeElement, 'height', this.size)
  }

}
