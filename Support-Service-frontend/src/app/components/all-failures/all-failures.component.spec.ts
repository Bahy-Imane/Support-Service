import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllFailuresComponent } from './all-failures.component';

describe('AllFailuresComponent', () => {
  let component: AllFailuresComponent;
  let fixture: ComponentFixture<AllFailuresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllFailuresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllFailuresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
