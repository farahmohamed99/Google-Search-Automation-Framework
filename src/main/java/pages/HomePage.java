package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.PropertiesFileReader;

import java.util.concurrent.TimeUnit;


public class HomePage {

    private WebDriver driver;
    private PropertiesFileReader props = new PropertiesFileReader("locators.properties");
    private By searchTextbox = By.name(props.getSearchTextbox());

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public SearchPage search(String word){
        driver.findElement(searchTextbox).sendKeys(word+ Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(props.getImplicitlyWait(), TimeUnit.SECONDS);
        return new SearchPage(driver);
    }

}