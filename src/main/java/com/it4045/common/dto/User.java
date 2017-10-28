package com.it4045.common.dto;

/**
 * A class to represent a user IRL.
 *
 */
public class User {
    Integer id;
    String userName;
    String password;
    String fullName;
    String role;

    public User() {
    }


    public User(Integer id, String userName, String password, String fullName, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}