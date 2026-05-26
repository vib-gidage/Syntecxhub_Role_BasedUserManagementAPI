package com.project.Role_BasedUserManagementAPI.dto;

public class UserResponse {

    private int userId;
    private String userName;
    private String email;
    private String roleName;
    private boolean blocked;

    public UserResponse() {
        super();
    }

    public UserResponse(int userId, String userName, String email, String roleName, boolean blocked) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.roleName = roleName;
        this.blocked = blocked;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    
}