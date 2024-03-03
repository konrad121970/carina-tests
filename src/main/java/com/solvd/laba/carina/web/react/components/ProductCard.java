package com.solvd.laba.carina.web.react.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {


    @FindBy(xpath = ".//p[contains(@class, 'sc-124al1g-4')]")
    private ExtendedWebElement title;
    @FindBy(xpath = ".//p[contains(@class, 'sc-124al1g-6')]")
    private ExtendedWebElement price;

    @FindBy(xpath = "./button")
    private ExtendedWebElement addToCartButton;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitleText() {
        return title.getText();
    }

    public String getPriceText() {
        return price.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

}
