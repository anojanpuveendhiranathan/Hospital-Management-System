package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Patient;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient getPatientById(Integer id);
    List<Patient> getAllPatients();
    Patient updatePatient(Integer id, Patient patient);
    void deletePatient(Integer id);
}
