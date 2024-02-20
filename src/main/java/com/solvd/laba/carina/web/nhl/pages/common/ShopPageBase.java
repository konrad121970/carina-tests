package com.solvd.laba.carina.web.nhl.pages.common;

import com.solvd.laba.carina.web.nhl.components.ProductCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopPageBase extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'product-card row']")
    private List<ProductCard> productCards;


    public ShopPageBase(WebDriver driver) {
        super(driver);
    }
}
