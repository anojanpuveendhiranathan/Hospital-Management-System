package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.Speciality;
import com.example.demo.repository.SpecialityRepository;
import com.example.demo.service.SpecialityService;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Speciality createSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public List<Speciality> getAllSpecialities() {
        return specialityRepository.findAll();
    }

    @Override
    public Optional<Speciality> getSpecialityById(Long id) {
        return specialityRepository.findById(id);
    }

    @Override
    public Speciality updateSpeciality(Long id, Speciality speciality) {
        return specialityRepository.findById(id)
                .map(existing -> {
                    existing.setName(speciality.getName());
                    return specialityRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Speciality not found with id " + id));
    }

    @Override
    public void deleteSpeciality(Long id) {
        specialityRepository.deleteById(id);
    }
}