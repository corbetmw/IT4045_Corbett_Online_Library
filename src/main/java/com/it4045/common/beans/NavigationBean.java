package com.it4045.common.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationBean implements Serializable {

    public String moveToCreateAccount() {
        return "create_account.xhtml";
    }
}