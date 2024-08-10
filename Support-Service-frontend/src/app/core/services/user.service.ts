import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from "../model/user.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8080/api/user';

  constructor(private http: HttpClient) {}

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}`);
  }

  getUserById(userId: number): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/user/${userId}`);
  }

  addUser(user: any): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}/add-user`, user);
  }

  deleteUserById(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete-user/${userId}`);
  }

  updateUser(userId: number, user: User): Observable<User> {
    return this.http.put<User>(`${this.baseUrl}/update-user/${userId}`, user);
  }
}

