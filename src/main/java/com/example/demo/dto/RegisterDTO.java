package com.example.demo.dto;

import com.example.demo.entities.enums.AdminRoles;

public record RegisterDTO(String login, String password, AdminRoles role) {
}
