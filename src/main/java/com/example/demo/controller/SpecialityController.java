package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Speciality;
import com.example.demo.service.SpecialityService;

import java.util.List;

@RestController
@RequestMapping("/api/specialities")
@CrossOrigin(origins = "http://localhost:4200")
public class SpecialityController {

    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @PostMapping
    public ResponseEntity<Speciality> createSpeciality(@RequestBody Speciality speciality) {
        return ResponseEntity.ok(specialityService.createSpeciality(speciality));
    }

    @GetMapping
    public ResponseEntity<List<Speciality>> getAllSpecialities() {
        return ResponseEntity.ok(specialityService.getAllSpecialities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speciality> getSpecialityById(@PathVariable Long id) {
        return specialityService.getSpecialityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Speciality> updateSpeciality(@PathVariable Long id, @RequestBody Speciality speciality) {
        return ResponseEntity.ok(specialityService.updateSpeciality(id, speciality));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpeciality(@PathVariable Long id) {
        specialityService.deleteSpeciality(id);
        return ResponseEntity.ok().build();
    }
}