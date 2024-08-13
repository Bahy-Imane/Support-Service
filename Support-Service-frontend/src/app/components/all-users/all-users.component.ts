import { Component, OnInit } from '@angular/core';
import {User} from "../../core/model/user.model";
import {UserService} from "../../core/services/user.service";
import {NgForOf} from "@angular/common";


@Component({
  selector: 'app-users',
  templateUrl: './all-users.component.html',
  standalone: true,
  imports: [
    NgForOf
  ],
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    this.userService.getAllUsers().subscribe({
      next: (users) => {
        this.users = users;
      },
      error: (err) => {
        console.error('Erreur lors du chargement des utilisateurs', err);

      }
    });
  }

  addUser(): void {

    console.log('Ajouter un utilisateur');
  }

  editUser(userId: number): void {

    console.log('Éditer l’utilisateur avec ID:', userId);
  }

  deleteUser(userId: number): void {
    this.userService.deleteUserById(userId).subscribe({
      next: () => {
        this.users = this.users.filter(u => u.personId !== userId);
        console.log('Utilisateur supprimé');
      },
      error: (err) => {
        console.error('Erreur lors de la suppression de l’utilisateur', err);
      }
    });
  }
}
