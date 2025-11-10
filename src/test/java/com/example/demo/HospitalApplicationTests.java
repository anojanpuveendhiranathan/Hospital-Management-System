package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;

@SpringBootTest
class HospitalApplicationTests {
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;

//	@Test
//	void contextLoads() {
//	}
//
//	// Testing of Doc Controller
//	@Test
//	public void testReadAllFromDocList() {
//		List<Doctor> list = doctorRepository.findAll();
//		assertThat(list).size().isGreaterThan(0);
//	}
//
//	@Test
//	public void testEachDocById() {
//		Doctor doc = doctorRepository.findById(5).get();
//		assertEquals(5, doc.getId());
//	}
//
//	// Testing of Patient Controller
//	@Test
//	public void testReadAllFromPatientList() {
//		List<Patient> list = patientRepository.findAll();
//		assertThat(list).size().isGreaterThan(0);
//	}

}
