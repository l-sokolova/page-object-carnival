package com.lenka.pages;

import org.openqa.selenium.WebDriver;

import static com.lenka.service.PropertiesController.getProperty;
import static com.lenka.view.LiteCart.LOGIN_BUTTON;
import static com.lenka.view.LiteCart.LOGIN_INPUT;
import static com.lenka.view.LiteCart.PASSWORD_INPUT;


public class Login extends Page{

    public Login(WebDriver driver) {
        super(driver);
    }

    public Login navigateToLoginPage() {
        navigateTo(getProperty("base.url"));
        return this;
    }

    public Logout pressLoginButton() {
        pressTheButton(LOGIN_BUTTON);
        return new Logout(driver);
    }

    public void enterLogin(String login) {
        enterValue(login, LOGIN_INPUT);
    }

    public void enterPassword(String pass) {
        enterValue(pass, PASSWORD_INPUT);
    }

}
