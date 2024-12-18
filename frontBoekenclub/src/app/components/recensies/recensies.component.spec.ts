import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecensiesComponent } from './recensies.component';

describe('RecensiesComponent', () => {
  let component: RecensiesComponent;
  let fixture: ComponentFixture<RecensiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecensiesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecensiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
