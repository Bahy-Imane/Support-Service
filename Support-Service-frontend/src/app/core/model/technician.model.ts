import { Person } from './person.model';
import { SupportTicket } from './support-ticket.model';

export interface Technician extends Person {
  tickets?: SupportTicket[];
}
