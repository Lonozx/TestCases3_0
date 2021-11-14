package TestCase;

import Page.AlertPage;
import Page.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestIFrame {
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
    public void goToMainPage(){
        mainPage.getMainPage(driver);
        String currentCondition = driver.getCurrentUrl();
        String expectedCondition = "https://demoqa.com/";
        Assert.assertEquals(currentCondition, expectedCondition);
    }
    @Test
    public void goToNestedFrames(){
        mainPage.getMainPage(driver);
        alertPage.nestedFrames(driver);
//       String currentCondition = driver.findElement(By.xpath("//body[contains(text(), 'Pare')]")).getText();
//        String expectedCondition = "'Parent frame'";
//        Assert.assertEquals(currentCondition, expectedCondition);
   }
   @Test
    public void goToFramesPage(){
        alertPage.goToFrames(driver);
   }

}
