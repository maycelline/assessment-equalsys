package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.user.ForgotPasswordPage;
import pageObjects.user.LoginPage;
import utils.PropertiesReader;

import java.time.Duration;

public class ForgotPasswordStep {
    ForgotPasswordPage forgotPasswordPage;
    LoginPage loginPage;

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public ForgotPasswordStep() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(propertiesReader.getTimeout()));
        forgotPasswordPage = new ForgotPasswordPage(driver, wait);
    }

    @Given("User access Forgot Password page by URL")
    public void userAccessForgotPasswordPageViaUrl() {
        forgotPasswordPage.goToPageByUrl(forgotPasswordPage.getForgotPasswordUrl());
    }

    @When("User enter email field with value {string} in Forgot Password page")
    public void userEnterEmailFieldWithValueInForgotPasswordPage(String email) {
        forgotPasswordPage.inputField(forgotPasswordPage.getInputEmailFieldWebElement(), email);
    }

    @Then("Error message about Empty Value in Forgot Password page shown")
    public void errorMessageAboutEmptyValueInForgotPasswordPageShown() {
        forgotPasswordPage.isErrorMessageEmptyShown(forgotPasswordPage.getErrorMessageForEmptyEmailWebElement(), forgotPasswordPage.getErrorMessageForEmptyEmailWebElement());
    }

    @And("User check captcha box")
    public void userCheckCaptchaBox() {
        forgotPasswordPage.checkCapthaBox();
    }

    @And("User click Submit button")
    public void userClickSubmitButton() {
        forgotPasswordPage.clickSubmitButton();
    }

    @Then("Error message shown that email is not registered")
    public void errorMessageShownThatEmailIsNotRegistered() {
        loginPage.isErrorMessageCannotLoginShown();
    }
}
