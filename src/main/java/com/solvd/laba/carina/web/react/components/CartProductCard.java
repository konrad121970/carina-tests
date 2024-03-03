package com.solvd.laba.carina.web.react.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartProductCard extends AbstractUIObject {

    @FindBy(xpath = "./div[contains(@class, 'sc-11uohgb-1 buqxEg')]//p[contains(@class, 'sc-11uohgb-2')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "./div[contains(@class, 'sc-11uohgb-4 bnZqjD')]//p")
    private ExtendedWebElement price;


    public CartProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
