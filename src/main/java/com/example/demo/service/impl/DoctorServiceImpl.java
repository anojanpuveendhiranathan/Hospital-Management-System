package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Integer id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor updateDoctor(Integer id, Doctor updatedDoctor) {
        Doctor existingDoctor = getDoctorById(id);

        existingDoctor.setName(updatedDoctor.getName());
        existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
        existingDoctor.setPatientsTreated(updatedDoctor.getPatientsTreated());
        existingDoctor.setExperienceYears(updatedDoctor.getExperienceYears());
        existingDoctor.setDateOfBirth(updatedDoctor.getDateOfBirth());
        existingDoctor.setEmailId(updatedDoctor.getEmailId());
        existingDoctor.setContactNumber(updatedDoctor.getContactNumber());
        existingDoctor.setGender(updatedDoctor.getGender());
        existingDoctor.setQualification(updatedDoctor.getQualification());
        existingDoctor.setShiftTime(updatedDoctor.getShiftTime());
        existingDoctor.setProfilePhoto(updatedDoctor.getProfilePhoto());
        existingDoctor.setWorkStatus(updatedDoctor.getWorkStatus());

        return doctorRepository.save(existingDoctor);
    }

    @Override
    public void deleteDoctor(Integer id) {
        Doctor doctor = getDoctorById(id);
        doctorRepository.delete(doctor);
    }
}
