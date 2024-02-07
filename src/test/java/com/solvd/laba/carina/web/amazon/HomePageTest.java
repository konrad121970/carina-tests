package com.solvd.laba.carina.web.amazon;

import com.solvd.laba.carina.web.amazon.pages.HomePage;
import com.solvd.laba.carina.web.amazon.pages.SearchPage;
import com.solvd.laba.carina.web.amazon.components.ProductCard;
import com.solvd.laba.carina.web.amazon.components.SearchBar;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends AbstractTest {

    @Test
    public void verifySearchLineTest(){
        String brandName = "iPhone";

        SoftAssert sa = new SoftAssert();
        WebDriver driver =  getDriver();
        HomePage page = new HomePage(driver);

        page.open();

//        driver.navigate().refresh();
//        driver.navigate().back();

        SearchBar searchBar = page.getHeader().getSearchBar();
        sa.assertTrue(searchBar.getProductTypesSelect().isElementPresent(7), "Product type select is not present");
        Assert.assertTrue(searchBar.getTextInput().isElementPresent(7), "Serach input box is not present");
        sa.assertEquals(searchBar.getTextInputPlaceholder(), "Search Amazon", "Serach input has an incorrect placeholder");
        Assert.assertTrue(searchBar.getSearchButton().isElementPresent(7), "Serach button is not present");

        searchBar.typeSearcInputValue(brandName);
        SearchPage searchPage = searchBar.clickSearchButton();

        sa.assertTrue(driver.getCurrentUrl().toLowerCase().contains(brandName.toLowerCase()), "Url doesn't contain the brand name");

        List<ProductCard> cards = searchPage.getCards();
        cards.forEach(productCard -> {
            sa.assertTrue(productCard.getTitleText().toLowerCase().contains(brandName.toLowerCase()), String.format("Product with name {} doesn't contain the brand name in its title", productCard.getTitleText()));
        });

        sa.assertAll();



    }

}
