import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SupportTicket } from '../model/support-ticket.model';
import {SupportTicketDto} from "../dto/support-ticket-dto.model";

@Injectable({
  providedIn: 'root'
})
export class SupportTicketService {
  private baseUrl = 'http://localhost:8080/api/supportTicket';

  private headers = new HttpHeaders().set('Authorization', 'Bearer ' + (localStorage.getItem('accessToken') || ''));

  constructor(private http: HttpClient) {}

  createTicket(supportTicketDto: SupportTicketDto): Observable<SupportTicket> {
    return this.http.post<SupportTicket>(`${this.baseUrl}/Create`, supportTicketDto, { headers: this.headers });
  }

  assignTicketToTechnician(ticketId: number, technicianId: number): Observable<SupportTicket> {
    return this.http.put<SupportTicket>(`${this.baseUrl}/${ticketId}/assign/${technicianId}`, {}, { headers: this.headers });
  }

  updateTicketStatus(ticketId: number, status: any): Observable<SupportTicket> {
    return this.http.put<SupportTicket>(`${this.baseUrl}/status-update/${ticketId}`, status, { headers: this.headers });
  }

  getAllTickets(): Observable<SupportTicket[]> {
    return this.http.get<SupportTicket[]>(`${this.baseUrl}/all`, { headers: this.headers });
  }

  getTicketById(ticketId: number): Observable<SupportTicket> {
    return this.http.get<SupportTicket>(`${this.baseUrl}/${ticketId}`, { headers: this.headers });
  }

  getTechnicianTicket(technicianId: number): Observable<SupportTicket[]> {
    return this.http.get<SupportTicket[]>(`${this.baseUrl}/tech/${technicianId}`, { headers: this.headers });
  }

  getTicketsByUser(userId: number): Observable<SupportTicket[]> {
    return this.http.get<SupportTicket[]>(`${this.baseUrl}/user/${userId}`, { headers: this.headers });
  }
}
