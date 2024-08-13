import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, RouterModule, Routes } from '@angular/router';
import { importProvidersFrom } from '@angular/core';
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {AdminDashboardComponent} from "./components/admin-Dashbord/admin-Dashboard.component";
import {AllTechniciansComponent} from "./components/all-technicians/all-technicians.component";
import {AllUsersComponent} from "./components/all-users/all-users.component";
import {AllFailuresComponent} from "./components/all-failures/all-failures.component";
import {AllEquipmentsComponent} from "./components/all-equipments/all-equipments.component";



export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  // { path: 'signup', component: SignUpComponent },
  {path: 'admin-dashboard',component: AdminDashboardComponent},
  {path: 'equipments', component: AllEquipmentsComponent},
  {path: 'technicians', component: AllTechniciansComponent},
  {path: 'users', component: AllUsersComponent},
  {path: 'failures', component: AllFailuresComponent},


  // {path: 'allEquipments', component: AdminEquipmentsComponent}
];



// import { Routes } from '@angular/router';
// import {GlucoseListComponent} from "./glucose-list/glucose-list.component";
// import {GlucoseFormComponent} from "./glucose-form/glucose-form.component";
// import {GlucoseEditComponent} from "./glucose-edit/glucose-edit.component";
//
// export const routes: Routes = [
//
//   { path: 'glucose', component: GlucoseListComponent },
//   { path: 'addGlucose', component: GlucoseFormComponent },
//   { path: 'update-glucose/:id', component: GlucoseEditComponent },
//   { path:'deleteGlucose' ,component: GlucoseListComponent},
//
//   { path: '', component: GlucoseFormComponent , pathMatch: 'full' }
// ]

