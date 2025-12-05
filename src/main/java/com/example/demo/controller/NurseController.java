package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.NurseDTO;
import com.example.demo.model.Nurse;
import com.example.demo.service.NurseService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/nurses")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @PostMapping
    public ResponseEntity<Nurse> createNurse(@RequestBody NurseDTO nurseDTO) {
        return ResponseEntity.ok(nurseService.addNurse(nurseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable Long id) {
        return ResponseEntity.ok(nurseService.getNurseById(id));
    }

    @GetMapping
    public ResponseEntity<List<Nurse>> getAllNurses() {
        return ResponseEntity.ok(nurseService.getAllNurses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable Long id, @RequestBody Nurse nurse) {
        return ResponseEntity.ok(nurseService.updateNurse(id, nurse));
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deleteNurseByEmail(@PathVariable String email) {
        nurseService.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }
}