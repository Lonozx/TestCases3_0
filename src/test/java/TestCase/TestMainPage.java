package TestCase;

import Page.AlertPage;
import Page.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;


import java.util.concurrent.TimeUnit;

public class TestMainPage {
    MainPage mainPage = new MainPage();
    AlertPage alertPage = new AlertPage();
    WebDriver driver;
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }
    @AfterTest
    public void closeDriver(){
//        logger.debug("Quitting driver");
        if(driver != null){
            driver.close();
            driver.quit();
//            logger.debug("Driver destroyed");
        }
    }
    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMainPage() {
        mainPage.getMainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        mainPage.getAlertsPage(driver);

    }
    @Test
    public void nextTime() throws InterruptedException {
        alertPage.getToAlertPage(driver);
        alertPage.clickButton(driver);
    }
//    @Test
//    public void oK(){
//        alertPage.getToAlertPage(driver);
//        alertPage.clickButton(driver);
//
//    }
}
