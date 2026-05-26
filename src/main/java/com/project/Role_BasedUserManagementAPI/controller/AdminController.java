package com.project.Role_BasedUserManagementAPI.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Role_BasedUserManagementAPI.entity.User;
import com.project.Role_BasedUserManagementAPI.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    // Block User
    @PutMapping("/block/{id}")
    public String blockUser(
            @PathVariable int id,
            Principal principal) {

        return adminService.blockUser(id, principal.getName());
    }

    // Unblock User
    @PutMapping("/unblock/{id}")
    public String unblockUser(
            @PathVariable int id,
            Principal principal) {

        return adminService.unblockUser(id, principal.getName());
    }

    // Promote User
    @PutMapping("/promote/{id}")
    public String promoteUser(
            @PathVariable int id,
            Principal principal) {

        return adminService.promoteToAdmin(id, principal.getName());
    }

    // Delete User
    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(
            @PathVariable int id,
            Principal principal) {

        return adminService.deleteUser(id, principal.getName());
    }
}