package com.solvd.laba.carina.web.nhl.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class = 'money-value']")
    private ExtendedWebElement price;
    @FindBy(xpath = ".//div[@class = 'product-card-title']")
    private ExtendedWebElement title;


    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
