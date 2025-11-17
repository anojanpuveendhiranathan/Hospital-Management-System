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

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	// Create Doctor
	@PostMapping
	public ResponseEntity<Doctor> createDoctor(@RequestBody DoctorDTO doctorDTO) {
		Doctor savedDoctor = doctorService.addDoctor(doctorDTO);
		return ResponseEntity.ok(savedDoctor);
	}

	// Get Doctor by ID
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		Doctor doctor = doctorService.getDoctorById(id);
		return ResponseEntity.ok(doctor);
	}

	// Get All Doctors
	@GetMapping
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		return ResponseEntity.ok(doctors);
	}

	// Update Doctor
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
		Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
		return ResponseEntity.ok(updatedDoctor);
	}

	@DeleteMapping("/email/{email}")
	public ResponseEntity<Void> deleteDoctorByEmail(@PathVariable String email) {
	    doctorService.deleteByEmail(email);
	    return ResponseEntity.noContent().build();
	}
}