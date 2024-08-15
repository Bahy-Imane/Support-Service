import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import { SupportTicket } from '../../core/model/support-ticket.model';
import { SupportTicketService } from '../../core/services/support-ticket.service';
import { DatePipe, NgForOf, NgIf } from '@angular/common';
import {MatDialog} from "@angular/material/dialog";
import {CreateTicketComponent} from "../create-ticket/create-ticket.component";

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  standalone: true,
  imports: [
    NgForOf,
    DatePipe,
    NgIf,
    RouterLink
  ],
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  tickets: SupportTicket[] = [];
  userId!: number;
  error: string | null = null;

  constructor(
    private route: ActivatedRoute,
    private supportTicketService: SupportTicketService,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('userId');
      if (id && !isNaN(+id)) {
        this.userId = +id;
        this.loadTickets();
      } else {
        this.error = 'Invalid User ID';
      }
    });
  }


  loadTickets(): void {
    this.supportTicketService.getTicketsByUser(this.userId).subscribe({
      next: (tickets:SupportTicket[]) => this.tickets = tickets,
      error: (err) => this.error = 'Failed to load tickets'
    });
  }

  openCreateTicketDialog(): void {
    const dialogRef = this.dialog.open(CreateTicketComponent, {
      width: '300px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
