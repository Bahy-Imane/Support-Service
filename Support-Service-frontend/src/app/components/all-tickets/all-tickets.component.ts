import { Component, OnInit } from '@angular/core';
import { SupportTicketService } from '../../core/services/support-ticket.service';
import { SupportTicket } from '../../core/model/support-ticket.model';
import {RouterLink, RouterOutlet} from "@angular/router";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-ticket-list',
  templateUrl: './all-tickets.component.html',
  styleUrls: ['./all-tickets.component.css'],
  imports: [
    RouterOutlet,
    NgForOf,
    RouterLink
  ],
  standalone: true
})
export class AllTicketsComponent implements OnInit {
  tickets: SupportTicket[] = [];

  constructor(private supportTicketService: SupportTicketService) {}

  ngOnInit(): void {
    this.getTickets();
  }

  getTickets(): void {
    this.supportTicketService.getAllTickets().subscribe({
      next: (tickets: SupportTicket[]) => {
        this.tickets = tickets;
      },
      error: (err) => {
        console.error('Error loading tickets', err);
      }
    });
  }

  assignTicket(ticketId: number): void {
    const technicianId = prompt("Enter Technician ID:");
    if (technicianId) {
      this.supportTicketService.assignTicketToTechnician(ticketId, +technicianId).subscribe({
        next: (updatedTicket) => {
          alert('Ticket assigned to technician successfully');
          this.getTickets(); // Refresh the list
        },
        error: (err) => {
          console.error('Error assigning ticket', err);
        }
      });
    }
  }
}
