package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    WebDriver driver;
    WebDriverWait wait;
    private Variable variables;

    public BaseClass(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        variables = new Variable();
    }

    public void goToPageByUrl(String actualUrl){
        driver.get(actualUrl);
    }

    public boolean isSameLink(String actualUrl){
        customWait(3000);
        try {
            Thread.sleep(variables.getWAIT_DURATION());
            String url = driver.getCurrentUrl();
            if (actualUrl.equals(url)){
                return true;
            }
            System.out.println("URL is NOT MATCH");
            System.out.println("Actual Link: "+actualUrl);
            System.out.println("Link: "+url);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void waitUntilElementVisible(WebElement el){
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void customWait(int millisecond){
        try{
            Thread.sleep(millisecond);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inputField (WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public String getTextElement(WebElement element){
        customWait(500);
        return element.getText();
    }
}
