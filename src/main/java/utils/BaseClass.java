package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Random;

public class BaseClass {
    WebDriver driver;
    WebDriverWait wait;
    private Variable variables;

    public BaseClass(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        variables = new Variable();
    }

    public void randomClick(){
        Actions action = new Actions(driver);

        int winWidth = driver.manage().window().getSize().getWidth();
        int winHeight = driver.manage().window().getSize().getHeight();

        Random rand = new Random();
        int randX = rand.nextInt(winWidth);
        int randY = rand.nextInt(winHeight);

        action.moveByOffset(randX, randY).click();
    }

    public boolean isErrorMessageEmptyShown(WebElement elementEmail, WebElement elementPassword){
        customWait(7000);
        String errorMessageEmail = getTextElement(elementEmail);
        String errorMessagePassword = getTextElement(elementPassword);
        System.out.println("Error Message Email: "+errorMessageEmail);
        System.out.println("Error Message Password: "+errorMessagePassword);
        return errorMessageEmail.equalsIgnoreCase("required") || errorMessagePassword.equalsIgnoreCase("required");
    }

    public boolean isErrorMessageEmailFormatShown(WebElement element){
        customWait(3000);
        String errorMessage = getTextElement(element);
        return errorMessage.equalsIgnoreCase("Must be a valid email address format") || errorMessage.equalsIgnoreCase("The value is not a valid email address");
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

    public void enterEmail (WebElement element, String email) {
        customWait(3000);
        waitUntilElementVisible(element);
        inputField(element, email);
        randomClick();
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
