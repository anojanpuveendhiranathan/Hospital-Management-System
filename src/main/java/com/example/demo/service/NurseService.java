package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.NurseDTO;
import com.example.demo.model.Nurse;

public interface NurseService {

    Nurse addNurse(NurseDTO nurseDTO);

    Nurse getNurseById(Long id);

    List<Nurse> getAllNurses();

    Nurse updateNurse(Long id, Nurse nurse);

    void deleteByEmail(String email);
}