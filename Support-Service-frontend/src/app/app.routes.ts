import { provideRouter, RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {AdminDashboardComponent} from "./components/admin-Dashbord/admin-Dashboard.component";
import {AllTechniciansComponent} from "./components/all-technicians/all-technicians.component";
import {AllUsersComponent} from "./components/all-users/all-users.component";
import {AllFailuresComponent} from "./components/all-failures/all-failures.component";
import {AllEquipmentsComponent} from "./components/all-equipments/all-equipments.component";
import {AuthGuard} from "./core/services/auth-guard.service";
import {RoleGuard} from "./core/services/role-guard.service";
import {Role} from "./core/enum/role.model";
import {AllTicketsComponent} from "./components/all-tickets/all-tickets.component";
import {UserDashboardComponent} from "./components/user-dashboard/user-dashboard.component";
import {TechnicianDashboardComponent} from "./components/technician-dashboard/technician-dashboard.component";
import {AddUserComponent} from "./components/add-user/add-user.component";
import {AddTechnicianComponent} from "./components/add-technician/add-technician.component";
import {AddEquipmentComponent} from "./components/add-equipment/add-equipment.component";
import {AddFailureComponent} from "./components/add-failure/add-failure.component";



export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'admin-dashboard',
    component: AdminDashboardComponent,
    canActivate: [AuthGuard, RoleGuard],
    data: {expectedRole: Role.ADMIN},
    children: [
      {
        path: 'users',
        component: AllUsersComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: {expectedRole: Role.ADMIN}
      },
      {
        path: 'technicians',
        component: AllTechniciansComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: {expectedRole: Role.ADMIN}
      },
      {
        path: 'equipments',
        component: AllEquipmentsComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: {expectedRole: Role.ADMIN}
      },
      {
        path: 'failures',
        component: AllFailuresComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: {expectedRole: Role.ADMIN}
      },
      {
        path: 'tickets',
        component: AllTicketsComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: {expectedRole: Role.ADMIN}
      },
      {
        path: 'users/add-user',
        component: AddUserComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: {expectedRole: Role.ADMIN}
      },
      {
        path: 'technicians/add-technician',
        component: AddTechnicianComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: {expectedRole: Role.ADMIN}
      },
      {
        path: 'equipments/add-equipment',
        component: AddEquipmentComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: {expectedRole: Role.ADMIN}
      },
      {
        path: 'failures/add-failure',
        component: AddFailureComponent,
        canActivate: [AuthGuard, RoleGuard],
        data: {expectedRole: Role.ADMIN}
      }

      ]},

  { path: 'user-dashboard/:userId',
    component: UserDashboardComponent,
    canActivate: [AuthGuard, RoleGuard],
    data: { expectedRole: Role.USER }
  },

  { path: 'technician-dashboard/:technicianId',
    component: TechnicianDashboardComponent,
    canActivate: [AuthGuard, RoleGuard],
    data: { expectedRole: Role.TECHNICIAN }
  }
]



