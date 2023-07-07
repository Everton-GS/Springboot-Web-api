package com.example.Projectwebapi.entitys;

public enum UserRole {
    
    ADMIN("admin"),
    User("user");

    private String role;

    UserRole(String role){
        this.role=role;
    }

    public String getRole(){
        return role;
    }
}
