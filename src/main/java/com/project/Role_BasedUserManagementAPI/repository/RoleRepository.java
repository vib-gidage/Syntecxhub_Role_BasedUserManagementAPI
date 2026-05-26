package com.project.Role_BasedUserManagementAPI.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Role_BasedUserManagementAPI.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(String roleName);
}