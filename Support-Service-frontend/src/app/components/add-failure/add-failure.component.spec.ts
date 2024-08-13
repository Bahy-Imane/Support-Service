import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFailureComponent } from './add-failure.component';

describe('AddFailureComponent', () => {
  let component: AddFailureComponent;
  let fixture: ComponentFixture<AddFailureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddFailureComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddFailureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
