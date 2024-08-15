import { Component, OnInit, inject } from '@angular/core';
import { FormControl, FormGroup, Validators, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Router, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from "../../core/services/auth.service";
import { LoginDto } from "../../core/dto/login-dto.model";

@Component({
  selector: 'app-login',
  standalone: true,
  providers: [AuthService],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [CommonModule, ReactiveFormsModule, FormsModule, RouterOutlet],
})
export class LoginComponent implements OnInit {
  success = false;
  failure = false;
  emailErrorMessage: string | null = null;
  loginForm: FormGroup;

  private authService = inject(AuthService);
  private router = inject(Router);

  constructor() {
    this.loginForm = new FormGroup({
      userNameOrEmail: new FormControl(null, [
        Validators.required,
        Validators.pattern('[a-z0-9]+@[a-z]+.[a-z]{2,3}'),
      ]),
      password: new FormControl(null, [Validators.required]),
    });
  }

  ngOnInit(): void {}

  login(submitData: FormGroup) {
    this.success = false;
    this.failure = false;
    this.emailErrorMessage = null;

    const loginDto: LoginDto = {
      userNameOrEmail: submitData.value.userNameOrEmail,
      password: submitData.value.password,
    };

    this.authService.login(loginDto).subscribe({
      next: (response) => {
        if (response.accessToken) {
          this.success = true;
          console.log(response.accessToken);
          localStorage.setItem('accessToken', response.accessToken);
          localStorage.setItem('tokenType', response.tokenType);
          localStorage.setItem('userName', response.userName);
          localStorage.setItem('role', response.role);
          localStorage.setItem('personId', response.personId.toString());

          const userRole = response.role;
          const userId = response.personId;
          const technicianId = response.personId

          if (userRole === 'USER') {
            this.router.navigate(['/user-dashboard', userId]);
          } else if (userRole === 'ADMIN') {
            this.router.navigate(['/admin-dashboard']);
          } else if (userRole === 'TECHNICIAN') {
            this.router.navigate(['/technician-dashboard',technicianId]);
          }
        } else {
          this.failure = true;
          this.emailErrorMessage = 'Login failed. Invalid response from server.';
        }
      },
      error: (error) => {
        console.error('Login error:', error);
        this.failure = true;
        this.emailErrorMessage = 'Login failed. Please check your credentials and try again.';
      }
    });
  }
}
