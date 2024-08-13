import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Failure} from "../model/failure.model";

@Injectable({
  providedIn: 'root'
})
export class FailureService {
  private baseUrl = 'http://localhost:8080/api/failure';

  constructor(private http: HttpClient) {}


  getAllFailures():Observable<Failure[]>{
   return  this.http.get<Failure[]>(`${this.baseUrl}/all`)
  }

  getFailureByEquipmentId(equipmentId: number): Observable<Failure> {
    return this.http.get<Failure>(`${this.baseUrl}/all/${equipmentId}`);
  }

  addFailure(failure: Failure): Observable<Failure> {
    return this.http.post<Failure>(`${this.baseUrl}/add`, failure);
  }

  updateFailure(failureId: number, failure: Failure): Observable<Failure> {
    return this.http.put<Failure>(`${this.baseUrl}/update/${failureId}`, failure);
  }

  deleteFailure(failureId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${failureId}`);
  }
}
