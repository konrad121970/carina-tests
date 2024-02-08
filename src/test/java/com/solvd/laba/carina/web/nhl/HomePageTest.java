package com.solvd.laba.carina.web.nhl;

import com.solvd.laba.carina.web.nhl.components.footer.Footer;
import com.solvd.laba.carina.web.nhl.components.navbar.MenuItem;
import com.solvd.laba.carina.web.nhl.components.searchbar.SearchBar;
import com.solvd.laba.carina.web.nhl.components.searchresult.SearchResult;
import com.solvd.laba.carina.web.nhl.pages.HomePage;
import com.solvd.laba.carina.web.nhl.pages.InfoPage;
import com.solvd.laba.carina.web.nhl.pages.SearchPage;
import com.solvd.laba.carina.web.nhl.pages.StatsPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class HomePageTest extends AbstractTest {


    @Test
    public void verifyNavigateToStatsPageTest(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver =  getDriver();
        HomePage page = new HomePage(driver);

        page.open();
        assertTrue(page.isPageOpened(), "Page should be opened");
        sa.assertEquals(page.getTitle(), "Official Site of the National Hockey League | NHL.com");

        List<MenuItem> list = page.getHeader().getSecondaryNavBar().getMenuItems();
        MenuItem menuItem = list.stream()
                .filter(item -> item.getTextValue().equals("Stats"))
                .findFirst()
                .orElse(null);

        assertNotNull(menuItem, "There must be 'Stats' menu item present");
        StatsPage statsPage =  menuItem.clickMenuItemAndReturnNewPage(StatsPage.class);
        sa.assertEquals(statsPage.getTitle(), "NHL Stats | NHL.com");
        assertEquals(statsPage.getMainHeadingText(), "Statistics");

        sa.assertAll();
    }

    @Test
    public void verifySearchTextTest(){
        String searchPhrase = "NHL";

        SoftAssert sa = new SoftAssert();
        WebDriver driver =  getDriver();
        HomePage page = new HomePage(driver);

        page.open();

        assertTrue(page.getHeader().getSearchButton().isElementPresent(1), "Search button must be present");
        SearchPage searchPage = page.getHeader().clickSearchButton();

        SearchBar searchBar = searchPage.getSearchBar();
        assertTrue(searchBar.getTextInput().isElementPresent(1), "Search input field should be present");
        sa.assertEquals(searchBar.getTextInputPlaceholder(), "Search", "Search input placeholder is incorrect");
        assertTrue(searchBar.getSearchButton().isElementPresent(1), "Search button must be present");

        searchBar.inputSearchQuery(searchPhrase);
        searchBar.clickSearchButton();

        List<SearchResult> searchResults = searchPage.getSearchResult();
        sa.assertTrue( searchResults.size() > 3, "There should be more than 3 results");

//        searchResults.forEach(result -> {
//            sa.assertTrue(result.getDescription().getText().contains(searchPhrase)
//                                 || result.getHeading().getText().contains(searchPhrase), "Each of the search result description should contain the search phrase");
//        });

        sa.assertAll();
    }

    @Test
    public void verifyYoutubeSocialMediaButtonTest() {
        SoftAssert sa = new SoftAssert();
        WebDriver driver =  getDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HomePage page = new HomePage(driver);

        page.open();

        // Accept cookies to get rid of pop-up over footer
        driver.findElement(By.xpath("//*[@id = 'onetrust-accept-btn-handler']")).click();

        Footer footer = page.getFooter();
        List<MenuItem> socialMenuItems = footer.getSocial();
        sa.assertTrue(socialMenuItems.size() == 8, "There should be eight social accounts present");
        assertTrue(socialMenuItems.get(0).getTextElement().getAttribute("href").equals("https://www.youtube.com/nhl"), "First link should redirect to NHL's Youtube account");

        socialMenuItems.get(0).getTextElement().hover(); // Hover over the image of social media
        socialMenuItems.get(0).getTextElement().click(); // and click it

        assertTrue(page.getCurrentUrl().contains("youtube"), "Button should redirect to youtube's site");
        // assertTrue(page.getCurrentUrl().contains("/nhl")); // hard to implement bypassing cookies check

        sa.assertAll();
    }

    @Test
    public void verifyTermsOfServiceButtonTest(){
        SoftAssert sa = new SoftAssert();
        WebDriver driver =  getDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        HomePage page = new HomePage(driver);

        page.open();

        // Accept cookies to get rid of pop-up over footer
        driver.findElement(By.xpath("//*[@id = 'onetrust-accept-btn-handler']")).click();

        Footer footer = page.getFooter();
        List<MenuItem> mainFooterItems = footer.getMainItems();
        sa.assertTrue(mainFooterItems.size() == 8, "There should be eight main links in footer");
        MenuItem menuItem = mainFooterItems.stream()
                .filter(menuItem1 -> menuItem1.getTextValue().contains("Terms of Service"))
                .findFirst()
                .orElse(null);

        assertNotNull(menuItem, "There should be 'Terms of Service' footer item present");
        menuItem.getTextElement().hover();
        InfoPage infoPage =  menuItem.clickMenuItemAndReturnNewPage(InfoPage.class);

        assertTrue(infoPage.getCurrentUrl().contains("/info/terms-of-service"), "Opened page should have correct URL");
        assertEquals(infoPage.getMainHeading().getText().toLowerCase(), "terms of service");

        sa.assertAll();
    }


}
