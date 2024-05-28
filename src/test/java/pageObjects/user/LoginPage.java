package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;
import utils.Variable;

public class LoginPage extends BaseClass {
    Variable variables = new Variable();
    private String homeUrl = variables.getHOME_URL();
    private String loginUrl = variables.getLOGIN_URL();
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }
}
