package com.it4045.common.beans;

import javax.faces.bean.ManagedBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "home", eager = true)
public class Home {

    public Home() {
        System.out.println("Hello World started!");
    }

    public String getMessage() {
        return "Hello, World!";
    }

    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}