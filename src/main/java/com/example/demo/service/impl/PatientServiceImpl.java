package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatientById(Long id) {
		return patientRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient updatePatient(Long id, Patient updatedPatient) {
//		Patient existingPatient = getPatientById(id);
//
//		existingPatient.setFirstName(updatedPatient.getFirstName());
//		existingPatient.setLastName(updatedPatient.getLastName());
//		existingPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
//		existingPatient.setGender(updatedPatient.getGender());
//		existingPatient.setContactNumber(updatedPatient.getContactNumber());
//		existingPatient.setCity(updatedPatient.getCity());
//		existingPatient.setBloodGroup(updatedPatient.getBloodGroup());
//		existingPatient.setCurrentMedication(updatedPatient.getCurrentMedication());
//		existingPatient.setDateOfAdmission(updatedPatient.getDateOfAdmission());
//		existingPatient.setDateOfDischarge(updatedPatient.getDateOfDischarge());
//		existingPatient.setBillingAmount(updatedPatient.getBillingAmount());
//		existingPatient.setRoomNumber(updatedPatient.getRoomNumber());
//		existingPatient.setEmergencyNumber(updatedPatient.getEmergencyNumber());

		return updatedPatient;
	}

	@Override
	public void deletePatient(Long id) {
		Patient patient = getPatientById(id);
		patientRepository.delete(patient);
	}
}
