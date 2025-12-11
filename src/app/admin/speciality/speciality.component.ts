import { Component, OnInit, OnDestroy, Renderer2 } from '@angular/core';
import {
  SpecialityService,
  Speciality,
} from '../../services/speciality.service';

@Component({
  selector: 'app-speciality',
  templateUrl: './speciality.component.html',
  styleUrls: ['./speciality.component.css'],
})
export class SpecialityComponent implements OnInit, OnDestroy {
  specialities: Speciality[] = [];

  // Add speciality
  newSpeciality: string = '';

  // Edit speciality
  editSpecialityId!: number;
  editSpecialityValue: string = '';

  // Bootstrap dynamic load
  private cssElement!: HTMLLinkElement;
  private styleLink!: HTMLLinkElement;
  private scriptElement!: HTMLScriptElement;
  private popperScript!: HTMLScriptElement;
  private bootstrapScript!: HTMLScriptElement;

  constructor(
    private specialityService: SpecialityService,
    private renderer: Renderer2
  ) {}

  ngOnInit(): void {
    this.loadSpecialities();
    this.loadDashboardAssets();
  }

  // ==================== LOAD SPECIALITIES ====================
  loadSpecialities() {
    this.specialityService.getAll().subscribe((data) => {
      this.specialities = data;
    });
  }

  // ==================== ADD SPECIALITY ====================
  onAdd() {
    if (!this.newSpeciality.trim()) return;

    const speciality: Speciality = {
      name: this.newSpeciality,
    };

    this.specialityService.create(speciality).subscribe(() => {
      this.newSpeciality = '';
      this.loadSpecialities();
    });
  }

  // ==================== SET DATA FOR EDIT ====================
  onEdit(s: Speciality) {
    this.editSpecialityId = s.id!;
    this.editSpecialityValue = s.name;
  }

  // ==================== UPDATE SPECIALITY ====================
  onUpdate() {
    const updated: Speciality = {
      name: this.editSpecialityValue,
    };

    this.specialityService
      .update(this.editSpecialityId, updated)
      .subscribe(() => {
        this.loadSpecialities();
      });
  }

  // ==================== DELETE SPECIALITY ====================
  onDelete(id: number) {
    this.specialityService.delete(id).subscribe(() => {
      this.loadSpecialities();
    });
  }

  // ==================== DYNAMIC CSS/JS LOADING ====================
  loadDashboardAssets() {
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

    // Popper (required by Bootstrap)
    this.popperScript = this.renderer.createElement('script');
    this.popperScript.src =
      'https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js';
    this.popperScript.defer = true;
    document.body.appendChild(this.popperScript);

    // Bootstrap JS (depends on Popper)
    this.bootstrapScript = this.renderer.createElement('script');
    this.bootstrapScript.src =
      'https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js';
    this.bootstrapScript.defer = true;
    document.body.appendChild(this.bootstrapScript);
  }

  ngOnDestroy(): void {
    if (this.cssElement) document.head.removeChild(this.cssElement);
    if (this.styleLink) document.head.removeChild(this.styleLink);
    if (this.scriptElement) document.body.removeChild(this.scriptElement);
  }
}
