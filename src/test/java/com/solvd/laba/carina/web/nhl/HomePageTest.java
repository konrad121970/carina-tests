package com.solvd.laba.carina.web.nhl;

import com.solvd.laba.carina.web.nhl.components.ProductCard;
import com.solvd.laba.carina.web.nhl.components.footer.Footer;
import com.solvd.laba.carina.web.nhl.components.header.Header;
import com.solvd.laba.carina.web.nhl.components.loginbox.LogInBox;
import com.solvd.laba.carina.web.nhl.components.navbar.MenuItem;
import com.solvd.laba.carina.web.nhl.components.navbar.SecondaryNavBar;
import com.solvd.laba.carina.web.nhl.components.searchbar.SearchBar;
import com.solvd.laba.carina.web.nhl.components.searchresult.SearchResult;
import com.solvd.laba.carina.web.nhl.enums.FooterOptions;
import com.solvd.laba.carina.web.nhl.enums.MenuOptions;
import com.solvd.laba.carina.web.nhl.enums.ShopDropdownItems;
import com.solvd.laba.carina.web.nhl.enums.URLs;
import com.solvd.laba.carina.web.nhl.pages.common.HomePageBase;
import com.solvd.laba.carina.web.nhl.pages.common.InfoPageBase;
import com.solvd.laba.carina.web.nhl.pages.common.ProductPageBase;
import com.solvd.laba.carina.web.nhl.pages.common.ShopPageBase;
import com.solvd.laba.carina.web.nhl.pages.desktop.LogInPage;
import com.solvd.laba.carina.web.nhl.pages.desktop.SearchPage;
import com.solvd.laba.carina.web.nhl.pages.desktop.StatsPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.*;

public class HomePageTest extends AbstractTest {

    @Test
    public void verifyNavigateToStatsPageTest() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();
        page.closeModalIfPresent();

        assertTrue(page.isPageOpened(), "Page should be opened");
        sa.assertEquals(page.getTitle(), "Official Site of the National Hockey League | NHL.com", "Page title should be as expected");
        sa.assertAll();

        page.getHeader().clickMenuItem(MenuOptions.STATS);

        StatsPage statsPage = new StatsPage(driver);
        sa.assertEquals(statsPage.getTitle(), "NHL Stats | NHL.com", "Title of the stats page should be as expected.");
        sa.assertAll();

        assertEquals(statsPage.getMainHeadingText(), "Statistics", "Main heading text should be 'Statistics'");

    }

    @Test
    public void verifySearchTextTest() {
        String searchPhrase = "hi";

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();
        page.closeModalIfPresent();

        assertTrue(page.getHeader().isSearchButtonPresent(), "Search button must be present");
        SearchPage searchPage = page.getHeader().clickSearchButton();

        SearchBar searchBar = searchPage.getSearchBar();
        assertTrue(searchBar.getTextInput().isElementPresent(1), "Search input field should be present");

        sa.assertEquals(searchBar.getTextInputPlaceholder(), "Search", "Search input placeholder is incorrect");
        sa.assertAll();

        assertTrue(searchBar.getSearchButton().isElementPresent(1), "Search button must be present");

        searchBar.inputSearchQuery(searchPhrase);
        searchBar.clickSearchButton();

        List<SearchResult> searchResults = searchPage.getSearchResult();
        sa.assertTrue(searchResults.size() > 3, "There should be more than 3 results");

        searchResults.forEach(result -> {
            sa.assertTrue(result.getHeading().isElementPresent(), "Each of the search result heading should exist");
            sa.assertTrue(result.getDescription().isElementPresent(), "Each of the search result description should exist");
        });

        sa.assertAll();
    }

    @Test
    public void verifyYoutubeSocialMediaButtonRedirectTest() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();
        page.closeModalIfPresent();

        Footer footer = page.getFooter();
        List<MenuItem> socialMenuItems = footer.getSocial();
        sa.assertTrue(socialMenuItems.size() == 8, "There should be eight social accounts present");
        assertEquals(socialMenuItems.get(0).getTextElement().getAttribute("href"), "https://www.youtube.com/nhl", "First link should redirect to NHL's Youtube account");

        socialMenuItems.get(0).getTextElement().hover(); // Hover over the image of social media
        socialMenuItems.get(0).getTextElement().click(); // and click it

        //TODO: check if youtube app is opened on mobile device
