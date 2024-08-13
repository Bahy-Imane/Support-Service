// import { Injectable } from '@angular/core';
// import { CanActivate, Router, UrlTree } from '@angular/router';
// import { Observable } from 'rxjs';
// import {AuthService} from "./core/services/auth.service";
//
// @Injectable({
//   providedIn: 'root'
// })
// export class RoleGuard implements CanActivate {
//   constructor(private authService: AuthService, private router: Router) {}
//
//
//   canActivate(expectedRoles: string[]): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
//     const userRole = localStorage.getItem('role');
//     if (userRole && expectedRoles.includes(userRole)) {
//       return true; // User has the required role
//     } else {
//       return this.router.createUrlTree(['/access-denied']); // Redirect if role does not match
//     }
//   }
// }
//
