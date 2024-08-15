import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from "../model/user.model";
import {PersonDto} from "../dto/person-dto.model";
import {SignUpDto} from "../dto/sign-up-dto.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8080/api/user';

  constructor(private http: HttpClient) {}

   headers= new  HttpHeaders().set('Authorization','Bearer '+localStorage.getItem('accessToken') || '');

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}`,{headers:this.headers});
  }

  getUserById(userId: number): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/user/${userId}`);
  }

  addUser(signUpDto: SignUpDto): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}/add-user`, signUpDto,{headers:this.headers});
  }

  deleteUserById(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete-user/${userId}`);
  }

  updateUser(userId: number, user: User): Observable<User> {
    return this.http.put<User>(`${this.baseUrl}/update-user/${userId}`, user);
  }
}

