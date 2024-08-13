import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Equipment} from "../model/equipment.model";

@Injectable({
  providedIn: 'root'
})
export class EquipmentService {
  private baseUrl = 'http://localhost:8080/api/equipment';


  headers= new  HttpHeaders().set('Authorization','Bearer '+localStorage.getItem('accessToken') || '');

  constructor(private http: HttpClient) {}


  getAllEquipment(): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(`${this.baseUrl}/all`,{headers:this.headers});
  }


  addEquipment(equipment: Equipment): Observable<Equipment> {
    return this.http.post<Equipment>(`${this.baseUrl}/add`, equipment,{headers:this.headers});
  }


  updateEquipment(equipmentId: number, equipment: Equipment): Observable<Equipment> {
    return this.http.put<Equipment>(`${this.baseUrl}/update/${equipmentId}`, equipment,{headers:this.headers});
  }


  deleteEquipment(equipmentId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${equipmentId}`,{headers:this.headers});
  }
}
