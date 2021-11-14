package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {

    BaseForm baseForm = new BaseForm("//img[contains(@class, 'banner-image')]", "https://demoqa.com/");
    String mainPageURL = "https://demoqa.com/";
    String locAlert = "//h5[contains(text(), 'Alerts')]";
    //Going to main page of demoqa.com
    public void getMainPage(WebDriver driver){
        driver.get(mainPageURL);
    }
    public void getAlertsPage(WebDriver driver) {
        driver.findElement(By.xpath(locAlert)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[contains(@id, 'item-1')]//span[contains(text(), 'Alerts')]")).click();

    }

}
