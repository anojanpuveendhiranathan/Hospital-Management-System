package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Doctor;
import com.example.demo.model.Speciality;
import com.example.demo.model.Staff;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.SpecialityRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;
	private final StaffRepository staffRepository;
	private final SpecialityRepository specialityRepository;

	public DoctorServiceImpl(StaffRepository staffRepository, SpecialityRepository specialityRepository,
			DoctorRepository doctorRepository) {
		this.staffRepository = staffRepository;
		this.specialityRepository = specialityRepository;
		this.doctorRepository = doctorRepository;
	}

	@Override
	@Transactional
	public Doctor addDoctor(DoctorDTO doctorDTO) {

		// 1️ Create staff entity
		Staff staff = Staff.builder().name(doctorDTO.getName()).dob(doctorDTO.getDob()).email(doctorDTO.getEmail())
				.contactNo(doctorDTO.getContactNo()).gender(Staff.Gender.valueOf(doctorDTO.getGender()))
				.shiftTime(doctorDTO.getShiftTime()).workStatus(Staff.WorkStatus.valueOf(doctorDTO.getWorkStatus()))
				.build();
		staffRepository.save(staff);

		// 2️ Fetch speciality if provided
		Speciality speciality = null;
		if (doctorDTO.getSpecialityId() != null) {
			speciality = specialityRepository.findById(doctorDTO.getSpecialityId())
					.orElseThrow(() -> new RuntimeException("Speciality not found"));
		}

		// 3️ Create doctor entity
		Doctor doctor = Doctor.builder().staff(staff).speciality(speciality)
				.patientsTreated(doctorDTO.getPatientsTreated()).expOfYears(doctorDTO.getExpOfYears())
				.qualification(doctorDTO.getQualification()).build();

		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
//        Doctor existingDoctor = getDoctorById(id);
//
//        existingDoctor.setName(updatedDoctor.getName());
//        existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
//        existingDoctor.setPatientsTreated(updatedDoctor.getPatientsTreated());
//        existingDoctor.setExperienceYears(updatedDoctor.getExperienceYears());
//        existingDoctor.setDateOfBirth(updatedDoctor.getDateOfBirth());
//        existingDoctor.setEmailId(updatedDoctor.getEmailId());
//        existingDoctor.setContactNumber(updatedDoctor.getContactNumber());
//        existingDoctor.setGender(updatedDoctor.getGender());
//        existingDoctor.setQualification(updatedDoctor.getQualification());
//        existingDoctor.setShiftTime(updatedDoctor.getShiftTime());
//        existingDoctor.setProfilePhoto(updatedDoctor.getProfilePhoto());
//        existingDoctor.setWorkStatus(updatedDoctor.getWorkStatus());
//
		return updatedDoctor;
	}

	@Override
	@Transactional
	public void deleteByEmail(String email) {
	    Doctor doctor = doctorRepository.findByStaffEmail(email)
	            .orElseThrow(() -> new RuntimeException("Doctor not found with email: " + email));
	    doctorRepository.delete(doctor); // staff will also be removed
	}

}
