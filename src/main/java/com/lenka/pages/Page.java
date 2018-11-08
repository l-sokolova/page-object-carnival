package com.lenka.pages;

import org.openqa.selenium.*;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import org.slf4j.Logger;

public abstract class Page {

    protected final WebDriver driver;
    protected static Logger log = LoggerFactory.getLogger(Page.class);

    //protected final Logger log = Logger.getLogger(Page.class.getName());

    public Page(WebDriver driver) {
        this.driver = driver;
       // setUpLogger(log);
    }

    public static void switchToTab(int tabNumber, WebDriver driver) {
        //final Logger log = Logger.getLogger(Page.class.getName());
        //setUpLogger(log);
        log.info("Switching to tab #"+tabNumber);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

}
