import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Equipment} from "../model/equipment.model";

@Injectable({
  providedIn: 'root'
})
export class EquipmentService {
  private baseUrl = 'http://localhost:8081/api/equipment';

  constructor(private http: HttpClient) {}


  getAllEquipment(): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(`${this.baseUrl}/all`);
  }


  addEquipment(equipment: Equipment): Observable<Equipment> {
    return this.http.post<Equipment>(`${this.baseUrl}/add`, equipment);
  }


  updateEquipment(equipmentId: number, equipment: Equipment): Observable<Equipment> {
    return this.http.put<Equipment>(`${this.baseUrl}/update/${equipmentId}`, equipment);
  }


  deleteEquipment(equipmentId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${equipmentId}`);
  }
}
