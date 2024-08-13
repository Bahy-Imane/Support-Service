// import { Component } from '@angular/core';
// import {UserService} from "../../core/services/user.service";
// import {User} from "../../core/model/user.model";
//
//
// @Component({
//   selector: 'app-user-form',
//   templateUrl: './user-form.component.html',
//   standalone: true,
//   styleUrls: ['./user-form.component.scss']
// })
// export class AddUserComponent {
//   user: User = {
//     userName: '',
//     email: '',
//     password: ''
//   };
//
//   constructor(private userService: UserService) {}
//
//   onSubmit(): void {
//     this.userService.addUser(this.user).subscribe({
//       next: (newUser) => {
//         console.log('User added', newUser);
//         // Handle successful addition (e.g., redirect or display a success message)
//       },
//       error: (err) => {
//         console.error('Failed to add user', err);
//         // Handle error (e.g., display an error message)
//       }
//     });
//   }
// }
