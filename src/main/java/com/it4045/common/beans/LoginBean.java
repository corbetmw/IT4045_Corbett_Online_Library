package com.it4045.common.beans;

import com.it4045.common.dto.User;
import com.it4045.common.exceptions.InvalidLoginException;
import com.it4045.common.service.LoginService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

/**
 *A bean class which enables login functionality for
 * the application
 */
@ManagedBean(name = "loginBean", eager = true)
//@SessionScoped
public class LoginBean implements Serializable {
    private LoginService loginService = new LoginService();

    private static final String REDIRECT_HOME_PAGE = "user_dashboard.xhtml?faces-redirect=true";
    private static final String REDIRECT_LOGIN_PAGE = "home.xhtml?faces-redirect=true";

    private String userName;
    private String password;

    /**
     * Login to the application. This methods checks for the username and password, and if not, shows an error on
     * and inform you on the UI.
     *
     * @return page to redirect to the user dashboard if login is successful (user_dashboard.xhtml)
     */
    public String login() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        try {
            User user = this.loginService.login(userName, password);
            currentInstance.getExternalContext().getSessionMap().put("user", user);
            return REDIRECT_HOME_PAGE;
        } catch (InvalidLoginException e) {
            String message = "User " + e.getUsername() + " not found or password was incorrect, please try again";
            currentInstance.addMessage("loginForm:submitButton", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Logout of the webpage.
     *
     * @return login page to login as someone else if wanted
     */
    public String logout() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        currentInstance.getExternalContext().getSessionMap().put("user", null);
        return REDIRECT_LOGIN_PAGE;
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

}
