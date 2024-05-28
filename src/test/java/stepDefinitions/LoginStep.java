package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.user.LoginPage;
import stepDefinitions.Hooks;
import org.junit.jupiter.api.Assertions;
import utils.PropertiesReader;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStep {
    LoginPage loginPage;

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public LoginStep() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(propertiesReader.getTimeout()));
        loginPage = new LoginPage(driver, wait);
    }

    @Given("User access Home Page by URL")
    public void userAccessHomePageViaUrl(){loginPage.goToPageByUrl(loginPage.getHomeUrl());}

    @Then("User is navigated to Login Page")
    public void userIsNavigatedToLoginPage(){assertTrue(loginPage.isSameLink(loginPage.getLoginUrl()));}
}
