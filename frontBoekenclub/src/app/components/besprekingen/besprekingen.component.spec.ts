import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BesprekingenComponent } from './besprekingen.component';

describe('BesprekingenComponent', () => {
  let component: BesprekingenComponent;
  let fixture: ComponentFixture<BesprekingenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BesprekingenComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BesprekingenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
