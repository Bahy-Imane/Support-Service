import {Role} from "../enum/role.model";

export interface Person {
  personId: number;
  userName: string;
  email: string;
  password: string;
  role: Role;
  authorities?: string[];
}
