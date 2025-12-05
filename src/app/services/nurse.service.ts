import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class NurseService {
  private baseUrl = 'http://localhost:8080/api/nurses';

  constructor(private http: HttpClient) {}

  // Create Nurse
  createNurse(nurse: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, nurse);
  }

  // Get Nurse by ID
  getNurseById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  // Get All Nurses
  getAllNurses(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`);
  }

  // Update Nurse
  updateNurse(id: number, nurse: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, nurse);
  }

  // Delete Nurse
  deleteNurse(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {
      responseType: 'text',
    });
  }
}
