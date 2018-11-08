package com.lenka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;

import static com.lenka.service.LogFormatter.setUpLogger;
import static com.lenka.service.PropertiesController.getProperty;
import static com.lenka.view.LiteCart.LOGIN_BUTTON;
import static com.lenka.view.LiteCart.LOGIN_INPUT;
import static com.lenka.view.LiteCart.PASSWORD_INPUT;


public class Login extends Page{

    public Login(WebDriver driver) {
        super(driver);
    }

    public Login navigateToLoginPage() {
        driver.navigate().to(getProperty("base.url"));
        log.info("Navigating to Login Page");
        return this;
    }

    public Logout pressLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGIN_BUTTON.getLocator())));
        driver.findElement(By.xpath(LOGIN_BUTTON.getLocator())).click();
        log.info("Pressing "+LOGIN_BUTTON.getDescription());
        return new Logout(driver);
    }

    public void enterLogin(String login) {
        driver.findElement(By.xpath(LOGIN_INPUT.getLocator())).clear();
        driver.findElement(By.xpath(LOGIN_INPUT.getLocator())).sendKeys(login);
        log.info("Entering email *"+login+"* on login page into "+LOGIN_INPUT.getDescription());
    }

    public void enterPassword(String pass) {
        driver.findElement(By.xpath(PASSWORD_INPUT.getLocator())).clear();
        driver.findElement(By.xpath(PASSWORD_INPUT.getLocator())).sendKeys(pass);
        log.info("Entering password *"+pass+"* on login page into "+LOGIN_INPUT.getDescription());
    }

}
