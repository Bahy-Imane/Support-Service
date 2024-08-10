import {Failure} from "./failure.model";
import {SupportTicket} from "./support-ticket.model";

export interface Equipment {
  equipmentId: number;
  name: string;
  type: string;
  status: string;
  img: string;
  supportTicket?: SupportTicket[];
  failures?: Failure[];
}
