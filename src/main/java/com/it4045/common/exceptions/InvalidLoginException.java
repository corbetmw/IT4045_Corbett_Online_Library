package com.it4045.common.exceptions;

import java.io.IOException;

public class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) throws IOException {
        super(message);
    }
}
