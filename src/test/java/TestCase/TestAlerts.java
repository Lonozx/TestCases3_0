package TestCase;

import Page.AlertPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestAlerts {
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
    public void alertsPage(){
        alertPage.getToAlertPage(driver);
        alertPage.clickButton(driver);
        String currentCond = driver.getCurrentUrl();
        String expectedCond = "https://demoqa.com/alerts";
        Assert.assertEquals(currentCond, expectedCond);
    }
    @Test
    public void buttonConfirm(){
        alertPage.getToAlertPage(driver);
        alertPage.confirmButton(driver);
    }
    @Test
    public void buttonPrompt(){
        alertPage.getToAlertPage(driver);
        alertPage.promptButton(driver);
    }
}
