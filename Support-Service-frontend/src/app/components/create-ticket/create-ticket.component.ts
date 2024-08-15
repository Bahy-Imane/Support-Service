import {Component, EventEmitter, Output} from '@angular/core';
import {SupportTicketDto} from "../../core/dto/support-ticket-dto.model";
import {SupportTicketService} from "../../core/services/support-ticket.service";
import {FormsModule} from "@angular/forms";
import {NgClass, NgIf} from "@angular/common";

@Component({
  selector: 'app-create-ticket',
  standalone: true,
  imports: [
    FormsModule,
    NgIf,
    NgClass
  ],
  templateUrl: './create-ticket.component.html',
  styleUrl: './create-ticket.component.css'
})
export class CreateTicketComponent {

  ticketDto!: SupportTicketDto ;
  error: string | null = null;

  @Output() closeModal = new EventEmitter<void>();

  constructor(private supportTicketService: SupportTicketService) {}

  onSubmit(): void {
    this.supportTicketService.createTicket(this.ticketDto).subscribe({
      next: () => {
        this.closeModal.emit();
      },
      error: (err) => this.error = 'Failed to create ticket'
    });
  }

  close(): void {
    this.closeModal.emit();
  }

}
