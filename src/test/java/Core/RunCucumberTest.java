package Core;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"web"},
        plugin = "pretty")
@SpringBootTest(classes = TestApplication.class)
public class RunCucumberTest {
    @BeforeClass
    public static void setChromeDriversPath() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // chromedriver.exe is added into project folder.
    }
}
