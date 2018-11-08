package com.lenka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

import static com.lenka.service.LogFormatter.setUpLogger;
import static com.lenka.view.LiteCart.LOGOUT_LINK;

public class Logout extends Page {

    public Logout(WebDriver driver) {
        super(driver);
    }

    public Login pressLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGOUT_LINK.getLocator())));
        driver.findElement(By.xpath(LOGOUT_LINK.getLocator())).click();
        log.info("Pressing "+LOGOUT_LINK.getDescription());
        return new Login(driver);
    }
}
