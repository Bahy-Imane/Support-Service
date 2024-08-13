import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router} from '@angular/router';
import { AuthService } from './auth.service';
import {Role} from "../enum/role.model";

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate{

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRole = route.data['expectedRole'] as Role;
    const userRole = this.authService.getUserRole();
    console.log("role:" ,expectedRole)
    console.log("user role:" ,userRole)
    if (userRole === expectedRole) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}

