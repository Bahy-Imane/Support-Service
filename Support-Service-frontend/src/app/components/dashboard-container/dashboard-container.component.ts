import { Component } from '@angular/core';
import {NgSwitch, NgSwitchCase, NgSwitchDefault} from "@angular/common";
import {AdminDashboardComponent} from "../admin-Dashbord/admin-Dashboard.component";
import {AllTechniciansComponent} from "../all-technicians/all-technicians.component";
import {AllFailuresComponent} from "../all-failures/all-failures.component";
import {AllEquipmentsComponent} from "../all-equipments/all-equipments.component";

@Component({
  selector: 'app-dashboard-container',
  standalone: true,
  imports: [
    NgSwitchCase,
    NgSwitchDefault,
    NgSwitch,
    AdminDashboardComponent,
    AllTechniciansComponent,
    AllFailuresComponent,
    AllEquipmentsComponent
  ],
  templateUrl: './dashboard-container.component.html',
  styleUrl: './dashboard-container.component.css'
})
export class DashboardContainerComponent {

  selectedItem: string | null = null;

  onItemSelected(item: string) {
    this.selectedItem = item;
  }
}
