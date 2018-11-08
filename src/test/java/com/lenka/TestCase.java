package com.lenka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.lenka.view.Locator;
import java.util.List;
import org.slf4j.Logger;


public abstract class TestCase {

    protected static Logger log = LoggerFactory.getLogger(TestCase.class);
    protected WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp(){
       // setUpLogger(log);
        driver.manage().window().maximize();
        log.info("Browser is opened");
    }

    @AfterTest
    public void tearDown() {
        log.info("Closing browser");
        driver.quit();
    }

    protected WebDriver getBrowser() {
        return driver;
    }


    protected Boolean assertElementNotPresent(Locator element) throws IllegalArgumentException {
        List<WebElement> sizeElement = driver.findElements(By.xpath(element.getLocator()));
        if (sizeElement.size() == 0) {
            log.info("Element " + element + " is not displayed as expected");
            return true;
        } else {
            log.error("Element " + element + " is displayed");
            return false;
        }
    }

    protected Boolean assertElementPresent(Locator element) throws IllegalArgumentException {
        List<WebElement> sizeElement = driver.findElements(By.xpath(element.getLocator()));
        if (sizeElement.size() != 0) {
            log.info("Element *" + element + "* is displayed as expected");
            return true;
        } else {
            log.error("Element *" + element + "* is not displayed");
            return false;
        }
    }

    protected Boolean assertTextOfElementsEqual(String expected, Locator actual) throws IllegalArgumentException {
        String actualText = driver.findElement(By.xpath(actual.getLocator())).getText();
        if (actualText.equals(expected)) {
            log.info("Element's *"+ actual +"* text is displayed as expected");
            return true;
        } else {
            log.error("Element's *"+ actual +"* text does not match with" + "*" + expected + "*. \n Actual text: "
                    + actualText);
            return false;
        }
    }

    protected void pause(int seconds) {
        int milliseconds = seconds*1000;
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

}
