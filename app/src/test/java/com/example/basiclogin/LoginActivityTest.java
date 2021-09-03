package com.example.basiclogin;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <h2>Login Class Test</h2>
 * Class has 3 function tests that test for invalid username, invalid password, and valid credentials.
 */

public class LoginActivityTest {

    public LoginActivity loginActivity;

    /**
     * Test creates credentials with wrong password for user.
     * Initializes list of valid users.
     * Asserts if login was invalid because of wrong password with method from Login Activity.
     *
     * (Other 2 tests have same functionality but expect different outcome due to credentials)
     */
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
