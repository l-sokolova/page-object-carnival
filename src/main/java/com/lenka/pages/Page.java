package com.lenka.pages;

import com.lenka.view.Locator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import org.slf4j.Logger;

public abstract class Page {

    protected final WebDriver driver;
    protected static Logger log = LoggerFactory.getLogger(Page.class);

    protected void navigateTo(String pageUrl) {
        driver.navigate().to(pageUrl);
        log.info("Navigating to " + pageUrl);
    }

    protected void pressTheButton(Locator button) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(button.getLocator())));
        driver.findElement(By.xpath(button.getLocator())).click();
        log.info("Pressing "+button.getDescription()+ " \nX-path: " + button.getLocator());
    }

    protected void enterValue(String value, Locator field) {
        driver.findElement(By.xpath(field.getLocator())).clear();
        driver.findElement(By.xpath(field.getLocator())).sendKeys(value);
        log.info("Entering *"+value+"* on into "+field.getDescription()+ " \nX-path: " + field.getLocator());
    }

    protected void pressEnter(Locator field) {
        driver.findElement(By.xpath(field.getLocator())).sendKeys(Keys.ENTER);
        log.info("Pressing Enter . . .");
    }

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void switchToTab(int tabNumber) {
        log.info("Switching to tab #"+tabNumber);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

}
