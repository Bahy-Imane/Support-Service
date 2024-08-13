import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Failure} from "../model/failure.model";

@Injectable({
  providedIn: 'root'
})
export class FailureService {
  private baseUrl = 'http://localhost:8080/api/failure';


  headers= new  HttpHeaders().set('Authorization','Bearer '+localStorage.getItem('accessToken') || '');

  constructor(private http: HttpClient) {}


  getAllFailures():Observable<Failure[]>{
   return  this.http.get<Failure[]>(`${this.baseUrl}/all`,{headers:this.headers})
  }

  getFailureByEquipmentId(equipmentId: number): Observable<Failure> {
    return this.http.get<Failure>(`${this.baseUrl}/all/${equipmentId}`,{headers:this.headers});
  }

  addFailure(failure: Failure): Observable<Failure> {
    return this.http.post<Failure>(`${this.baseUrl}/add`, failure,{headers:this.headers});
  }

  updateFailure(failureId: number, failure: Failure): Observable<Failure> {
    return this.http.put<Failure>(`${this.baseUrl}/update/${failureId}`, failure,{headers:this.headers});
  }

  deleteFailure(failureId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${failureId}`,{headers:this.headers});
  }
}
