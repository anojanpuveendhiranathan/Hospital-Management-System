package com.example.demo.service;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Doctor;
import java.util.List;

public interface DoctorService {
	Doctor addDoctor(DoctorDTO doctorDTO);
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    Doctor updateDoctor(Long id, Doctor doctor);
    void deleteByEmail(String email);
}
