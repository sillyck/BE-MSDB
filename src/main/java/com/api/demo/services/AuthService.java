package com.api.demo.services;

import org.springframework.stereotype.Service;

import com.api.demo.auth.AuthResponse;
import com.api.demo.auth.LoginRequest;
import com.api.demo.auth.RegisterRequest;
import com.api.demo.models.Role;
import com.api.demo.models.User;
import com.api.demo.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final JwtService jwtService;
	
	public AuthResponse login(LoginRequest request) {
		return null;
	}

	public AuthResponse register(RegisterRequest request) {
		User user = User.builder()
				.username(request.getUsername())
				.password(request.getPassword())
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.country(request.getCountry())
				.rol(Role.USER)
				.build();
		
		userRepository.save(user);
		
		return AuthResponse.builder()
				.token(jwtService.getToken(user))
				.build();
	}

}
