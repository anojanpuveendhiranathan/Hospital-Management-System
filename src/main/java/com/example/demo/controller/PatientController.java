package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	// Create Patient
	@PostMapping
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		Patient savedPatient = patientService.createPatient(patient);
		return ResponseEntity.ok(savedPatient);
	}

	// Get Patient by ID
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Integer id) {
		Patient patient = patientService.getPatientById(id);
		return ResponseEntity.ok(patient);
	}

	// Get All Patients
	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> patients = patientService.getAllPatients();
		return ResponseEntity.ok(patients);
	}

	// Update Patient
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
		Patient updatedPatient = patientService.updatePatient(id, patient);
		return ResponseEntity.ok(updatedPatient);
	}

	// Delete Patient
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable Integer id) {
		patientService.deletePatient(id);
		return ResponseEntity.ok("Patient with ID " + id + " deleted successfully.");
	}
}
