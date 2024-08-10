import {Equipment} from "./equipment.model";
import {Failure} from "./failure.model";
import {User} from "./user.model";
import {Technician} from "./technician.model";
import {TicketStatus} from "../dto/ticket-status.model";

export interface SupportTicket {
  tickettId: number;
  subject: string;
  createdAt: string;
  ticketStatus: TicketStatus;
  user?: User;
  equipment?: Equipment;
  technician?: Technician;
  failure?: Failure;
}
