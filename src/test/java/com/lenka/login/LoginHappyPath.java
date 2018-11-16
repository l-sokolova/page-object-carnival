package com.lenka.login;

import com.lenka.TestCase;
import com.lenka.pages.Login;
import com.lenka.pages.Logout;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.lenka.service.PropertiesController.getProperty;
import static com.lenka.view.LiteCart.*;

public class LoginHappyPath extends TestCase {

    private Login loginPage;
    private Logout logoutPage;

    private static final String LOGIN = getProperty("login.1");
    private static final String PASSWORD = getProperty("password.1");

    @BeforeMethod
    public void setUpTest() {
        log.info("TEST STARTS");
        loginPage = new Login(driver);
        loginPage.navigateToLoginPage();
    }

    @Test (priority = 3)
    public void testEnteringValidCredentials() {
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
        logoutPage = loginPage.pressLoginButton();
        pause(1);

        Assert.assertTrue(assertElementNotPresent(LOGIN_BUTTON));
        Assert.assertTrue(assertElementPresent(LOGOUT_LINK));

        logoutPage.pressLogoutButton();
    }

    @Test (priority = 2)
    public void testLoginSectionHeaderLink() {
        pause(1);
        Assert.assertTrue(assertTextOfElementsEqual(getProperty("login.header.text"), LOGIN_HEADER));
    }

    @Test (priority = 1)
    public void testLoginPageElementsArePresent() {
        pause(1);
        Assert.assertTrue(assertElementPresent(LOGIN_BUTTON));
        Assert.assertTrue(assertElementPresent(LOGIN_INPUT));
        Assert.assertTrue(assertElementPresent(PASSWORD_INPUT));
        Assert.assertTrue(assertElementPresent(LOGIN_HEADER));
        Assert.assertTrue(assertElementPresent(CREATE_ACCOUNT_LINK));
        Assert.assertTrue(assertElementPresent(FORGOT_PASSWORD_BUTTON));
    }

    @AfterMethod
    public void logOut() {
        log.info("TEST ENDS");
    }
}
