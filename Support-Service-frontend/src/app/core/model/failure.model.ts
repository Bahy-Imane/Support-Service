import {Equipment} from "./equipment.model";
import {SupportTicket} from "./support-ticket.model";
import {FailureType} from "../dto/failure-type.model";

export interface Failure {
  failureId: number;
  description: string;
  type: FailureType;
  supportTickets?: SupportTicket[];
  equipments?: Equipment[];
}
