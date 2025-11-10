package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;

@CrossOrigin(origins = "http://localhost:4200") // allow Angular
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	private final AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@PostMapping
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return appointmentService.createAppointment(appointment);
	}

	@GetMapping
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	@GetMapping("/{id}")
	public Optional<Appointment> getAppointmentById(@PathVariable Long id) {
		return appointmentService.getAppointmentById(id);
	}

	@PutMapping("/{id}")
	public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		return appointmentService.updateAppointment(id, appointment);
	}

	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointment(id);
	}
}