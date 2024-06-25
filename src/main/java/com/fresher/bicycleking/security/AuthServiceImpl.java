package com.fresher.bicycleking.security;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fresher.bicycleking.dto.LoginDTO;
import com.fresher.bicycleking.dto.RegistrationDTO;
import com.fresher.bicycleking.entity.Role;
import com.fresher.bicycleking.entity.User;
import com.fresher.bicycleking.entity.UserEmail;
import com.fresher.bicycleking.exceptions.UserEmailAlreadyExistsException;
import com.fresher.bicycleking.exceptions.UsernameAlreadyExistsException;
import com.fresher.bicycleking.repository.RoleRepository;
import com.fresher.bicycleking.repository.UserEmailRepository;
import com.fresher.bicycleking.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserEmailRepository userEmailRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public String register(RegistrationDTO registrationDTO) {
		if (userEmailRepository.existsByEmailAccount(registrationDTO.getEmail())) {
			throw new UserEmailAlreadyExistsException("User email already exists!");
		}

		if (userRepository.existsByUsername(registrationDTO.getUsername())) {
			throw new UsernameAlreadyExistsException("Username already exists!");
		}

		User user = new User();
		user.setUsername(registrationDTO.getUsername());

		UserEmail userEmail = new UserEmail();
		userEmail.setEmailAccount(registrationDTO.getEmail());
		user.setUserEmail(userEmail);

		int strength = 10;
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(registrationDTO.getPassword());
		user.setPassword(encodedPassword);

		Set<Role> roles = new HashSet<Role>();
		Role role = roleRepository.findByName("ROLE_USER");
		roles.add(role);

		user.setRoles(roles);

		userEmail.setUser(user);
		userEmailRepository.save(userEmail);
		userRepository.save(user);
		return "User Registered Successfully!.";
	}

	@Override
	public String login(LoginDTO loginDTO) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return "Login Successful";
	}

}
