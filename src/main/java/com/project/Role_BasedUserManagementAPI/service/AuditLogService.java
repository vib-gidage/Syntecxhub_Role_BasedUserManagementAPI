package com.project.Role_BasedUserManagementAPI.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Role_BasedUserManagementAPI.entity.AuditLog;
import com.project.Role_BasedUserManagementAPI.repository.AuditLogRepository;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void saveLog(String action, String performedBy) {

        AuditLog log = new AuditLog();

        log.setAction(action);
        log.setPerformedBy(performedBy);
        log.setActionTime(LocalDateTime.now());

        auditLogRepository.save(log);
    }
}