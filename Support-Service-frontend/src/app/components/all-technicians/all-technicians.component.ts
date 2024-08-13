import { Component, OnInit } from '@angular/core';

import {NgForOf} from "@angular/common";
import {Technician} from "../../core/model/technician.model";
import {TechnicianService} from "../../core/services/technician.service";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-technicians',
  templateUrl: './all-technicians.component.html',
  standalone: true,
  imports: [
    NgForOf,
    RouterLink
  ],
  styleUrls: ['./all-technicians.component.css']
})
export class AllTechniciansComponent implements OnInit {
  technicians: Technician[] = [];

  constructor(private technicianService: TechnicianService) {}

  ngOnInit(): void {
    this.loadTechnicians();
  }

  loadTechnicians(): void {
    this.technicianService.getTechnicians().subscribe({
      next: (technicians:Technician[]) => {
        this.technicians = technicians;
      },
      error: (err) => {
        console.error('Erreur lors du chargement des techniciens', err);
      }
    });
  }


  deleteTechnician(technicianId: number): void {
    this.technicianService.deleteTechnician(technicianId).subscribe({
      next: () => {
        this.technicians = this.technicians.filter(t => t.personId !== technicianId);
        console.log('Technicien supprimé');
      },
      error: (err) => {
        console.error('Erreur lors de la suppression du technicien', err);
      }
    });
  }
}
