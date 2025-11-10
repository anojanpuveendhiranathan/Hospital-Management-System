import { Component } from '@angular/core';
import { AdminService } from '../../app/services/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css'],
})
export class AdminLoginComponent {
  email: string = '';
  password: string = '';
  message: string = '';

  constructor(private adminService: AdminService, private router: Router) {}

  onLogin(): void {
    if (!this.email || !this.password) {
      this.message = 'Please enter both email and password.';
      return;
    }

    this.adminService.login(this.email, this.password).subscribe({
      next: (response) => {
        this.message = response;
        if (response.includes('successful')) {
          // store login info locally if needed
          localStorage.setItem('adminEmail', this.email);
          // redirect to dashboard
          this.router.navigate(['/']);
        }
      },
      error: (err) => {
        this.message = err.error || 'Invalid email or password.';
      },
    });
  }
}
