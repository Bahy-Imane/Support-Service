// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';
// import {LoginDto} from "../dto/login-dto.model";
// import {JwtAuthResponse} from "../dto/jwt-auth-response.model";
// import {SignUpDto} from "../dto/sign-up-dto.model";
//
//
// @Injectable({
//   providedIn: 'root'
// })
// export class AuthService {
//   private baseUrl = 'http://localhost:4200/api/auth';
//
//   constructor(private http: HttpClient) {}
//
//
//   login(loginDto: LoginDto): Observable<JwtAuthResponse> {
//     return this.http.post<JwtAuthResponse>(`${this.baseUrl}/login`, loginDto);
//   }
//
//
//   signUp(signUpDto: SignUpDto): Observable<string> {
//     return this.http.post<string>(`${this.baseUrl}/signup`, signUpDto);
//   }
// }
//
