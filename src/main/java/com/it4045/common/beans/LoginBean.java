package com.it4045.common.beans;

import com.it4045.common.dao.UserDAO;
import com.it4045.common.dto.User;
import com.it4045.common.exceptions.InvalidLoginException;
import com.it4045.common.service.LoginService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name="loginBean", eager = true)
//@SessionScoped
public class LoginBean  implements Serializable {
//    @ManagedProperty(value="#{param.userName}")
//    String userName;
//    @ManagedProperty(value="#{param.password}")
//    String password;
//    @ManagedProperty(value= "#{param.loginMessage}")
//    String loginMessage = "";
//    @ManagedProperty(value="#{param.fullName}")
//    String fullName;
//
//    LoginService loginService;
//
//    public LoginBean() {
//        this.setLoginService(new LoginService());
//
//    }
//
//    public void login(){
//
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        try {
//            User user = this.loginService.doLogin(this.userName, this.password);
//            context.getExternalContext().getSessionMap().put("user", user.getFullname() );
//            context.getExternalContext().getSessionMap().put("role", user.getRole() );
//
//        } catch (InvalidLoginException e) {
//            this.setLoginMessage(e.getMessage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public void logout(){
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.getExternalContext().getSessionMap().remove("user");
//    }
//
//    public String getFullname() {
//        return fullName;
//    }
//
//    public void setFullname(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public LoginService getLoginService() {
//        return loginService;
//    }
//
//    public void setLoginService(LoginService loginService) {
//        this.loginService = loginService;
//    }
//
//    public String getUsername() {
//        return userName;
//    }
//
//    public void setUsername(String userName) {
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
//    public String getLoginMessage() {
//        return loginMessage;
//    }
//
//    public void setLoginMessage(String loginMessage) {
//        this.loginMessage = loginMessage;
//    }
//@Inject
private LoginService loginService = new LoginService();

    private static final String REDIRECT_HOME_PAGE = "user_dashboard.xhtml?faces-redirect=true";
    private static final String REDIRECT_LOGIN_PAGE = "home.xhtml?faces-redirect=true";

    private String userName;
    private String password;

    /**
     * Login to the application. This methods checks for the username and password, and if not, shows an error on
     * and inform you on the UI.
     * @return page to redirect to the user dashboard if login is successful (user_dashboard.xhtml)
     */
    public String login()
    {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        try
        {
            User user = this.loginService.login(userName, password);
            currentInstance.getExternalContext().getSessionMap().put("user", user);
            return REDIRECT_HOME_PAGE;
        }
        catch (InvalidLoginException e)
        {
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
    public String logout()
    {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        currentInstance.getExternalContext().getSessionMap().put("user", null);
        return REDIRECT_LOGIN_PAGE;
    }

    public String getUsername()
    {
        return userName;
    }

    public void setUsername(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
