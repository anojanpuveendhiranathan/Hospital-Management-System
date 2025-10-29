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

import com.example.demo.exception.DoctorException;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DoctorController {
	@Autowired
	private DoctorRepository doctorRepository;

	// get all doctors by rest api
	@GetMapping("/doc_info")
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	// create doctor rest api
	@PostMapping("/doc_info")
	public Doctor createEmployee(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	// get doctor by id rest api
	@GetMapping("/doc_info/{id}")
	public ResponseEntity<Doctor> getEmployeeById(@PathVariable Long id) {
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new DoctorException("Doctor not exist with id :" + id));
		return ResponseEntity.ok(doctor);
	}
}
