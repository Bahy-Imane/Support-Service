import { Component, OnInit } from '@angular/core';

import {NgForOf} from "@angular/common";
import {Technician} from "../../core/model/technician.model";
import {TechnicianService} from "../../core/services/technician.service";

@Component({
  selector: 'app-technicians',
  templateUrl: './all-technicians.component.html',
  standalone: true,
  imports: [
    NgForOf
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
    this.technicianService.getAllTechnicians().subscribe({
      next: (technicians) => {
        this.technicians = technicians;
      },
      error: (err) => {
        console.error('Erreur lors du chargement des techniciens', err);
      }
    });
  }

  addTechnician(): void {
    console.log('Ajouter un technicien');
  }

  editTechnician(technicianId: number): void {
    console.log('Éditer le technicien avec ID:', technicianId);
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
