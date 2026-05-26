package com.project.Role_BasedUserManagementAPI.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Role_BasedUserManagementAPI.entity.AuditLog;
import com.project.Role_BasedUserManagementAPI.entity.Role;
import com.project.Role_BasedUserManagementAPI.entity.User;
import com.project.Role_BasedUserManagementAPI.repository.AuditLogRepository;
import com.project.Role_BasedUserManagementAPI.repository.RoleRepository;
import com.project.Role_BasedUserManagementAPI.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;
    
    @Autowired
    private AuditLogService auditLogService;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Block User
    public String blockUser(int id, String adminEmail) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        user.setBlocked(true);

        userRepository.save(user);

        // Audit Log
        auditLogService.saveLog(
                "USER_BLOCKED",
                adminEmail
        );

        return "User blocked successfully";
    }

    // Unblock User
    public String unblockUser(int id, String adminEmail) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        user.setBlocked(false);

        userRepository.save(user);

        AuditLog log = new AuditLog();
        log.setAction("USER_UNBLOCKED");
        log.setPerformedBy(adminEmail);
        log.setActionTime(LocalDateTime.now());

        auditLogRepository.save(log);

        return "User unblocked successfully";
    }

    // Promote User To Admin
    public String promoteToAdmin(int id, String adminEmail) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Role adminRole = roleRepository.findByRoleName("ROLE_ADMIN")
                .orElseThrow(() ->
                        new RuntimeException("Admin role not found"));

        user.setRole(adminRole);

        userRepository.save(user);

        AuditLog log = new AuditLog();
        log.setAction("USER_PROMOTED_TO_ADMIN");
        log.setPerformedBy(adminEmail);
        log.setActionTime(LocalDateTime.now());

        auditLogRepository.save(log);

        return "User promoted to admin successfully";
    }

    // Delete User
    public String deleteUser(int id, String adminEmail) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        userRepository.delete(user);

        AuditLog log = new AuditLog();
        log.setAction("USER_DELETED");
        log.setPerformedBy(adminEmail);
        log.setActionTime(LocalDateTime.now());

        auditLogRepository.save(log);

        return "User deleted successfully";
    }
}