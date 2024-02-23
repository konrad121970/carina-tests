package com.solvd.laba.carina.web.nhl.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPageBase extends AbstractPage {
    @FindBy(xpath = "//div[@class = 'product-title-container']/h1")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//span[@class = 'money-value']")
    private ExtendedWebElement productPrice;

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public String getProductTitleText() {
        return productTitle.getText();
    }


    public double getPriceValue() {
        String priceText = productPrice.getText();
        String[] price = priceText.split("\n"); // Split by endline
        price[0] = price[0].substring(1); // Get rid of '$'

        return Double.parseDouble(price[0]);
    }
}
