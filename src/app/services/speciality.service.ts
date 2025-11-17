import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Speciality {
  id?: number;
  name: string;
}

@Injectable({
  providedIn: 'root',
})
export class SpecialityService {
  private baseUrl = 'http://localhost:8080/api/specialities';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Speciality[]> {
    return this.http.get<Speciality[]>(this.baseUrl);
  }

  getById(id: number): Observable<Speciality> {
    return this.http.get<Speciality>(`${this.baseUrl}/${id}`);
  }

  create(speciality: Speciality): Observable<Speciality> {
    return this.http.post<Speciality>(this.baseUrl, speciality);
  }

  update(id: number, speciality: Speciality): Observable<Speciality> {
    return this.http.put<Speciality>(`${this.baseUrl}/${id}`, speciality);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
