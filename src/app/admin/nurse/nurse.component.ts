import { Component, OnDestroy, OnInit, Renderer2 } from '@angular/core';
import { NurseService } from '../../services/nurse.service';
import { HttpClient } from '@angular/common/http';
declare var bootstrap: any;

@Component({
  selector: 'app-nurse',
  templateUrl: './nurse.component.html',
  styleUrls: ['./nurse.component.css'],
})
export class NurseComponent implements OnInit, OnDestroy {
  private styleLink!: HTMLLinkElement;
  private scriptElement!: HTMLScriptElement;
  private cssElement!: HTMLLinkElement;

  nurses: any[] = [];
  nurseToDelete: string | null = null;
  deleteModal: any;

  showToast = false;
  toastMessage = '';

  constructor(
    private renderer: Renderer2,
    private nurseService: NurseService,
    private http: HttpClient
  ) {}

  ngOnInit() {
    // Load external CSS files
    this.cssElement = this.renderer.createElement('link');
    this.cssElement.rel = 'stylesheet';
    this.cssElement.href =
      'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css';
    document.head.appendChild(this.cssElement);

    this.styleLink = this.renderer.createElement('link');
    this.styleLink.rel = 'stylesheet';
    this.styleLink.href = 'assets/css/dashboard.bootstrap.min.css';
    document.head.appendChild(this.styleLink);

    // Load Bootstrap JS
    this.scriptElement = this.renderer.createElement('script');
    this.scriptElement.src = 'assets/js/dashboard.bootstrap.min.js';
    this.scriptElement.type = 'text/javascript';
    this.scriptElement.async = true;
    document.body.appendChild(this.scriptElement);

    // Load list
    this.loadNurses();

    // Initialize bootstrap modal
    setTimeout(() => {
      const modalEl = document.getElementById('deleteModal');
      if (modalEl) this.deleteModal = new bootstrap.Modal(modalEl);
    }, 500);
  }

  loadNurses() {
    this.nurseService.getAllNurses().subscribe({
      next: (res) => (this.nurses = res),
      error: (err) => console.error(err),
    });
  }

  showDeleteModal(email: string) {
    this.nurseToDelete = email;
    this.deleteModal.show();
  }

  confirmDelete() {
    if (!this.nurseToDelete) return;

    this.http
      .delete(`http://localhost:8080/api/nurses/email/${this.nurseToDelete}`)
      .subscribe({
        next: () => {
          this.showSuccess('Nurse and associated staff deleted successfully!');
          this.loadNurses();
          this.deleteModal.hide();
          this.nurseToDelete = null;
        },
        error: (err) => console.error(err),
      });
  }

  // Toast Functions
  showSuccess(message: string) {
    this.toastMessage = message;
    this.showToast = true;

    setTimeout(() => {
      this.showToast = false;
    }, 3000);
  }

  hideToast() {
    this.showToast = false;
  }

  ngOnDestroy() {
    if (this.cssElement) document.head.removeChild(this.cssElement);
    if (this.styleLink) document.head.removeChild(this.styleLink);
    if (this.scriptElement) document.body.removeChild(this.scriptElement);
  }
}
