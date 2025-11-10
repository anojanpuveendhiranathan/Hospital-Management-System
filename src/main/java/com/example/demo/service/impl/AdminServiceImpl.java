package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public Admin registerAdmin(Admin admin) {
		// Encrypt password before saving
		admin.setPwd(passwordEncoder.encode(admin.getPwd()));
		return adminRepository.save(admin);
	}

	@Override
	public Optional<Admin> login(String email, String password) {
		// Fetch admin by email
		Optional<Admin> optionalAdmin = adminRepository.findByEmail(email);

		if (optionalAdmin.isPresent()) {
			Admin admin = optionalAdmin.get();
			// Check if password matches
			if (passwordEncoder.matches(password, admin.getPwd())) {
				return Optional.of(admin);
			}
		}
		// Invalid credentials
		return Optional.empty();
	}
}
