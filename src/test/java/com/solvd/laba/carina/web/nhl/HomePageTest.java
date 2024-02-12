package com.solvd.laba.carina.web.nhl;

import com.solvd.laba.carina.web.nhl.components.footer.Footer;
import com.solvd.laba.carina.web.nhl.components.header.Header;
import com.solvd.laba.carina.web.nhl.components.loginbox.LogInBox;
import com.solvd.laba.carina.web.nhl.components.navbar.MenuItem;
import com.solvd.laba.carina.web.nhl.components.navbar.SecondaryNavBar;
import com.solvd.laba.carina.web.nhl.components.searchbar.SearchBar;
import com.solvd.laba.carina.web.nhl.components.searchresult.SearchResult;
import com.solvd.laba.carina.web.nhl.pages.common.HomePageBase;
import com.solvd.laba.carina.web.nhl.pages.desktop.InfoPage;
import com.solvd.laba.carina.web.nhl.pages.desktop.LogInPage;
import com.solvd.laba.carina.web.nhl.pages.desktop.SearchPage;
import com.solvd.laba.carina.web.nhl.pages.desktop.StatsPage;
import com.solvd.laba.carina.web.utils.DeviceUtils;
import com.solvd.laba.carina.web.utils.MobileContextUtils;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class HomePageTest extends AbstractTest implements DeviceUtils {


    @Test
    public void verifyNavigateToStatsPageTest(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver =  getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();
        assertTrue(page.isPageOpened(), "Page should be opened");
        sa.assertEquals(page.getTitle(), "Official Site of the National Hockey League | NHL.com", "Page title should be as expected");
        sa.assertAll();

        List<MenuItem> list = page.getHeader().getSecondaryNavBar().getMenuItems();

        MenuItem menuItem = list.stream()
                .filter(item -> item.getTextValue().equals("Stats"))
                .findFirst()
                .orElse(null);

        if(menuItem == null){
            page.clickHamburgerMenu();

            list = page.getHeader().getSecondaryNavBar().getMenuItems();
            menuItem = list.stream()
                    .filter(item -> item.getTextValue().equals("Stats"))
                    .findFirst()
                    .orElse(null);
        }

        assertNotNull(menuItem, "There must be 'Stats' menu item present");
        StatsPage statsPage =  menuItem.clickAndReturnNewPage(StatsPage.class);
        sa.assertEquals(statsPage.getTitle(), "NHL Stats | NHL.com", "Title of the stats page should be as expected.");
        sa.assertAll();

        assertEquals(statsPage.getMainHeadingText(), "Statistics", "Main heading text should be 'Statistics'");

    }

    @Test
    public void verifySearchTextTest(){
        String searchPhrase = "hi";

        SoftAssert sa = new SoftAssert();
        WebDriver driver =  getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();

        assertTrue(page.getHeader().getSearchButton().isElementPresent(1), "Search button must be present");
        SearchPage searchPage = page.getHeader().clickSearchButton();

        SearchBar searchBar = searchPage.getSearchBar();
        assertTrue(searchBar.getTextInput().isElementPresent(1), "Search input field should be present");

        sa.assertEquals(searchBar.getTextInputPlaceholder(), "Search", "Search input placeholder is incorrect");
        sa.assertAll();

        assertTrue(searchBar.getSearchButton().isElementPresent(1), "Search button must be present");

        searchBar.inputSearchQuery(searchPhrase);
        searchBar.clickSearchButton();

        List<SearchResult> searchResults = searchPage.getSearchResult();
        sa.assertTrue( searchResults.size() > 3, "There should be more than 3 results");

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        MobileContextUtils contextHelper = new MobileContextUtils();

        page.open();

        Footer footer = page.getFooter();
        List<MenuItem> socialMenuItems = footer.getSocial();
        sa.assertTrue(socialMenuItems.size() == 8, "There should be eight social accounts present");
        assertTrue(socialMenuItems.get(0).getTextElement().getAttribute("href").equals("https://www.youtube.com/nhl"), "First link should redirect to NHL's Youtube account");

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
    public void verifyTermsOfServiceRedirectTest(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver =  getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        MobileContextUtils contextHelper = new MobileContextUtils();

        page.open();

        if(isDeviceMobile(driver)){
            contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
            wait.until(ExpectedConditions.visibilityOf(page.getCloseWidget()));
            page.clickCloseWidget();
            contextHelper.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0,20000);
            actions.perform();
        }

        Footer footer = page.getFooter();
        List<MenuItem> mainFooterItems = footer.getMainItems();
        sa.assertTrue(mainFooterItems.size() == 8, "There should be eight main links in footer");
        MenuItem menuItem = mainFooterItems.stream()
                .filter(menuItem1 -> menuItem1.getTextValue().contains("Terms of Service"))
                .findFirst()
                .orElse(null);

        assertNotNull(menuItem, "There should be 'Terms of Service' footer item present");
        menuItem.getTextElement().hover();
        InfoPage infoPage =  menuItem.clickAndReturnNewPage(InfoPage.class);

        assertTrue(infoPage.getCurrentUrl().contains("/info/terms-of-service"), "Opened page should have correct URL");
        assertEquals(infoPage.getMainHeading().getText().toLowerCase(), "terms of service");

        sa.assertAll();
    }

    @Test
    public void verifyOpenNhlShopPageTest(){
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);

        page.open();

        Header header = page.getHeader();
        SecondaryNavBar secondaryNavBar = header.getSecondaryNavBar();

        if(page.isHamburgerMenuButtonPresent()){
            page.hoverHamburgerMenu();
            page.clickHamburgerMenu();
        }

        List<MenuItem> navItems = secondaryNavBar.getMenuItems();
        MenuItem shopMenu =  navItems.stream().filter(item -> item.getTextValue()
                                         .equals("Shop"))
                                         .findFirst()
                                         .orElse(null);

        assertNotNull(shopMenu, "'Shop' menu option should exist");
        shopMenu.click();

        List<MenuItem> shopMenuItems = secondaryNavBar.getShopDropdownMenu();
        MenuItem nhlShopItem = shopMenuItems.stream()
                .filter(item -> item.getTextValue().equals("NHL Shop"))
                .findFirst()
                .orElse(null);

        assertNotNull(nhlShopItem, "'NHL Shop' item should be present on the dropdown list");
        nhlShopItem.click();
        assertTrue(page.getCurrentUrl().contains("shop.international.nhl.com"), "Page URL should match with expected.");

    }

    @Test
    public void verifyChangeLanguageToFrenchTest(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        MobileContextUtils contextHelper = new MobileContextUtils();

        page.open();

        Header header = page.getHeader();

        if(isDeviceMobile(driver)){
            contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
            wait.until(ExpectedConditions.visibilityOf(page.getCloseWidget()));
            page.clickCloseWidget();
            contextHelper.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
        }

        if(page.isHamburgerMenuButtonPresent()){
            page.hoverHamburgerMenu();
            page.clickHamburgerMenu();

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0,100);
            actions.perform();
        }

        assertTrue(header.isLanguageButtonPresent(), "Change language button must be present");

        header.clickLanguageButton();

        List<MenuItem> languageOptionsList = header.getLanguageOptions().getLanguageOptionsList();
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
    public void verifyPressLoginButtonWithoutCredentialsTest(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        MobileContextUtils contextHelper = new MobileContextUtils();

        page.open();

        Header header = page.getHeader();

        if(isDeviceMobile(driver)){
            contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
            wait.until(ExpectedConditions.visibilityOf(page.getCloseWidget()));
            page.clickCloseWidget();
            contextHelper.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
        }

        if(page.isHamburgerMenuButtonPresent()){
            page.clickHamburgerMenu();

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0,100);
            actions.perform();
        }

        assertTrue(header.getSignInButton().isElementPresent(),"Sign In button should be present.");

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
    public void verifyPressLoginButtonWithTooShortPasswordTest(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        MobileContextUtils contextHelper = new MobileContextUtils();

        page.open();

        Header header = page.getHeader();

        if(isDeviceMobile(driver)){
            contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
            wait.until(ExpectedConditions.visibilityOf(page.getCloseWidget()));
            page.clickCloseWidget();
            contextHelper.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
        }

        if(page.isHamburgerMenuButtonPresent()){
            page.clickHamburgerMenu();

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0,100);
            actions.perform();
        }

        assertTrue(header.getSignInButton().isElementPresent(),"Sign In button should be present.");
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
        // //div[contains(@class, 'essage-container')]
        sa.assertAll();
    }

    @Test
    public void verifyPressLoginButtonWithInvalidCredentials(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePageBase page = initPage(driver, HomePageBase.class);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        MobileContextUtils contextHelper = new MobileContextUtils();

        page.open();

        Header header = page.getHeader();

        if(isDeviceMobile(driver)){
            contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
            wait.until(ExpectedConditions.visibilityOf(page.getCloseWidget()));
            page.clickCloseWidget();
            contextHelper.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
        }

        if(page.isHamburgerMenuButtonPresent()){
            page.clickHamburgerMenu();

            Actions actions = new Actions(driver);
            actions.scrollByAmount(0,100);
            actions.perform();
        }

        assertTrue(header.getSignInButton().isElementPresent(),"Sign In button should be present.");
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
                                        ,"The account credentials you entered did not match our records. Please check to make sure you entered them correctly.");

        sa.assertAll();
    }

}
