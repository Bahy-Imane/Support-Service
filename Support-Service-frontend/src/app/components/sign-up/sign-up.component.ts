// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormGroup, Validators } from '@angular/forms';
// import {AuthService} from "../../core/services/auth.service";
// import {Router} from "@angular/router";
//
// @Component({
//   selector: 'app-signup-form',
//   templateUrl: './signup-form.component.html',
//   styleUrls: ['./signup-form.component.css'],
//   standalone: true
// })
// export class SignUpComponent implements OnInit {
//   signUpForm: FormGroup;
//   errorMessage: string | null = null;
//
//   constructor(
//     private fb: FormBuilder,
//     private router: Router,
//     private authService: AuthService
//   ) {
//     this.signUpForm = this.fb.group({
//       userName: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]],
//       email: ['', [Validators.required, Validators.email]],
//       password: ['', [Validators.required, Validators.minLength(8), Validators.pattern(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}/)]],
//       role: ['USER', Validators.required]
//     });
//   }
//
//   ngOnInit(): void {}
//
//   get formControls() {
//     return this.signUpForm.controls;
//   }
//
//   onSubmit(): void {
//     if (this.signUpForm.valid) {
//       this.authService.signUp(this.signUpForm.value).subscribe({
//         next: () => {
//           this.router.navigate(['/login']);
//         },
//         error: (err) => {
//           this.errorMessage = 'An error occurred while signing up. Please try again.';
//           console.error(err);
//         }
//       });
//     } else {
//       this.errorMessage = 'Please fill in all required fields correctly.';
//     }
//   }
// }
