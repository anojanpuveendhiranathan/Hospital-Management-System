// src/app/components/homepage/homepage.component.ts
import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../../app/services/doctor.service';
import { AppointmentService } from '../../app/services/appointment.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
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
    private appointmentService: AppointmentService
  ) {}

  ngOnInit() {
    this.doctorService.getDoctors().subscribe(
      (res) => {
        this.doctors = res;
      },
      (err) => console.error('Error fetching doctors:', err)
    );
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
