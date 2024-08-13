import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { RouterModule } from '@angular/router';
import {EquipmentService} from "../../core/services/equipment.service";
import {UserService} from "../../core/services/user.service";
import {TechnicianService} from "../../core/services/technician.service";
import {FailureService} from "../../core/services/failure.service";
import {HeaderComponent} from "../header/header.component";

@Component({
  selector: 'app-admin-home',
  standalone: true,
  imports: [RouterModule, HeaderComponent],
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  @Output() itemSelected = new EventEmitter<string>();

  onSelect(item: string) {
    this.itemSelected.emit(item);
  }

  allUsersNum?: number;
  allFailuresNum?: number;
  allEquipmentNum?: number;
  allTechniciansNum?: number;

  constructor(private equipmentService: EquipmentService,
              private userService :UserService,
              private technicianService :TechnicianService,
              private failureService :FailureService) {}

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe({
      next: (res) => {
          this.allUsersNum = res.length;
      }
    });

    // Get total number of failures
    this.failureService.getAllFailures().subscribe({
      next: (res) => {
          this.allFailuresNum = res.length;

      }
    });

    this.equipmentService.getAllEquipment().subscribe({
      next: (res) => {

          this.allEquipmentNum = res.length;

      }
    });

    this.technicianService.getAllTechnicians().subscribe({
      next: (res) => {
          this.allTechniciansNum = res.length;

      }
    });
  }
}