import {Role} from "../enum/role.model";

export interface SignUpDto {
  userName: string;
  email: string;
  password: string;
  role: Role;
}
