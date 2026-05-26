package com.project.Role_BasedUserManagementAPI.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RoleUpdateRequest {

    @NotBlank(message = "Role name is required")

    @Pattern(
            regexp = "ROLE_ADMIN|ROLE_USER",
            message = "Role must be ROLE_ADMIN or ROLE_USER"
    )
    private String roleName;

    public RoleUpdateRequest() {
        super();
    }

    public RoleUpdateRequest(String roleName) {
        super();
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}