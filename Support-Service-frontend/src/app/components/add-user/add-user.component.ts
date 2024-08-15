import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { UserService } from "../../core/services/user.service";
import { User } from "../../core/model/user.model";
import {NgIf} from "@angular/common";
import {Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-user-form',
  templateUrl: './add-user.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf,
    RouterLink
  ],
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  addUserForm: FormGroup;

  constructor(private fb: FormBuilder, private userService: UserService,private router :Router) {
    this.addUserForm = this.fb.group({
      userName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      role: ['USER', Validators.required]
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.addUserForm.valid) {
      this.userService.addUser(this.addUserForm.value).subscribe(() => {
        this.router.navigate(['/admin-dashboard/users']);
      });

    }
  }}
