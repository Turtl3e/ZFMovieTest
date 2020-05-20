import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhotoOverlayComponent } from './photo-overlay.component';

describe('PhotoOverlayComponent', () => {
  let component: PhotoOverlayComponent;
  let fixture: ComponentFixture<PhotoOverlayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhotoOverlayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhotoOverlayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
