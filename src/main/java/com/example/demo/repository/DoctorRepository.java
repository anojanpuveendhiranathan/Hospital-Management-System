package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>{

}
