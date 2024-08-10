import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Technician} from "../model/technician.model";

@Injectable({
  providedIn: 'root'
})
export class TechnicianService {
  private baseUrl = 'http://localhost:8080/api/technician';

  constructor(private http: HttpClient) {}

  getAllTechnicians(): Observable<Technician[]> {
    return this.http.get<Technician[]>(`${this.baseUrl}/all`);
  }

  getTechnicianById(technicianId: number): Observable<Technician> {
    return this.http.get<Technician>(`${this.baseUrl}/tech/${technicianId}`);
  }

  addTechnician(technicianDto: any): Observable<Technician> {
    return this.http.post<Technician>(`${this.baseUrl}/add-tech`, technicianDto);
  }

  updateTechnician(technicianId: number, technician: Technician): Observable<Technician> {
    return this.http.put<Technician>(`${this.baseUrl}/update-tech/${technicianId}`, technician);
  }

  deleteTechnician(technicianId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete-tech/${technicianId}`);
  }
}
