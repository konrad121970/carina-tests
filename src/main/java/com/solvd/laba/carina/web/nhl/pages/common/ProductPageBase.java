package com.solvd.laba.carina.web.nhl.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPageBase extends AbstractPage {
    @FindBy(xpath = "//div[@class = 'product-title-container']/h1")
    private ExtendedWebElement productTitle;

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public String getProductTitleText() {
        return productTitle.getText();
    }
}
