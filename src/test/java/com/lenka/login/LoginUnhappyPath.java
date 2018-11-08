package com.lenka.login;

import com.lenka.TestCase;
import com.lenka.pages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.lenka.service.PropertiesController.getProperty;
import static com.lenka.view.LiteCart.*;

public class LoginUnhappyPath extends TestCase {

    private static final String LOGIN = getProperty("login.1");
    private static final String PASSWORD = getProperty("password.1");
    private static final String EMPTY_STR = "";

    private Login loginPage;

    @BeforeMethod
    public void setUpTest() {
        log.info("TEST STARTS");
    }

    @DataProvider
    public Object [] [] emptyLoginCombinations () {
        return new Object[][] {
                {EMPTY_STR, EMPTY_STR},
                {EMPTY_STR, PASSWORD}
        };
    }

    @Test
    public void testEnteringValidEmailButEmptyPassword() {
        loginPage = new Login(driver);
        loginPage.navigateToLoginPage();
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(EMPTY_STR);
        loginPage.pressLoginButton();
        pause(1);

        Assert.assertTrue(assertElementNotPresent(LOGOUT_LINK));
        Assert.assertTrue(assertElementPresent(LOGIN_ERROR_MSG));

    }

    @AfterMethod
    public void logOut() {
        log.info("TEST ENDS");
    }
}
