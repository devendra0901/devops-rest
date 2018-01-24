import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfpageComponent } from './confpage.component';

describe('ConfpageComponent', () => {
  let component: ConfpageComponent;
  let fixture: ComponentFixture<ConfpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
