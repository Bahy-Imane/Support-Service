import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {SupportTicket} from "../model/support-ticket.model";

@Injectable({
  providedIn: 'root'
})
export class SupportTicketService {
  private baseUrl = 'http://localhost:8081/api/supportTicket';

  constructor(private http: HttpClient) {}

  createTicket(supportTicketDto: any): Observable<SupportTicket> {
    return this.http.post<SupportTicket>(`${this.baseUrl}/Create`, supportTicketDto);
  }

  assignTicketToTechnician(ticketId: number, technicianId: number): Observable<SupportTicket> {
    return this.http.put<SupportTicket>(`${this.baseUrl}/${ticketId}/assign/${technicianId}`, {});
  }

  updateTicketStatus(ticketId: number, status: any): Observable<SupportTicket> {
    return this.http.put<SupportTicket>(`${this.baseUrl}/status-update/${ticketId}`, status);
  }

  getAllTickets(): Observable<SupportTicket[]> {
    return this.http.get<SupportTicket[]>(`${this.baseUrl}/all`);
  }

  getTicketById(ticketId: number): Observable<SupportTicket> {
    return this.http.get<SupportTicket>(`${this.baseUrl}/${ticketId}`);
  }
}
