package com.teamtreehouse.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamtreehouse.core.BaseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String name;

    @JsonIgnore
    private String username;
    @JsonIgnore
    private String[] roles;
    @JsonIgnore
    private String password;

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public User(String name, String username, String[] roles, String password) {
        this.name = name;
        this.username = username;
        this.roles = roles;
        setPassword(password);
    }

    protected User() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }
}
