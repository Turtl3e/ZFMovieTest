import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SquaredParagraphComponent } from './squared-paragraph.component';

describe('SquaredParagraphComponent', () => {
  let component: SquaredParagraphComponent;
  let fixture: ComponentFixture<SquaredParagraphComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SquaredParagraphComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SquaredParagraphComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
