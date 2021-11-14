package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseForm {
    String uniqueElement;
    String pageName;
    public BaseForm(String uniqueElement,String pageName){
        this.uniqueElement = uniqueElement;
        this.pageName = pageName;
    }
    public boolean isPageOpen(WebDriver driver){
        driver.get(pageName);
        if(driver.getTitle() != null && driver.getTitle().contains(pageName)){
           return true;
        }
        else{return false;
        }
    }
}
