import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SupportTicket } from '../../core/model/support-ticket.model';
import { SupportTicketService } from '../../core/services/support-ticket.service';
import {DatePipe, NgForOf, NgIf} from '@angular/common';
import {TicketStatus} from "../../core/dto/ticket-status.model";

@Component({
  selector: 'app-technician-dashboard',
  templateUrl: './technician-dashboard.component.html',
  standalone: true,
  imports: [
    DatePipe,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./technician-dashboard.component.css']
})
export class TechnicianDashboardComponent implements OnInit {
  tickets: SupportTicket []=[];
  technicianId!: number;
  error: string | null = null;
  ticketStatuses = TicketStatus;

  constructor(
    private route: ActivatedRoute,
    private supportTicketService: SupportTicketService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('technicianId');
      if (id && !isNaN(+id)) {
        this.technicianId = +id;
        this.loadTicket();
      } else {
        this.error = 'Invalid Technician ID';
      }
    });
  }

  loadTicket(): void {
    this.supportTicketService.getTechnicianTicket(this.technicianId).subscribe({
      next: (tickets: SupportTicket[]) => this.tickets = tickets,
      error: (err) => this.error = 'Failed to load ticket'
    });
  }

  getTicketStatusLabel(status: TicketStatus): string {
    return TicketStatus[status];
  }
}
