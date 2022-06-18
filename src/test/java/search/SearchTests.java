package search;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SearchPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTests {


    @Test(dataProviderClass = SearchDataProvider.class, dataProvider = "getData")
    public void searchTest(String url, String title,String searchWord,String expectedSearchWord,
                               int firstPage,String	expectedFirstPage,int expectedFirstPageCount,
                               int secondPage,String expectedSecondPage)
    {
        test = extent.createTest("Google search test");
        test.log(Status.INFO,"Start test");

        driver.get(url);
        assertEquals(driver.getTitle(), title);
        test.pass("Navigate to google");

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = homePage.search(searchWord);


        String titleLinkText = searchPage.getTitleLinkText();
        assertTrue(titleLinkText.contains(expectedSearchWord));
        test.pass("Search");

        searchPage.scrollToButton();
        searchPage.navigateToPage(firstPage);
        String pageNumber = searchPage.getPageNumber();
        assertTrue(pageNumber.contains(expectedFirstPage));
        test.pass("Navigate to page 2");

        int pageTwoCount = searchPage.getResultCount();
        assertEquals(pageTwoCount,expectedFirstPageCount);
        test.pass("Verify Page count");

        searchPage.scrollToButton();
        searchPage.navigateToPage(secondPage);
        pageNumber = searchPage.getPageNumber();
        assertTrue(pageNumber.contains(expectedSecondPage));
        test.pass("Navigate to page 3");

        int pageThreeCount = searchPage.getResultCount();

        assertEquals(pageTwoCount, pageThreeCount);
        test.pass("Verify page 2 has the same number of links as page 3");
        test.info("Test Completed");
    }
}
