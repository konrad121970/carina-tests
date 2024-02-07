package com.solvd.laba.carina.web.nhl;

import com.solvd.laba.carina.web.nhl.components.navbar.MenuItem;
import com.solvd.laba.carina.web.nhl.components.searchbar.SearchBar;
import com.solvd.laba.carina.web.nhl.components.searchresult.SearchResult;
import com.solvd.laba.carina.web.nhl.pages.HomePage;
import com.solvd.laba.carina.web.nhl.pages.SearchPage;
import com.solvd.laba.carina.web.nhl.pages.StatsPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

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
                .filter(item -> item.getText().equals("Stats"))
                .findFirst()
                .orElse(null);

        assertNotNull(menuItem, "There must be 'Stats' menu item present");
        StatsPage statsPage =  menuItem.clickMenuItem(StatsPage.class);
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
        System.out.println();
    }


}
