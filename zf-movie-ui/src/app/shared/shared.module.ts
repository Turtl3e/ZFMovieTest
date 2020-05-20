import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { NextBackButtonComponent } from './next-back-button/next-back-button.component';
import { SquaredButtonComponent } from './squared-button/squared-button.component';
import { SquaredParagraphComponent } from './squared-paragraph/squared-paragraph.component';


@NgModule({
  declarations:
    [
      SquaredButtonComponent,
      SquaredParagraphComponent,
      NextBackButtonComponent
    ],
  imports:
    [
      CommonModule,
      MatIconModule
    ],
  exports:
    [
      SquaredButtonComponent,
      SquaredParagraphComponent,
      NextBackButtonComponent,
      MatIconModule
    ]
})
export class SharedModule { }
