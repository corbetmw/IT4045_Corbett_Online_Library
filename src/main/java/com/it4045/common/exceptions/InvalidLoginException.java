package com.it4045.common.exceptions;

import java.io.IOException;

public class InvalidLoginException extends Exception {
    private String userName;

    public InvalidLoginException(String userName)
    {
        this.userName = userName;
    }

    public String getUsername()
    {
        return this.userName;
    }
}
