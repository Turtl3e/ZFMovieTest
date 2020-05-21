import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { NextBackButtonComponent } from './next-back-button/next-back-button.component';
import { SquaredButtonComponent } from './squared-button/squared-button.component';
import { SquaredParagraphComponent } from './squared-paragraph/squared-paragraph.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { FormsModule } from '@angular/forms';
import { ActorFormComponent } from './actor-form/actor-form.component';
import { MatTabsModule } from '@angular/material/tabs';

@NgModule({
  declarations:
    [
      SquaredButtonComponent,
      SquaredParagraphComponent,
      NextBackButtonComponent,
      ActorFormComponent
    ],
  imports:
    [
      CommonModule,
      MatIconModule,
      MatDialogModule,
      MatFormFieldModule,
      MatInputModule,
      MatDatepickerModule,
      FormsModule,
      MatTabsModule
    ],
  exports:
    [
      SquaredButtonComponent,
      SquaredParagraphComponent,
      NextBackButtonComponent,
      MatIconModule,
      MatDialogModule,
      MatFormFieldModule,
      MatInputModule,
      MatDatepickerModule,
      FormsModule,
      ActorFormComponent,
      MatTabsModule
    ]
})
export class SharedModule { }
