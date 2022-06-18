# Google Search.

A selenium hybrid (modular/data driven) test automation framework for google search tests
<br>

    •	Java 11
    
    •	Selenium
   
    •	Maven
    
    •	TestNG
    
    •	Chrome,Firfox,and Edge web drivers  
    
    •	Cross browsing
    
    •	Reporting with attched screenshots on failures

# Project Structure:
  The framework is divided into 2 parts:
  - the first part is in the main which contains the logic, locators, excel file reader, properties file reader, screenshot taker, and browser factory for cross browsing.
  - The second part is the tests, data provider and the test data(testData.xlsx.)
# Test data :
  - Test data is stored in src\test\resources\testData.xlsx.
  - There are 7 testcases: testcase 1 is the happy scenario and the other are negative scenarios
# Running the tests (chrome, chrome --headless, edge, edge --headless, firefix, firefox --headless, remote):
   
   -Run the testng.xml file.
   
   -To choose the browser change its value with one of the above values in the testng.xml from the parameter tag <parameter name="browser" value="chrome"></parameter>
<br>
<br>
# After running the tests:
   -HTML report will be generated aith screenshots of the failed steps ( right-click and open with chrome browser).
   
# Selenium grid
- Set browser to "remote" in testng.xml
- Download selenium-server-standalone-3.5.3.jar
- Open CMD and navigate to the location of the jar file
- Run " java -jar selenium-server-standalone-3.5.3.jar -role hub "
- Open another CMD and run : java "-Dwebdriver.edge.driver=path\to\msedgedriver.exe" "-Dwebdriver.chrome.driver=path\to\chromedriver.exe" "-Dwebdriver.gecko.driver=path\to\geckodriver.exe" -jar "path\to\selenium-server-standalone-3.5.3.jar" -role node -nodeConfig "path\to\SeleniumAutomationTask\src\main\resources\drivers\seleniumGrid.json"
