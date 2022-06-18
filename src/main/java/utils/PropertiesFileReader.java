package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

    private static Properties prop = new Properties();

    public PropertiesFileReader(String fileName) {

        try {
            InputStream inputStream = new FileInputStream("src/main/resources/" + fileName);
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getChromeEdgeLang() {
        return prop.getProperty("chromeEdgeLang");
    }

    public String getHeadless() {
        return prop.getProperty("headless");
    }

    public String getFFPref() {
        return prop.getProperty("ffPref");
    }

    public String getFFLang() {
        return prop.getProperty("ffLang");
    }

    public String getTestDataExcelSheetName() {
        return prop.getProperty("testDataExcelSheetName");
    }

    public int getImplicitlyWait() {
        return Integer.valueOf(prop.getProperty("implicitlyWait"));
    }

    public String getSearchTextbox() {
        return prop.getProperty("searchTextbox");
    }

    public String getTitleLink() {
        return prop.getProperty("titleLink");
    }

    public String getSearchResult() {
        return prop.getProperty("searchResult");
    }

    public String getScrollToButton() {
        return prop.getProperty("scrollToButton");
    }

    public String getPageNumberLink(int pageNumber) {
        String str = prop.getProperty("pageNumberLink");
        return str.replace("2", String.valueOf(pageNumber));
    }

    public String getPageNumberText() {
        return prop.getProperty("pageNumberText");
    }

    public String getRemoteLocalhost() {
        return prop.getProperty("remoteLocalhost");
    }
}