////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.chrome.ChromeDriver;
////
////public class Test {
////    public static void main(String[] args) {
////        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
////        WebDriver driver = new ChromeDriver();
//    }
//}

import io.cucumber.core.options.Constants;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import static io.cucumber.core.options.Constants.*;

//@Suite
//@IncludeEngines("cucumber")
//@SelectDirectories("src/test/resources/features/user")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefinitions")
////@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "@Login")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Test")
//public class Test {}

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class Test {
}
