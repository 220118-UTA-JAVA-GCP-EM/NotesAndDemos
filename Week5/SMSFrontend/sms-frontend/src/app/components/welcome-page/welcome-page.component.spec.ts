import { ComponentFixture, TestBed } from '@angular/core/testing';
import {By} from '@angular/platform-browser';

import { WelcomePageComponent } from './welcome-page.component';

describe('WelcomePageComponent', () => {
  let component: WelcomePageComponent;
  let fixture: ComponentFixture<WelcomePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WelcomePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WelcomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //At the most basic test we can write, testing to see if a static component rendered on the page
  it('should have an h1 equal to "Welcome to our school', () => {
    //This is where our testing logic will go
    const h1 = fixture.debugElement.query(By.css('h1')).nativeElement;
    expect(h1.innerHTML).toBe('Welcome to our school');
  })

});
