package com.project.Role_BasedUserManagementAPI.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Role_BasedUserManagementAPI.entity.User;
import com.project.Role_BasedUserManagementAPI.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;    
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> getAllUsers() {
	    return userrepository.findAll();
	}
	
	public User getUserById(int id) {
	    return userrepository.findById(id)
	    		.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}
	
	public User updateUser(int id, User updatedUser) {

	    User existingUser = userrepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

	    // Update fields
	    existingUser.setUserName(updatedUser.getUserName());
	    existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
	    existingUser.setEmail(updatedUser.getEmail());
	    return userrepository.save(existingUser);
	}
	
	public void deleteUser(int id) {

	    User user = userrepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

	    userrepository.delete(user);
	}
	

}
