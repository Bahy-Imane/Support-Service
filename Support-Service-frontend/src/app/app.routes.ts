import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, RouterModule, Routes } from '@angular/router';
import { importProvidersFrom } from '@angular/core';
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {SignUpComponent} from "./components/sign-up/sign-up.component";



export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignUpComponent }
];

bootstrapApplication(HomeComponent, {
  providers: [
    provideRouter(routes),
    importProvidersFrom(RouterModule)
  ]
});

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

