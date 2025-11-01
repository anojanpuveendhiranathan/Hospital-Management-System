package com.example.demo.service;

import com.example.demo.model.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);
    Doctor getDoctorById(Integer id);
    List<Doctor> getAllDoctors();
    Doctor updateDoctor(Integer id, Doctor doctor);
    void deleteDoctor(Integer id);
}
