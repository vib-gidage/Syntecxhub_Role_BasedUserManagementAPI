package com.project.Role_BasedUserManagementAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Role_BasedUserManagementAPI.config.JwtUtil;
import com.project.Role_BasedUserManagementAPI.dto.AuthResponse;
import com.project.Role_BasedUserManagementAPI.dto.LoginRequest;
import com.project.Role_BasedUserManagementAPI.dto.RegisterRequest;
import com.project.Role_BasedUserManagementAPI.entity.Role;
import com.project.Role_BasedUserManagementAPI.entity.User;
import com.project.Role_BasedUserManagementAPI.repository.RoleRepository;
import com.project.Role_BasedUserManagementAPI.repository.UserRepository;

@Service
public class AuthService {
	
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private RoleRepository roleRepository;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    public String register(RegisterRequest request) {

	        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
	            throw new RuntimeException("Email already exists");
	        }

	        Role role = roleRepository.findByRoleName("ROLE_USER")
	                .orElseThrow(() -> new RuntimeException("Default role not found"));

	        User user = new User();
	        user.setUserName(request.getUserName());
	        user.setEmail(request.getEmail());

	        // BCrypt encoded password
	        user.setPassword(passwordEncoder.encode(request.getPassword()));

	        user.setRole(role);
	        user.setBlocked(false);

	        userRepository.save(user);

	        return "User Registered Successfully";
	    }
	    
	    public AuthResponse login(LoginRequest request) {

	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        request.getEmail(),
	                        request.getPassword()
	                )
	        );

	        String token = jwtUtil.generateToken(request.getEmail());

	        return new AuthResponse(token);
	    }

}