//        if(isDeviceMobile(driver)){
//            contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
//            wait.until(ExpectedConditions.visibilityOf(page.getCloseWidget()));
//            page.clickCloseWidget();
//            contextHelper.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
//
//            Actions actions = new Actions(driver);
//            actions.scrollByAmount(0,20000);
//            actions.perform();
//        }

        assertTrue(page.getCurrentUrl().contains("youtube"), "Button should redirect to youtube's site");
        // assertTrue(page.getCurrentUrl().contains("/nhl")); // hard to implement bypassing cookies check

        sa.assertAll();
    }

    @Test
    public void verifyTermsOfServiceRedirectTest() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();
        page.closeModalIfPresent();

        Footer footer = page.getFooter();
        List<MenuItem> mainFooterItems = footer.getMainItems();
        sa.assertTrue(mainFooterItems.size() == 8, "There should be eight main links in footer");

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 30000);
        actions.perform();

        InfoPageBase infoPage = initPage(driver, footer.clickFooterItemAndReturnPage(FooterOptions.TERMS_OF_SERVICE).getClass());

        assertTrue(infoPage.getCurrentUrl().contains("/info/terms-of-service"), "Opened page should have correct URL");
        assertEquals(infoPage.getMainHeading().getText().toLowerCase(), "terms of service");

        sa.assertAll();
    }

    @Test
    public void verifyOpenNhlShopPageTest() {
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();

        Header header = page.getHeader();
        SecondaryNavBar secondaryNavBar = header.getSecondaryNavBar();

//        if (secondaryNavBar.isHamburgerMenuButtonPresent()) {
//            secondaryNavBar.hoverHamburgerMenu();
//            secondaryNavBar.clickHamburgerMenu();
//        }

        header.clickMenuItem(MenuOptions.SHOP);

//        assertNotNull(shopMenu, "'Shop' menu option should exist");
//        shopMenu.click();

//        List<MenuItem> shopMenuItems = secondaryNavBar.getShopDropdownMenu();
//        MenuItem nhlShopItem = shopMenuItems.stream()
//                .filter(item -> item.getTextValue().equals("NHL Shop"))
//                .findFirst()
//                .orElse(null);

        secondaryNavBar.clickShopDropdownItem(ShopDropdownItems.NHL_SHOP);

//        assertNotNull(nhlShopItem, "'NHL Shop' item should be present on the dropdown list");
//        nhlShopItem.click();

        assertTrue(page.getCurrentUrl().contains("shop.international.nhl.com"), "Page URL should match with expected.");

    }

    @Test
    public void verifyChangeLanguageToFrenchTest() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();
        page.closeModalIfPresent();

        Header header = page.getHeader();


