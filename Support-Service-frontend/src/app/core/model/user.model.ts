import { Person } from './person.model';
import { SupportTicket } from './support-ticket.model';

export interface User extends Person {
  tickets?: SupportTicket[];
}
