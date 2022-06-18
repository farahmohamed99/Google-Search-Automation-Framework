package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotTaker {

    public static String getScreenshot(WebDriver driver)
    {
        TakesScreenshot ts = (TakesScreenshot) driver;

        File src =ts.getScreenshotAs(OutputType.FILE);
        String path = "screenshots/Screenshot"+System.currentTimeMillis()+".png";
        File destination=new File("output/"+path);
        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return path;
    }
}
