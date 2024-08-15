import { Component, OnInit } from '@angular/core';
import {Equipment} from "../../core/model/equipment.model";
import {EquipmentService} from "../../core/services/equipment.service";
import {NgForOf} from "@angular/common";
import {RouterLink} from "@angular/router";


@Component({
  selector: 'app-equipments',
  templateUrl: './all-equipments.component.html',
  standalone: true,
  imports: [
    NgForOf,
    RouterLink
  ],
  styleUrls: ['./all-equipments.component.css']
})
export class AllEquipmentsComponent implements OnInit {
  equipmentList: Equipment[] = [];

  constructor(private equipmentService: EquipmentService) {}

  ngOnInit(): void {
    this.loadEquipment();
  }

  loadEquipment(): void {
    this.equipmentService.getAllEquipment().subscribe({
      next: (equipment) => {
        this.equipmentList = equipment;
      },
      error: (err) => {
        console.error('Erreur lors du chargement des équipements', err);
        // Gérez les erreurs (par exemple, affichez un message d'erreur)
      }
    });
  }

  addEquipment(): void {
    // Logique pour ajouter un nouvel équipement
    console.log('Ajouter un équipement');
  }

  editEquipment(equipmentId: number): void {
    console.log('Éditer l\'équipement avec ID:', equipmentId);
  }

  deleteEquipment(equipmentId: number): void {
    this.equipmentService.deleteEquipment(equipmentId).subscribe({
      next: () => {
        this.equipmentList = this.equipmentList.filter(e => e.equipmentId !== equipmentId);
        console.log('Équipement supprimé');
      },
      error: (err) => {
        console.error('Erreur lors de la suppression de l\'équipement', err);
      }
    });
  }
}
