package com.pioneers.universitysystem.models.entities;

import java.util.Date;
import java.util.Objects;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String username;
    private String password;
    private Date birthDate;
    private boolean isLoggedIn;



    public User(String fullName, String email, String username, String password, Date birthDate) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.isLoggedIn = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return id == user.id || (Objects.equals(email, user.email) && Objects.equals(username, user.username));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}