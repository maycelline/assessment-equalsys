package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void startWebDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void screenshotResult(Scenario scenario){
        if(scenario.isFailed()){
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Error-"+ LocalDateTime.now());
            } catch (WebDriverException noSupportScreenshot){
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        driver.quit();
    }

}
