package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;
import utils.Variable;

public class ForgotPasswordPage extends BaseClass {

    Variable variables = new Variable();
    private final String homeUrl = variables.getHOME_URL();
    private final String loginUrl = variables.getLOGIN_URL();
    private final String forgotPasswordUrl = variables.getFORGOT_PASSWORD();

    public ForgotPasswordPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='UserName']")
    private WebElement inputEmailField;

    @FindBy(css = "[data-fv-validator='notEmpty']")
    private WebElement errorMessageForEmptyEmail;

    @FindBy(css = "[data-fv-validator='emailAddress']")
    private WebElement errorMessageForEmailFormat;

    @FindBy(css = "[role='presentation']")
    private WebElement captchaCheckbox;

    @FindBy(css = "[class='btn btn-lg btn-primary btn-block mt20']")
    private WebElement buttonSubmit;

    public String getHomeUrl() {
        return homeUrl;
    }

    public WebElement getErrorMessageForEmptyEmailWebElement() {
        return errorMessageForEmptyEmail;
    }

    public WebElement getErrorMessageForEmailFormatWebElement() {
        return errorMessageForEmailFormat;
    }

    public WebElement getInputEmailFieldWebElement() {
        return inputEmailField;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getForgotPasswordUrl() {
        return forgotPasswordUrl;
    }

    public void checkCapthaBox() {
        customWait(3000);
        captchaCheckbox.click();
        customWait(8000);
    }

    public void inputEmail(String email) {
        customWait(3000);
        inputField(inputEmailField, email);
        randomClick();
    }

    public void clickSubmitButton() {
        customWait(3000);
        buttonSubmit.click();
    }

}
