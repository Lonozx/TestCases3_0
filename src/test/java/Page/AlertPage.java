package Page;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertPage {
    BaseForm baseForm = new BaseForm("//div[contains(text(), 'Alerts')]", "https://demoqa.com/alertsWindows");
    String alertsURL = "https://demoqa.com/alerts";
    public void getToAlertPage(WebDriver driver){
        driver.get(alertsURL);
    }
    public void clickButton(WebDriver driver){
        driver.findElement(By.xpath("//button[contains(@id, 'alertButton')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }
    public void confirmButton(WebDriver driver){
        driver.findElement(By.xpath("//button[contains(@id, 'confirm')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }
    public void promptButton(WebDriver driver){
        driver.findElement(By.xpath("//button[contains(@id, 'promtButton')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }
    public void nestedFrames(WebDriver driver){
        driver.findElement(By.xpath("//h5[contains(text(), 'Alerts')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Nested Frames')]")).click();
    }
    public void goToFrames(WebDriver driver){
        driver.get("https://demoqa.com/nestedframes");
        driver.findElement(By.xpath("//li[contains(@id, 'item-2')]//span[contains(text(), 'Frames')]")).click();
    }
}
