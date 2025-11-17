import { Component, OnDestroy, OnInit, Renderer2 } from '@angular/core';
import { DoctorService } from '../../services/doctor.service';
import { HttpClient } from '@angular/common/http';
declare var bootstrap: any; // Needed for Bootstrap JS modal

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css'],
})
export class DoctorComponent implements OnInit, OnDestroy {
  private styleLink!: HTMLLinkElement;
  private scriptElement!: HTMLScriptElement;
  private cssElement!: HTMLLinkElement;

  doctors: any[] = [];
  doctorToDelete: string | null = null; // store email of doctor to delete
  deleteModal: any;

  constructor(
    private renderer: Renderer2,
    private doctorService: DoctorService,
    private http: HttpClient
  ) {}

  ngOnInit() {
    this.cssElement = this.renderer.createElement('link');
    this.cssElement.rel = 'stylesheet';
    this.cssElement.href =
      'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css';
    document.head.appendChild(this.cssElement);

    this.styleLink = this.renderer.createElement('link');
    this.styleLink.rel = 'stylesheet';
    this.styleLink.href = 'assets/css/dashboard.bootstrap.min.css';
    document.head.appendChild(this.styleLink);

    this.scriptElement = this.renderer.createElement('script');
    this.scriptElement.src = 'assets/js/dashboard.bootstrap.min.js';
    this.scriptElement.type = 'text/javascript';
    this.scriptElement.async = true;
    document.body.appendChild(this.scriptElement);

    this.loadDoctors();

    // Initialize Bootstrap modal after scripts are loaded
    setTimeout(() => {
      const modalEl = document.getElementById('deleteModal');
      if (modalEl) this.deleteModal = new bootstrap.Modal(modalEl);
    }, 500);
  }

  loadDoctors() {
    this.doctorService.getAllDoctors().subscribe({
      next: (res) => (this.doctors = res),
      error: (err) => console.error(err),
    });
  }

  showDeleteModal(email: string) {
    this.doctorToDelete = email;
    this.deleteModal.show();
  }

  confirmDelete() {
    if (!this.doctorToDelete) return;
    this.http
      .delete(`http://localhost:8080/api/doctors/email/${this.doctorToDelete}`)
      .subscribe({
        next: () => {
          this.showSuccess('Doctor and associated staff deleted successfully!');

          this.loadDoctors();
          this.deleteModal.hide();
          this.doctorToDelete = null;
        },
        error: (err) => console.error(err),
      });
  }

  ngOnDestroy() {
    if (this.cssElement) document.head.removeChild(this.cssElement);
    if (this.styleLink) document.head.removeChild(this.styleLink);
    if (this.scriptElement) document.body.removeChild(this.scriptElement);
  }

  showToast = false;
  toastMessage = '';

  showSuccess(message: string) {
    this.toastMessage = message;
    this.showToast = true;

    // Auto-hide after 3 seconds
    setTimeout(() => {
      this.showToast = false;
    }, 3000);
  }

  hideToast() {
    this.showToast = false;
  }
}
