package com.example.demo.entities;


import com.example.demo.entities.enums.AdminRoles;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.w3c.dom.Text;

import java.util.Collection;
import java.util.List;

@Entity

@Table(name = "tb-admin")
public class Admin implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String login;
    private String password;
    private AdminRoles role;

    public Admin(String login, String password, AdminRoles role ){
        this.login = login;
        this.password = password;
        this.role = role;
    }


    public Admin(String id, String login, String password, AdminRoles role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Admin() {

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdminRoles getRole() {
        return role;
    }

    public void setRole(AdminRoles role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == AdminRoles.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else{
            return null;
        }
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
