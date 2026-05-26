package com.project.Role_BasedUserManagementAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Role_BasedUserManagementAPI.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

}