package com.lenka.view;

public enum LiteCart implements Locator {

    LOGIN_INPUT("Login input field on main page", "//input[@name='email']"),
    LOGIN_BUTTON("Login button on main page", "//button[@name='login']"),
    PASSWORD_INPUT("Password input field on main page", "//input[@name='password']"),
    LOGIN_HEADER("Login section header on main page", "//div[@id='box-account-login']//h3"),
    CREATE_ACCOUNT_LINK("Create account on login section", "//form//a[contains(@href, 'create_account')]"),
    FORGOT_PASSWORD_BUTTON("Forgot password button on main page", "//button[@name='lost_password']"),
    LOGIN_ERROR_MSG("Error msg","//div[@class='notice errors']"),

    //ACCOUNT BLOCK
    LOGOUT_LINK("Logout link on account block", "//div[@id='box-account']//a[contains(@href, 'logout')]"),

    //SEARCH RESULTS
    SEARCH_INPUT("Search input", "//input[@name='query']"),
    SEARCH_RESULTS_WITHOUT_SALE("Search result tiles without sale label", "//li/a[@class='link' and not(div[@class='image-wrapper']/div[@class='sticker sale'])]"),
    SEARCH_RESULTS_HEADER("Search result tittle", "//h1"),


    ;

    private final String xpath;
    private final String description;

    LiteCart(final String description, final String xpath) {
        this.description = description;
        this.xpath = xpath;
    }

    public String getDescription() {
        return this.description;
    }
    public String getLocator() {
        return this.xpath;
    }

}
