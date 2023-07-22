import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  isAdminLogged: boolean = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe((e) => {
        this.getPermission();
      });
  }

  getPermission() {
    const jwt = localStorage.getItem('jwt');
    if (!!jwt) {
      this.isAdminLogged = true;
    }
  }

  goHome() {
    this.router.navigate(['/home']);
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  goToDashboard() {
    this.router.navigate(['/dashboard']);
  }

  onLogout() {
    localStorage.removeItem('jwt');
    this.isAdminLogged = false;
    this.router.navigate(['/login']);
  }
}
