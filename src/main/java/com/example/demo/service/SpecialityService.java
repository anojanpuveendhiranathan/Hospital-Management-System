package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Speciality;

public interface SpecialityService {

    Speciality createSpeciality(Speciality speciality);

    List<Speciality> getAllSpecialities();

    Optional<Speciality> getSpecialityById(Long id);

    Speciality updateSpeciality(Long id, Speciality speciality);

    void deleteSpeciality(Long id);
}