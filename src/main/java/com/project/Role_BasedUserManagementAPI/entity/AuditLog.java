package com.project.Role_BasedUserManagementAPI.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "audit_logs")
public class AuditLog {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Action is required")
	    @Column(nullable = false)
	    private String action;

	    @NotBlank(message = "PerformedBy is required")
	    @Column(nullable = false)
	    private String performedBy;

	    @Column(nullable = false, updatable = false)
	    private LocalDateTime actionTime = LocalDateTime.now();

		public AuditLog() {
			super();
		}

		public AuditLog(Long id, @NotBlank(message = "Action is required") String action,
				@NotBlank(message = "PerformedBy is required") String performedBy, LocalDateTime actionTime) {
			super();
			this.id = id;
			this.action = action;
			this.performedBy = performedBy;
			this.actionTime = actionTime;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

		public String getPerformedBy() {
			return performedBy;
		}

		public void setPerformedBy(String performedBy) {
			this.performedBy = performedBy;
		}

		public LocalDateTime getActionTime() {
			return actionTime;
		}

		public void setActionTime(LocalDateTime actionTime) {
			this.actionTime = actionTime;
		}
	    
	    
	}


