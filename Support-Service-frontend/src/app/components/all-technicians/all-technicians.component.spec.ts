import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllTechniciansComponent } from './all-technicians.component';

describe('AllTechniciansComponent', () => {
  let component: AllTechniciansComponent;
  let fixture: ComponentFixture<AllTechniciansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllTechniciansComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllTechniciansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
