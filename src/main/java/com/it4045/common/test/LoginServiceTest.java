package com.it4045.common.test;

import com.it4045.common.service.LoginService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class to test the
 * LoginService
 */
public class LoginServiceTest {

    LoginService loginService;
    @Before
    public void setUp() throws Exception {
        loginService= new LoginService();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testLogin() throws Exception {
        loginService.login("jdoe","password");
    }


}
