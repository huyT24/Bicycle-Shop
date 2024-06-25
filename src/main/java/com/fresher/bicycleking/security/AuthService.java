package com.fresher.bicycleking.security;

import com.fresher.bicycleking.dto.LoginDTO;
import com.fresher.bicycleking.dto.RegistrationDTO;

public interface AuthService {
	String register(RegistrationDTO registrationDTO);
	String login(LoginDTO loginDTO);
}
