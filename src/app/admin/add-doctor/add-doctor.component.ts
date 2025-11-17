import { Component, OnDestroy, OnInit, Renderer2 } from '@angular/core';
import {
  SpecialityService,
  Speciality,
} from '../../services/speciality.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css'],
})
export class AddDoctorComponent implements OnInit {
  private styleLink!: HTMLLinkElement;
  private scriptElement!: HTMLScriptElement;
  private cssElement!: HTMLLinkElement;
  specialities: Speciality[] = [];
  constructor(
    private renderer: Renderer2,
    private specialityService: SpecialityService,
    private http: HttpClient,
    private router: Router
  ) {}

  // Add this
  doctor = {
    name: '',
    email: '',
    contactNo: '',
    specialityId: null, // <-- for dropdown
    qualification: '',
    shiftStart: '',
    shiftEnd: '',
    shiftTime: '',
    gender: '',
    dob: '',
    expOfYears: '',
    patientsTreated: '',
    workStatus: '',
  };

  ngOnInit() {
    this.cssElement = this.renderer.createElement('link');
    this.cssElement.rel = 'stylesheet';
    this.cssElement.href =
      'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css';
    document.head.appendChild(this.cssElement);

    this.styleLink = this.renderer.createElement('link');
    this.styleLink.rel = 'stylesheet';
    this.styleLink.href = 'assets/css/dashboard.bootstrap.min.css'; // ✅ your custom version
    document.head.appendChild(this.styleLink);

    this.scriptElement = this.renderer.createElement('script');
    this.scriptElement.src = 'assets/js/dashboard.bootstrap.min.js';
    this.scriptElement.type = 'text/javascript';
    this.scriptElement.async = true;
    document.body.appendChild(this.scriptElement);
    this.loadSpecialities();
  }

  loadSpecialities() {
    this.specialityService.getAll().subscribe(
      (data) => (this.specialities = data),
      (err) => console.error(err)
    );
  }

  addDoctor() {
    console.log(this.doctor); // Check payload
    this.doctor.shiftTime = `${this.doctor.shiftStart} - ${this.doctor.shiftEnd}`;
    this.http.post('http://localhost:8080/api/doctors', this.doctor).subscribe({
      next: (res) => {
        this.showSuccess('Doctor added successfully!');
        this.doctor = {
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
          patientsTreated: '',
          workStatus: '',
        };
      },
      error: (err) => console.error(err),
    });
  }

  ngOnDestroy() {
    if (this.cssElement) {
      document.head.removeChild(this.cssElement); // ✅ remove when leaving dashboard
    }
    if (this.styleLink) {
      document.head.removeChild(this.styleLink); // ✅ remove when leaving dashboard
    }
    if (this.scriptElement) {
      document.body.removeChild(this.scriptElement);
    }
  }

  showToast = false;
  toastMessage = '';

  showSuccess(message: string) {
    this.toastMessage = message;
    this.showToast = true;

    // Auto-hide after 3 seconds
    setTimeout(() => {
      window.history.back();
    }, 1500);
  }

  hideToast() {
    this.showToast = false;
  }
}
