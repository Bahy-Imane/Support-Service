import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { UserService } from "../../core/services/user.service";
import {NgIf} from "@angular/common";
import {Router, RouterLink} from "@angular/router";
import {TechnicianService} from "../../core/services/technician.service";

@Component({
  selector: 'app-technician-form',
  templateUrl: './add-technician.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf,
    RouterLink
  ],
  styleUrls: ['./add-technician.component.css']
})
export class AddTechnicianComponent implements OnInit {
  addTechnicianForm: FormGroup;

  constructor(private fb: FormBuilder, private technicianService: TechnicianService,private router :Router) {
    this.addTechnicianForm = this.fb.group({
      userName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      role: ['TECHNICIAN', Validators.required]
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.addTechnicianForm.valid) {
      this.technicianService.addTechnician(this.addTechnicianForm.value).subscribe(() => {
        this.router.navigate(['/admin-dashboard/technicians']);
      });

    }
  }}
