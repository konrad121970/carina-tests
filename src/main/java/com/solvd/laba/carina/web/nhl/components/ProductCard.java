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

    public boolean isPricePresent() {
        return price.isElementPresent();
    }

    public boolean isTitlePresent() {
        return title.isElementPresent();
    }

    public double getPriceValue() {
        String priceText = price.getText();
        String[] price = priceText.split("\n"); // Split by endline
        price[0] = price[0].substring(1); // Get rid of '$'

        return Double.parseDouble(price[0]);
    }

    public String getTitleText() {
        return title.getText();
    }

    public void clickProductCard() {
        title.click();
    }


}
