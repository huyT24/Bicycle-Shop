package com.fresher.bicycleking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fresher.bicycleking.dto.LoginDTO;
import com.fresher.bicycleking.dto.RegistrationDTO;

@RestController
@RequestMapping("/bicycleking/auth")
public class AuthController {
	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegistrationDTO registrationDTO) {
		String response = authService.register(registrationDTO);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDto) {
		String token = authService.login(loginDto);
		return new ResponseEntity<>(token, HttpStatus.OK);
	}
}
