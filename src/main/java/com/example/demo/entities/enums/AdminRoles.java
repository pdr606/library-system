package com.example.demo.entities.enums;

public enum AdminRoles {

    ADMIN("admin");


    private String role;

     AdminRoles(String role){
        this.role = role;
    }

    public String getRole(){
         return role;
    }

}
