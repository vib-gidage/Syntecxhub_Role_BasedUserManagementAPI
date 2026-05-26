package com.project.Role_BasedUserManagementAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "roles")
public class Role {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @NotBlank(message = "Role name is required")

    @Pattern(
        regexp = "ROLE_ADMIN|ROLE_USER",
        message = "Role must be ROLE_ADMIN or ROLE_USER"
    )

    @Column(nullable = false, unique = true)
    private String roleName;

	public Role() {
		super();
	}

	public Role(Long roleId, @NotBlank(message = "Role name is required") String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
    
    
}


