package com.it4045.common.beans;


import com.it4045.common.dto.User;
import com.it4045.common.exceptions.InvalidLoginException;
import com.it4045.common.exceptions.UserExistsException;
import com.it4045.common.exceptions.UserException;
import com.it4045.common.service.LoginService;
import com.it4045.common.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name="createUserBean", eager = true)
public class CreateUserBean {
//    @ManagedProperty(value = "#{param.fullName}")
//    String fullName;
//    @ManagedProperty(value = "#{param.userName}")
//    String userName;
//    @ManagedProperty(value = "#{param.password}")
//    String password;
//    @ManagedProperty(value = "#{param.role}")
//    String role;
//
//    public String createUser() throws IOException{
//        UserService userService = new UserService();
//        LoginService loginService = new LoginService();
//        User user = new User();
//        user.setFullname(this.fullName);
//        user.setUsername(this.userName);
//        user.setPassword(this.password);
//
//        try {
//            userService.createUser(user);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            loginService.doLogin(user.getUsername(),user.getPassword());
//        } catch (InvalidLoginException e) {
//            e.printStackTrace();
//        }
//
//        return "user_dashboard";
//    }
//
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//@Inject
     private User newUser;

    /**
     * Add a new user
     *
     * @return the page to go to next (currently stay on the same page to show messages)
     */
    public String createUser() throws IOException
    {
        UserService userService = new UserService();

        FacesContext currentInstance = FacesContext.getCurrentInstance();
        try
        {
            userService.createUser(getNewUser());
        }
        catch (UserException e)
        {
            String message = "User " + e.getUserName() + " was not created";
            currentInstance.addMessage("createUserForm:createUser", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
        }
        catch (UserExistsException e)
        {
            String message = "User " + getNewUser().getUsername() + " already exists, please try with another user";
            currentInstance.addMessage("createUserForm:createUser", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String message = "User " + getNewUser().getUsername() + " created successfully!";
        currentInstance.addMessage("createUserForm:createUser", new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));

        return "user_dashboard";
    }

    public User getNewUser()
    {
        if (newUser == null)
        {
            newUser = new User();
        }
        return newUser;
    }

    public void setNewUser(User newUser)
    {
        this.newUser = newUser;
    }


}

