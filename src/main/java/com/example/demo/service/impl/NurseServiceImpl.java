package com.example.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.NurseDTO;
import com.example.demo.model.Nurse;
import com.example.demo.model.Speciality;
import com.example.demo.model.Staff;
import com.example.demo.repository.NurseRepository;
import com.example.demo.repository.SpecialityRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.NurseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurseServiceImpl implements NurseService {

    private final NurseRepository nurseRepository;
    private final StaffRepository staffRepository;
    private final SpecialityRepository specialityRepository;

    @Override
    @Transactional
    public Nurse addNurse(NurseDTO nurseDTO) {

        // Create staff
        Staff staff = Staff.builder()
                .name(nurseDTO.getName())
                .dob(nurseDTO.getDob())
                .email(nurseDTO.getEmail())
                .contactNo(nurseDTO.getContactNo())
                .gender(Staff.Gender.valueOf(nurseDTO.getGender()))
                .shiftTime(nurseDTO.getShiftTime())
                .workStatus(Staff.WorkStatus.valueOf(nurseDTO.getWorkStatus()))
                .build();

        staffRepository.save(staff);

        // Get speciality
        Speciality speciality = null;
        if (nurseDTO.getSpecialityId() != null) {
            speciality = specialityRepository.findById(nurseDTO.getSpecialityId())
                    .orElseThrow(() -> new RuntimeException("Speciality not found"));
        }

        // Create nurse
        Nurse nurse = Nurse.builder()
                .staff(staff)
                .speciality(speciality)
                .expOfYears(nurseDTO.getExpOfYears())
                .qualification(nurseDTO.getQualification())
                .build();

        return nurseRepository.save(nurse);
    }

    @Override
    public Nurse getNurseById(Long id) {
        return nurseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nurse not found with ID: " + id));
    }

    @Override
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse updateNurse(Long id, Nurse nurse) {
        // TODO: implement update logic similar to doctor
        return nurse;
    }

    @Override
    @Transactional
    public void deleteByEmail(String email) {
        Nurse nurse = nurseRepository.findByStaffEmail(email)
                .orElseThrow(() -> new RuntimeException("Nurse not found with email: " + email));

        nurseRepository.delete(nurse);
    }
}