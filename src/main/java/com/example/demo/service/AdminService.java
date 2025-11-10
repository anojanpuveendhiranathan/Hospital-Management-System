package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Admin;

public interface AdminService {
	Admin registerAdmin(Admin admin); // for signup (optional)

	Optional<Admin> login(String email, String password); // for login
}
