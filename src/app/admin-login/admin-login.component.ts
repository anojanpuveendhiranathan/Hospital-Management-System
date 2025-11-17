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
  showPopup: boolean = false; // <-- added for popup

  constructor(private adminService: AdminService, private router: Router) {}

  onLogin(): void {
    if (!this.email || !this.password) {
      this.showPopupMessage('Please enter both email and password.');
      return;
    }

    this.adminService.login(this.email, this.password).subscribe({
      next: (response) => {
        //this.showSuccess(response.message);

        if (response.status === 'success') {
          this.showSuccess(response.message);
          localStorage.setItem('adminEmail', this.email);
          localStorage.setItem('adminName', response.fullName);
          // this.router.navigate(['/admin/dashboard']);
        }
      },
      error: (err) => {
        this.showPopupMessage(
          err.error.message || 'Invalid email or password.'
        );
      },
    });
  }

  // <-- popup helper
  showPopupMessage(msg: string) {
    this.message = msg;
    this.showPopup = true;
  }

  // <-- close popup
  closePopup() {
    this.showPopup = false;
  }

  showToast = false;
  toastMessage = '';

  showSuccess(message: string) {
    this.toastMessage = message;
    this.showToast = true;

    // Auto-hide after 3 seconds
    setTimeout(() => {
      this.router.navigate(['/admin/dashboard']);
    }, 1500);
  }

  hideToast() {
    this.showToast = false;
  }
}
