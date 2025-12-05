package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Nurse;
import com.example.demo.model.Speciality;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
    List<Nurse> findBySpeciality(Speciality speciality);
    Optional<Nurse> findByStaffEmail(String email);
}