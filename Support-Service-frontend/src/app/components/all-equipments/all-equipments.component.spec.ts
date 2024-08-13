import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllEquipmentsComponent } from './all-equipments.component';

describe('AllEquipmentsComponent', () => {
  let component: AllEquipmentsComponent;
  let fixture: ComponentFixture<AllEquipmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllEquipmentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllEquipmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
