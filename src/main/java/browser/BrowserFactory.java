package browser;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertiesFileReader;

import java.net.MalformedURLException;
import java.net.URL;



public class BrowserFactory {

    private static PropertiesFileReader props = new PropertiesFileReader("config.properties");

    public static WebDriver setBrowser(WebDriver driver, String browser) throws MalformedURLException {
        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(props.getChromeEdgeLang());
                driver = new ChromeDriver(chromeOptions);
                break;

            case "chrome --headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeHeadlessOptions = new ChromeOptions();
                chromeHeadlessOptions.addArguments(props.getChromeEdgeLang());
                chromeHeadlessOptions.addArguments(props.getHeadless());
                driver = new ChromeDriver(chromeHeadlessOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(props.getChromeEdgeLang());
                driver = new EdgeDriver(edgeOptions);
                break;

            case "edge --headless":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeHeadlessOptions = new EdgeOptions();
                edgeHeadlessOptions.addArguments(props.getChromeEdgeLang());
                edgeHeadlessOptions.addArguments(props.getHeadless());
                driver = new EdgeDriver(edgeHeadlessOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference(props.getFFPref(), props.getFFLang());
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.addArguments().setProfile(profile);
                driver = new FirefoxDriver(ffOptions);
                break;

            case "firefox --headless":
                WebDriverManager.firefoxdriver().setup();
                FirefoxProfile ffProfile = new FirefoxProfile();
                ffProfile.setPreference(props.getFFPref(), props.getFFLang());
                FirefoxOptions ffHeadlessOptions = new FirefoxOptions();
                ffHeadlessOptions.addArguments().setProfile(ffProfile);
                ffHeadlessOptions.setHeadless(true);
                driver = new FirefoxDriver(ffHeadlessOptions);
                break;

            case "remote":
                WebDriverManager.firefoxdriver().setup();
                DesiredCapabilities cap=DesiredCapabilities.firefox();
                FirefoxProfile remoteProfile = new FirefoxProfile();
                remoteProfile.setPreference(props.getFFPref(), props.getFFLang());
                cap.setCapability(FirefoxDriver.PROFILE,remoteProfile);
                cap.setPlatform(Platform.WINDOWS);

                URL url=new URL(props.getRemoteLocalhost());
                driver=new RemoteWebDriver(url, cap);
                break;

            default:
                driver = null;
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}