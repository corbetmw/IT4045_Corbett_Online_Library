package com.it4045.common.beans;

import com.it4045.common.dao.UserDAO;
import com.it4045.common.dto.User;
import com.it4045.common.exceptions.InvalidLoginException;
import com.it4045.common.service.LoginService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name="loginBean", eager = true)
//@SessionScoped
public class LoginBean  implements Serializable {
    @ManagedProperty(value="#{param.userName}")
    String userName;
    @ManagedProperty(value="#{param.password}")
    String password;
    @ManagedProperty(value= "#{param.loginMessage}")
    String loginMessage = "";
    @ManagedProperty(value="#{param.fullName}")
    String fullName;

    LoginService loginService;

    public LoginBean() {
        this.setLoginService(new LoginService());

    }

    public void login(){

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            User user = this.loginService.doLogin(this.userName, this.password);
            context.getExternalContext().getSessionMap().put("user", user.getFullname() );
            context.getExternalContext().getSessionMap().put("role", user.getRole() );

        } catch (InvalidLoginException e) {
            this.setLoginMessage(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("user");
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
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

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
}
