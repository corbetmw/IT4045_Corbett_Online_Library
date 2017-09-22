package com.it4045.common.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationBean implements Serializable {
    public String moveToCreateAccount() {
        return "create_account";
    }

    public String getLocation(){
        return "page2";
    }

    public String getCurrentFacelet(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        String facelet = ctx.getViewRoot().getViewId().replace("/", "").replace(".xhtml", "");
        if (facelet.equalsIgnoreCase("name_form")){
            return "home";
        }else{
            return "name_form";
        }

    }

    public String redirect(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        String facelet = ctx.getViewRoot().getViewId().replace("/", "").replace(".xhtml", "");
        if (facelet.equalsIgnoreCase("nav1")){
            return "home";
        }else{
            return "name_form";
        }

    }
}