//        if (header.getSecondaryNavBar().isHamburgerMenuButtonPresent()) {
//            header.getSecondaryNavBar().clickHamburgerMenu();
//
//            Actions actions = new Actions(driver);
//            actions.scrollByAmount(0, 100);
//            actions.perform();
//        }

        assertTrue(header.isLanguageButtonPresent(), "Change language button must be present");

        header.clickLanguageButton();

        List<MenuItem> languageOptionsList = header.getLanguageOptionsList();
        languageOptionsList.forEach(option -> {
            sa.assertTrue(option.getTextElement().isElementPresent(), "Each of the language options should be present");
        });
        sa.assertAll();

        MenuItem frenchLanguage = languageOptionsList.stream()
                .filter(option -> option.getTextValue()
                        .equals("Français"))
                .findFirst()
                .orElse(null);

        assertNotNull(frenchLanguage, "French language should be on the language options menu");
        frenchLanguage.click();

        assertEquals(page.getTopStoriesHeading().getText(), "Nouvelles récentes", "Top stories heading should match with expected one.");
    }

    @Test
    public void verifyPressLoginButtonWithoutCredentialsTest() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();
        page.closeModalIfPresent();

        Header header = page.getHeader();


        if (header.getSecondaryNavBar().isHamburgerMenuButtonPresent()) {
            header.getSecondaryNavBar().clickHamburgerMenu();

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 100);
            actions.perform();
        }

        assertTrue(header.isSignInButtonPresent(), "Sign In button should be present.");

        LogInPage logInPage = header.clickSignInButton();
        LogInBox logInBox = logInPage.getLogInBox();

        sa.assertEquals(logInBox.getMainHeading().getText(), "Welcome!", "LogIn box should main heading should contain expected value.");
        sa.assertEquals(logInBox.getSecondaryHeading().getText(), "Please sign in", "LogIn box should secondary heading should contain expected value.");

        sa.assertEquals(logInBox.getEmailInput().getAttribute("placeholder"), "Email Address", "Email input field should contain expected placeholder.");
        sa.assertEquals(logInBox.getPasswordInput().getAttribute("placeholder"), "Password", "Password input field should contain expected placeholder.");

        logInBox.clickSignInButton();

        assertEquals(logInBox.getEmailErrorMessage().getText(), "Field is required.", "Email validation message should match the expected.");
        assertEquals(logInBox.getPasswordErrorMessage().getText(), "Field is required.", "Password validation message should match the expected.");

        sa.assertAll();
    }

    @Test
    public void verifyPressLoginButtonWithTooShortPasswordTest() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();

        Header header = page.getHeader();

        page.closeModalIfPresent();

        if (header.getSecondaryNavBar().isHamburgerMenuButtonPresent()) {
            header.getSecondaryNavBar().clickHamburgerMenu();

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 100);
            actions.perform();
        }

        assertTrue(header.isSignInButtonPresent(), "Sign In button should be present.");
        LogInPage logInPage = header.clickSignInButton();
        LogInBox logInBox = logInPage.getLogInBox();

        sa.assertEquals(logInBox.getMainHeading().getText(), "Welcome!", "LogIn box should main heading should contain expected value.");
        sa.assertEquals(logInBox.getSecondaryHeading().getText(), "Please sign in", "LogIn box should secondary heading should contain expected value.");

        sa.assertEquals(logInBox.getEmailInput().getAttribute("placeholder"), "Email Address", "Email input field should contain expected placeholder.");
        sa.assertEquals(logInBox.getPasswordInput().getAttribute("placeholder"), "Password", "Password input field should contain expected placeholder.");

        logInBox.typeEmailInput("konrad@moreno.com");
        logInBox.typePasswordInput("abc");
        logInBox.clickSignInButton();

        assertEquals(logInBox.getPasswordErrorMessage().getText(), "Password must be at least 8 characters long.", "Password validation message should match the expected.");
        sa.assertAll();
    }

    @Test
    public void verifyPressLoginButtonWithInvalidCredentials() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();

        Header header = page.getHeader();

        page.closeModalIfPresent();

        if (header.getSecondaryNavBar().isHamburgerMenuButtonPresent()) {
            header.getSecondaryNavBar().clickHamburgerMenu();

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 100);
            actions.perform();
        }

        assertTrue(header.isSignInButtonPresent(), "Sign In button should be present.");
        LogInPage logInPage = header.clickSignInButton();
        LogInBox logInBox = logInPage.getLogInBox();

        sa.assertEquals(logInBox.getMainHeading().getText(), "Welcome!", "LogIn box should main heading should contain expected value.");
        sa.assertEquals(logInBox.getSecondaryHeading().getText(), "Please sign in", "LogIn box should secondary heading should contain expected value.");

        sa.assertEquals(logInBox.getEmailInput().getAttribute("placeholder"), "Email Address", "Email input field should contain expected placeholder.");
        sa.assertEquals(logInBox.getPasswordInput().getAttribute("placeholder"), "Password", "Password input field should contain expected placeholder.");

        logInBox.typeEmailInput("konrad@moreno.com");
        logInBox.typePasswordInput("abcabcabc");
        logInBox.clickSignInButton();

        assertEquals(driver.findElement(By
                        .xpath("//div[contains(@class, 'essage-container')]")).getText()
                , "The account credentials you entered did not match our records. Please check to make sure you entered them correctly.");

        sa.assertAll();
    }

    @Test
    public void verifyOpenNhlShopPageAndCheckProductsLabelsTest() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();

        Header header = page.getHeader();
        SecondaryNavBar secondaryNavBar = header.getSecondaryNavBar();

        header.clickMenuItem(MenuOptions.SHOP);

        secondaryNavBar.clickShopDropdownItem(ShopDropdownItems.MEN);
        ShopPageBase shopPage = initPage(driver, ShopPageBase.class);

        assertTrue(shopPage.getCurrentUrl().contains(URLs.SHOP_MEN.getUrl()), "Shop menu item should redirect to appropriate URL");

        if (shopPage.isPopupPresent()) {
            shopPage.clickClosePopup();
        }

        List<ProductCard> productCards = shopPage.getProductCards();
        productCards.forEach(product -> {
            sa.assertTrue(product.isPricePresent(), "Each product should have price visible");
            sa.assertTrue(product.getPriceValue() > 0.0, "Each price should be higher than 0.0");

            sa.assertTrue(product.isTitlePresent(), "Title of product card should be present");
            sa.assertTrue((product.getTitleText().contains("Men's")), "Each of product title in Men's shop should contain 'Men's' word");
        });

        sa.assertAll();
    }

    @Test
    public void verifyOpenNhlShopPageAndCheckProductPageTest() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();

        Header header = page.getHeader();
        SecondaryNavBar secondaryNavBar = header.getSecondaryNavBar();

        header.clickMenuItem(MenuOptions.SHOP);

        secondaryNavBar.clickShopDropdownItem(ShopDropdownItems.MEN);
        ShopPageBase shopPage = initPage(driver, ShopPageBase.class);

        assertTrue(shopPage.getCurrentUrl().contains(URLs.SHOP_MEN.getUrl()), "Shop menu item should redirect to appropriate URL");

        if (shopPage.isPopupPresent()) {
            shopPage.clickClosePopup();
        }

        ProductCard product = shopPage.selectRandomProductCard();
        String title = product.getTitleText();
        double price = product.getPriceValue();

        product.clickProductCard();
        ProductPageBase productPage = initPage(driver, ProductPageBase.class);

        sa.assertEquals(title, productPage.getProductTitleText(), "Product titles must match each other before and after clicking certain product");
        sa.assertEquals(price, productPage.getPriceValue(), "Product prices must match each other before and after clicking certain product.");
        sa.assertAll();

    }

}
