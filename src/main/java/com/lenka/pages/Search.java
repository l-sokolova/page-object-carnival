package com.lenka.pages;

import org.openqa.selenium.WebDriver;

import static com.lenka.service.PropertiesController.getProperty;
import static com.lenka.view.LiteCart.SEARCH_INPUT;

public class Search extends Page{

    public Search(WebDriver driver) {
        super(driver);
    }

    public Search navigateToSearchPage() {
        navigateTo(getProperty("base.url"));
        return this;
    }

    public void enterSearchKeyword(String keyword) {
        enterValue(keyword, SEARCH_INPUT);
    }

    public SearchResults pressEnterToSearch() {
        pressEnter(SEARCH_INPUT);
        return new SearchResults(driver);
    }
}
