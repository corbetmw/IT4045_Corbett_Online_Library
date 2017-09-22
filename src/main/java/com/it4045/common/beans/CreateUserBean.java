package com.it4045.common.beans;


import com.it4045.common.dto.User;
import com.it4045.common.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.IOException;

@ManagedBean(name="createUserBean", eager = true)
public class CreateUserBean {
    @ManagedProperty(value = "#{param.fullName}")
    private String fullName;
    @ManagedProperty(value = "#{param.userName}")
    private String userName;
    @ManagedProperty(value = "#{param.password}")
    private String password;
    @ManagedProperty(value = "#{param.role}")
    private String role;

    public String createUser() throws IOException{
        UserService userService = new UserService();
        User user = new User();
        user.setFullname(this.fullName);
        user.setUsername(this.userName);
        user.setPassword(this.password);

        try {
            userService.createUser(user);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }


    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

