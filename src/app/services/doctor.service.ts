import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DoctorService {
  private baseUrl = 'http://localhost:8080/api/doctors';

  constructor(private http: HttpClient) {}

  // Create Doctor
  createDoctor(doctor: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, doctor);
  }

  // Get Doctor by ID
  getDoctorById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  // Get All Doctors
  getAllDoctors(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`);
  }

  // Update Doctor
  updateDoctor(id: number, doctor: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, doctor);
  }

  // Delete Doctor
  deleteDoctor(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
