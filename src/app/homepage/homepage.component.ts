// src/app/components/homepage/homepage.component.ts
import { Component, OnInit, OnDestroy, Renderer2 } from '@angular/core';
import { DoctorService } from '../../app/services/doctor.service';
import { AppointmentService } from '../../app/services/appointment.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit, OnDestroy {
  private bootstrapLink!: HTMLLinkElement;
  private fontAwesomeLink!: HTMLLinkElement;
  private animateLink!: HTMLLinkElement;
  private owlCarousel!: HTMLLinkElement;
  private tooplateStyle!: HTMLLinkElement;

  title = 'Hospital Management System';
  doctors: any[] = [];

  // Form fields
  formData = {
    name: '',
    email: '',
    dob: '',
    gender: '',
    contactNo: '',
    department: '',
    doctorId: '',
    appointmentDatetime: '',
    description: '',
  };

  constructor(
    private doctorService: DoctorService,
    private appointmentService: AppointmentService,
    private renderer: Renderer2
  ) {}

  ngOnInit() {
    this.doctorService.getAllDoctors().subscribe(
      (res) => {
        this.doctors = res;
      },
      (err) => console.error('Error fetching doctors:', err)
    );

    this.bootstrapLink = this.renderer.createElement('link');
    this.bootstrapLink.rel = 'stylesheet';
    this.bootstrapLink.href = 'assets/css/bootstrap.min.css'; // ✅ bootstrap for homepage only
    document.head.appendChild(this.bootstrapLink);

    this.fontAwesomeLink = this.renderer.createElement('link');
    this.fontAwesomeLink.rel = 'stylesheet';
    this.fontAwesomeLink.href = 'assets/css/font-awesome.min.css'; // ✅ font awesome for homepage only
    document.head.appendChild(this.fontAwesomeLink);

    this.animateLink = this.renderer.createElement('link');
    this.animateLink.rel = 'stylesheet';
    this.animateLink.href = 'assets/css/animate.css'; // ✅ animate for homepage only
    document.head.appendChild(this.animateLink);

    this.owlCarousel = this.renderer.createElement('link');
    this.owlCarousel.rel = 'stylesheet';
    this.owlCarousel.href = 'assets/css/owl.carousel.css'; // ✅ owlCarousel for homepage only
    document.head.appendChild(this.owlCarousel);

    this.tooplateStyle = this.renderer.createElement('link');
    this.tooplateStyle.rel = 'stylesheet';
    this.tooplateStyle.href = 'assets/css/tooplate-style.css'; // ✅ tooplate for homepage only
    document.head.appendChild(this.tooplateStyle);
  }

  ngOnDestroy() {
    if (this.bootstrapLink) {
      document.head.removeChild(this.bootstrapLink); // ✅ remove when leaving dashboard
    }
    if (this.fontAwesomeLink) {
      document.head.removeChild(this.fontAwesomeLink); // ✅ remove when leaving dashboard
    }
    if (this.animateLink) {
      document.head.removeChild(this.animateLink); // ✅ remove when leaving dashboard
    }
    if (this.owlCarousel) {
      document.head.removeChild(this.owlCarousel); // ✅ remove when leaving dashboard
    }
    if (this.tooplateStyle) {
      document.head.removeChild(this.tooplateStyle); // ✅ remove when leaving dashboard
    }
  }

  submitAppointment() {
    // map form data to backend structure
    const payload = {
      name: this.formData.name,
      email: this.formData.email,
      dob: this.formData.dob,
      gender: this.formData.gender,
      contactNo: this.formData.contactNo,
      department: this.formData.department,
      doctor: { id: this.formData.doctorId },
      appointmentDatetime: this.formData.appointmentDatetime,
      description: this.formData.description,
    };

    this.appointmentService.createAppointment(payload).subscribe(
      (res) => {
        alert('Appointment successfully created!');
        console.log(res);
      },
      (err) => {
        alert('Error creating appointment');
        console.error(err);
      }
    );
  }
}
