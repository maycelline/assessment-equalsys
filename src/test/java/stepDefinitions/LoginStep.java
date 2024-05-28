package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void userAccessHomePageViaUrl() {
        loginPage.goToPageByUrl(loginPage.getHomeUrl());
    }

    @Then("User is navigated to Login Page")
    public void userIsNavigatedToLoginPage() {
        assertTrue(loginPage.isSameLink(loginPage.getLoginUrl()));
    }

    @When("User enter email field with value {string}")
    public void userEnterEmailFieldWithValue(String email) {
        loginPage.enterEmail(loginPage.getInputEmailFieldWebElement(), email);
    }

    @And("User enter password field with value {string}")
    public void userEnterPasswordFieldWithValue(String password) {
        loginPage.enterPassword(password);
    }

    @And("User click Login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Error message about Wrong Credential shown")
    public void errorMessageAboutWrongCredentialShown() {
        assertTrue(loginPage.isErrorMessageCannotLoginShown());
    }

    @Then("Error message about Wrong Email Format shown")
    public void errorMessageAboutWrongEmailFormatShown() {
        assertTrue(loginPage.isErrorMessageEmailFormatShown(loginPage.getErrorMessageForEmailFormatWebElement()));
    }

    @Then("Error message about Empty Value shown")
    public void errorMessageAboutEmptyValueShown() {
        assertTrue(loginPage.isErrorMessageEmptyShown(loginPage.getErrorMessageForEmptyEmailWebElement(), loginPage.getErrorMessageForEmptyPasswordWebElement()));
    }

    @When("User click on Forgot Password link")
    public void userClickOnForgotPasswordLink() {
        loginPage.clickForgotPasswordLink();
    }

    @Then("User is navigated to Forgot Password page")
    public void userIsNavigatedToForgotPasswordPage() {
        assertTrue(loginPage.isSameLink(loginPage.getForgotPasswordUrl()));
    }
}
