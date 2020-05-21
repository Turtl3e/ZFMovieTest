import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { HttpClientModule } from '@angular/common/http';
import { MatNativeDateModule } from '@angular/material/core';
import { MAT_DIALOG_DEFAULT_OPTIONS } from '@angular/material/dialog';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    WelcomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatNativeDateModule
  ],
  providers: [
    { provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: { panelClass: 'myapp-no-padding-dialog', hasBackdrop: true } }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
