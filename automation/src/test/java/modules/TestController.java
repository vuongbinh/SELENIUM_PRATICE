package modules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestController {
    public static WebDriver driver;

    @BeforeClass
    void setup() throws IOException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    @AfterClass(alwaysRun = true)
    void tearDown() throws IOException {
        try {
            Thread.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
