import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {LoginDto} from "../dto/login-dto.model";
import {JwtAuthResponse} from "../dto/jwt-auth-response.model";
import {SignUpDto} from "../dto/sign-up-dto.model";
import {PersonDto} from "../dto/person-dto.model";
import {Role} from "../enum/role.model";


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) {}


  login(loginDto: LoginDto): Observable<JwtAuthResponse> {
    return this.http.post<JwtAuthResponse>(`${this.baseUrl}/login`, loginDto);
  }


  signUp(personUpDto: PersonDto): Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/signup`, personUpDto);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('accessToken');
  }

  getUserRole(): Role | null {
    const token = localStorage.getItem('accessToken');
    if (token) {
      const payload = JSON.parse(atob(token.split('.')[1]));
      console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
      return payload.personRole as Role;
    }
    return null;
  }

  storeToken(token: string): void {
    localStorage.setItem('accessToken', token);
  }

  logout(): void {
    localStorage.removeItem('accessToken');
  }
}

