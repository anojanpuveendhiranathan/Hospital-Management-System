package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;


    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        // If doctor ID is provided, fetch the doctor entity
        if (appointment.getDoctor() != null && appointment.getDoctor().getId() != null) {
            Doctor doctor = doctorRepository.findById(appointment.getDoctor().getId())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            appointment.setDoctor(doctor);
        }

        // You can also automatically set createdAt/updatedAt here if needed
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id)
            .map(existing -> {
                existing.setName(updatedAppointment.getName());
                existing.setEmail(updatedAppointment.getEmail());
                existing.setDob(updatedAppointment.getDob());
                existing.setGender(updatedAppointment.getGender());
                existing.setContactNo(updatedAppointment.getContactNo());
                existing.setDescription(updatedAppointment.getDescription());
                existing.setDepartment(updatedAppointment.getDepartment());
                existing.setAppointmentDatetime(updatedAppointment.getAppointmentDatetime());
                existing.setDoctor(updatedAppointment.getDoctor());
                return appointmentRepository.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("Appointment not found with id " + id));
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}