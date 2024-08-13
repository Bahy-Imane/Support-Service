import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Technician} from "../model/technician.model";

@Injectable({
  providedIn: 'root'
})
export class TechnicianService {
  private baseUrl = 'http://localhost:8080/api/technician';

  headers= new  HttpHeaders().set('Authorization','Bearer '+localStorage.getItem('accessToken') || '');


  constructor(private http: HttpClient) {}

  getTechnicians(): Observable<Technician[]> {
    return this.http.get<Technician[]>(`${this.baseUrl}/all`,{headers:this.headers});
  }

  getTechnicianById(technicianId: number): Observable<Technician> {
    return this.http.get<Technician>(`${this.baseUrl}/tech/${technicianId}`,{headers:this.headers});
  }

  addTechnician(technicianDto: any): Observable<Technician> {
    return this.http.post<Technician>(`${this.baseUrl}/add-tech`, technicianDto,{headers:this.headers});
  }

  updateTechnician(technicianId: number, technician: Technician): Observable<Technician> {
    return this.http.put<Technician>(`${this.baseUrl}/update-tech/${technicianId}`, technician,{headers:this.headers});
  }

  deleteTechnician(technicianId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete-tech/${technicianId}`,{headers:this.headers});
  }
}
