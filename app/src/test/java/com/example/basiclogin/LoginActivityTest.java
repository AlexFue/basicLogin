package com.example.basiclogin;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginActivityTest {

    public LoginActivity loginActivity;

    @Test
    public void testUsernameInvalidPassword(){
        String username = "alex";
        String password = "";

        loginActivity.intializeUsers();
        assertEquals("wrong password", LoginActivity.isValidCredentials(username, password));
    }

    @Test
    public void testPasswordInvalidUsername(){
        String username = "alexe";
        String password = "123";

        loginActivity.intializeUsers();
        assertEquals( "wrong user", LoginActivity.isValidCredentials(username, password));
    }

    @Test
    public void testValidLogin(){
        String username = "alex";
        String password = "123";

        loginActivity.intializeUsers();
        assertEquals("valid", LoginActivity.isValidCredentials(username, password));
    }
}
