package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;
import utils.Variable;

public class LoginPage extends BaseClass {
    Variable variables = new Variable();

    public WebElement getInputEmailFieldWebElement() {
        return inputEmailField;
    }

    private String homeUrl = variables.getHOME_URL();
    private String loginUrl = variables.getLOGIN_URL();
    private String forgotPasswordUrl = variables.getFORGOT_PASSWORD();

    public String getForgotPasswordUrl() {
        return forgotPasswordUrl;
    }

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    // Web Elements
    @FindBy(css = "input[name='username']")
    private WebElement inputEmailField;

    @FindBy(css = "input[name='password']")
    private WebElement inputPasswordField;

    @FindBy(css = "button[id='btnLogin']")
    private WebElement buttonLogin;

    @FindBy(css = "a[class='forgot-password']")
    private WebElement forgotPasswordLink;

    @FindBy(css = "[data-fv-validator='notEmpty']")
    private WebElement errorMessageForEmptyEmail;

    @FindBy(css = "[data-fv-for='password']")
    private WebElement errorMessageForEmptyPassword;

    @FindBy(css = "[obo-name='errorMessage']")
    private WebElement errorMessageLoginFail;

    @FindBy(css = "[data-fv-validator='emailAddress']")
    private WebElement errorMessageForEmailFormat;

    public String getHomeUrl() {
        return homeUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void clickForgotPasswordLink() {
        customWait(3000);
        forgotPasswordLink.click();
    }

    public void enterPassword(String password) {
        customWait(3000);
        waitUntilElementVisible(inputPasswordField);
        inputField(inputPasswordField, password);
        inputEmailField.click();
    }

    public void clickLoginButton() {
        customWait(3000);
        waitUntilElementVisible(buttonLogin);
        buttonLogin.click();
    }

    public WebElement getErrorMessageForEmptyEmailWebElement() {
        return errorMessageForEmptyEmail;
    }

    public WebElement getErrorMessageForEmptyPasswordWebElement() {
        return errorMessageForEmptyPassword;
    }

    public WebElement getErrorMessageForEmailFormatWebElement() {
        return errorMessageForEmailFormat;
    }

    public boolean isErrorMessageCannotLoginShown() {
        customWait(3000);
        return errorMessageLoginFail.isDisplayed();
    }
}
