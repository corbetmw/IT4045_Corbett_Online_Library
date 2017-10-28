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
            String message = "User " + getNewUser().getUserName() + " already exists, please try with another user";
            currentInstance.addMessage("createUserForm:createUser", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String message = "User " + getNewUser().getUserName() + " created successfully!";
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

