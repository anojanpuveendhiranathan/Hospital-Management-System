import { Component, OnInit, Renderer2, OnDestroy } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {
  Speciality,
  SpecialityService,
} from '../../services/speciality.service';

@Component({
  selector: 'app-add-nurse',
  templateUrl: './add-nurse.component.html',
  styleUrls: ['./add-nurse.component.css'],
})
export class AddNurseComponent implements OnInit, OnDestroy {
  private styleLink!: HTMLLinkElement;
  private scriptElement!: HTMLScriptElement;
  private cssElement!: HTMLLinkElement;

  nurse = {
    name: '',
    email: '',
    contactNo: '',
    specialityId: null, // <-- use ID instead of string
    qualification: '',
    shiftStart: '',
    shiftEnd: '',
    shiftTime: '',
    gender: '',
    dob: '',
    expOfYears: '',
    workStatus: '',
  };

  specialities: Speciality[] = []; // <-- dynamic

  showToast = false;
  toastMessage = '';

  constructor(
    private renderer: Renderer2,
    private http: HttpClient,
    private router: Router,
    private specialityService: SpecialityService
  ) {}

  ngOnInit() {
    // Load external CSS & JS
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
    this.scriptElement.async = true;
    document.body.appendChild(this.scriptElement);

    // Load specialities dynamically
    this.loadSpecialities();
  }

  loadSpecialities() {
    this.specialityService.getAll().subscribe(
      (data) => (this.specialities = data),
      (err) => console.error(err)
    );
  }

  addNurse() {
    this.nurse.shiftTime = `${this.nurse.shiftStart} - ${this.nurse.shiftEnd}`;
    this.http.post('http://localhost:8080/api/nurses', this.nurse).subscribe({
      next: () => {
        this.showSuccess('Nurse added successfully!');
        this.nurse = {
          name: '',
          email: '',
          contactNo: '',
          specialityId: null,
          qualification: '',
          shiftStart: '',
          shiftEnd: '',
          shiftTime: '',
          gender: '',
          dob: '',
          expOfYears: '',
          workStatus: '',
        };
      },
      error: (err) => console.error(err),
    });
  }

  showSuccess(message: string) {
    this.toastMessage = message;
    this.showToast = true;

    setTimeout(() => {
      window.history.back();
    }, 1500);
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
