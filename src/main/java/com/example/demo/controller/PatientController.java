package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exception.PatientException;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;

	// get all patients
	@GetMapping("/patients_info")
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@PostMapping("/patients_info")
	public Patient addpatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	@GetMapping("/patients_info/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new PatientException("Patient not exist with id :" + id));
		return ResponseEntity.ok(patient);
	}

}
