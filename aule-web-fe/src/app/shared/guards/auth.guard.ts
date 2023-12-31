import { Injectable } from '@angular/core';
import {
  CanActivate,
  Router,
} from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    // take token
    const jwt = localStorage.getItem('jwt');
    if (!jwt) {
      this.router.navigate(['/login']);
      return false;
    } else {
      return true;
    }
  }
}
