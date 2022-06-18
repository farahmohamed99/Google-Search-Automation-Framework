package base;

import browser.BrowserFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ScreenshotTaker;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTests {
    protected WebDriver driver;
    protected ExtentHtmlReporter report;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    @Parameters({"reportPath"})
    public void setUpSuite(String reportPath) {
        report = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(report);
    }
    @BeforeMethod
    @Parameters({"browser"})
    public void setUpTest(String browser) throws MalformedURLException {
        driver= BrowserFactory.setBrowser(driver,browser);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            String screenshot = ScreenshotTaker.getScreenshot(driver);
            test.fail(result.getThrowable().getMessage()).addScreenCaptureFromPath(screenshot);
        }
        driver.quit();
    }
    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }
}
