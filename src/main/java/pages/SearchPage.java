package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.PropertiesFileReader;

import java.util.concurrent.TimeUnit;

public class SearchPage {

    private WebDriver driver;
    private PropertiesFileReader props = new PropertiesFileReader("locators.properties");
    private By titleLink= By.cssSelector(props.getTitleLink());
    private By searchResult = By.xpath(props.getSearchResult());
    private By pageNumberText = By.id(props.getPageNumberText());

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitleLinkText(){
        return driver.findElement(titleLink).getText();
    }

    public void scrollToButton(){
        ((JavascriptExecutor)driver).executeScript(props.getScrollToButton());
    }

    public void navigateToPage(int pageNumber){
        By pageNumberLocator = By.cssSelector(props.getPageNumberLink(pageNumber));
        driver.findElement(pageNumberLocator).click();
    }

    public int getResultCount(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElements(searchResult).size();
    }

    public String getPageNumber(){
        return driver.findElement(pageNumberText).getText();
    }
}