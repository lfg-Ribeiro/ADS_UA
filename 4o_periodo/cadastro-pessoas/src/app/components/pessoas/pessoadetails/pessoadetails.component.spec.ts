import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoadetailsComponent } from './pessoadetails.component';

describe('PessoadetailsComponent', () => {
  let component: PessoadetailsComponent;
  let fixture: ComponentFixture<PessoadetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PessoadetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PessoadetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
