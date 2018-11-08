package com.lenka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.lenka.service.PropertiesController.getProperty;
import static com.lenka.view.LiteCart.SEARCH_INPUT;

public class Search extends Page{

    public Search(WebDriver driver) {
        super(driver);
    }

    public Search navigateToSearchPage() {
        driver.navigate().to(getProperty("base.url"));
        log.info("Navigating to Search Page");
        return this;
    }

    public void enterSearchKeyword(String keyword) {
        driver.findElement(By.xpath(SEARCH_INPUT.getLocator())).clear();
        driver.findElement(By.xpath(SEARCH_INPUT.getLocator())).sendKeys(keyword);
        log.info("Entering search keywords *"+keyword+"* on main page into "+SEARCH_INPUT.getDescription());

    }

    public SearchResults pressEnterToSearch() {
        driver.findElement(By.xpath(SEARCH_INPUT.getLocator())).sendKeys(Keys.ENTER);
        log.info("Pressing Enter");
        return new SearchResults(driver);
    }
}
