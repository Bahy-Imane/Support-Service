import { Component, OnInit } from '@angular/core';
import {Failure} from "../../core/model/failure.model";
import {FailureService} from "../../core/services/failure.service";
import {NgForOf} from "@angular/common";
import {RouterLink} from "@angular/router";


@Component({
  selector: 'app-failures',
  templateUrl: './all-failures.component.html',
  standalone: true,
  imports: [
    NgForOf,
    RouterLink
  ],
  styleUrls: ['./all-failures.component.css']
})
export class AllFailuresComponent implements OnInit {
  failures: Failure[] = [];

  constructor(private failureService: FailureService) {}

  ngOnInit(): void {
    this.loadFailures();
  }

  loadFailures(): void {
    this.failureService.getAllFailures().subscribe({
      next: (failures) => {
        this.failures = failures;
      },
      error: (err) => {
        console.error('Erreur lors du chargement des échecs', err);
      }
    });
  }

  editFailure(failureId: number): void {

    console.log('Éditer l’échec avec ID:', failureId);
  }

  deleteFailure(failureId: number): void {
    this.failureService.deleteFailure(failureId).subscribe({
      next: () => {
        this.failures = this.failures.filter(f => f.failureId !== failureId);
        console.log('Échec supprimé');
        // Gérez la suppression réussie (par exemple, affichez un message de succès)
      },
      error: (err) => {
        console.error('Erreur lors de la suppression de l’échec', err);
        // Gérez les erreurs (par exemple, affichez un message d'erreur)
      }
    });
  }
}
