package Page;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertPage {
    BaseForm baseForm = new BaseForm("https://demoqa.com/alerts", "Alerts");
    String alertsURL = "https://demoqa.com/alerts";
    public void getToAlertPage(WebDriver driver){
        driver.get(alertsURL);
    }
    public void clickButton(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(@id, 'alertButton')]")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(alertIsPresent());
        Thread.sleep(2000);
        alert.accept();
    }
    public void oK(WebDriver driver) throws InterruptedException{


    }
}
