package com.lenka.search;

import com.lenka.TestCase;
import com.lenka.pages.Search;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.lenka.service.PropertiesController.getProperty;
import static com.lenka.view.LiteCart.SEARCH_RESULTS_HEADER;
import static com.lenka.view.LiteCart.SEARCH_RESULTS_WITHOUT_SALE;

public class SearchHappyPath extends TestCase {

    private final static String SEARCH_KWD_1 = getProperty("search.keyword.1");
    private final static String SEARCH_KWD_2 = getProperty("search.keyword.2");

    private Search searchPage;

    @BeforeMethod
    public void setUpTest() {
        log.info("TEST STARTS ");
    }

    @Test
    public void testEnteringSearchQueryWithSeveralResults() {
        searchPage = new Search(driver);
        searchPage.navigateToSearchPage();
        searchPage.enterSearchKeyword(SEARCH_KWD_1);
        searchPage.pressEnterToSearch();
        pause(2);

        Assert.assertTrue(assertTextOfElementsEqual(getProperty("search.header.1"), SEARCH_RESULTS_HEADER));
        Assert.assertTrue(assertElementPresent(SEARCH_RESULTS_WITHOUT_SALE));
    }

    @Test
    public void testEnteringSearchQueryWithoutResults() {
        searchPage = new Search(driver);
        searchPage.navigateToSearchPage();
        searchPage.enterSearchKeyword(SEARCH_KWD_2);
        searchPage.pressEnterToSearch();
        pause(2);

        Assert.assertTrue(assertTextOfElementsEqual(getProperty("search.header.2"), SEARCH_RESULTS_HEADER));
        Assert.assertTrue(assertElementNotPresent(SEARCH_RESULTS_WITHOUT_SALE));
    }

    @AfterMethod
    public void logOut() {
        log.info("TEST ENDS ");
    }
}
