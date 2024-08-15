import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { EquipmentService } from '../../core/services/equipment.service';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-add-equipment',
  templateUrl: './add-equipment.component.html',
  styleUrls: ['./add-equipment.component.css'],
  standalone: true,
  imports: [
    NgIf,
    RouterLink,
    ReactiveFormsModule
  ]
})

export class AddEquipmentComponent implements OnInit {
  addEquipmentForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private equipmentService: EquipmentService,
    private router: Router
  ) {
    this.addEquipmentForm = this.fb.group({
      name: ['', Validators.required],
      type: ['', Validators.required],
      status: ['', Validators.required],
      img: ['', [Validators.required, Validators.pattern('https?://.+')]],
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.addEquipmentForm.valid) {
      this.equipmentService.addEquipment(this.addEquipmentForm.value).subscribe(() => {
        this.router.navigate(['/admin-dashboard/equipments']);
      });
    }
  }
}
