import { Component, OnInit, Input, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'app-main-container',
  templateUrl: './main-container.component.html',
  styleUrls: ['./main-container.component.scss']
})
export class MainContainerComponent implements OnInit {


  // @Input() frontColor = "#CBCBCB";
  @Input() backWidth = "95%";
  @Input() backHeight = "90%";
  @Input() backColor = "#252422";
  @Input() left;
  @Input() right;
  @Input() top = "-10px";
  @ViewChild('back', { static: true }) backDiv;


  constructor(private renderer: Renderer2) { }


  ngOnInit(): void {
    this.setStyles();
  }

  private setStyles() {
    this.renderer.setStyle(this.backDiv.nativeElement, 'width', this.backWidth);
    this.renderer.setStyle(this.backDiv.nativeElement, 'height', this.backHeight);
    this.renderer.setStyle(this.backDiv.nativeElement, 'backgroundColor', this.backColor);
    this.renderer.setStyle(this.backDiv.nativeElement, 'left', this.left);
    this.renderer.setStyle(this.backDiv.nativeElement, 'right', this.right);
    this.renderer.setStyle(this.backDiv.nativeElement, 'top', this.top);
  }

}
