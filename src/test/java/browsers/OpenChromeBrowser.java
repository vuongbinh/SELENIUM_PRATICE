package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenChromeBrowser {

    private WebDriver driver;

    public void baseChromeTest() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        //Open page: https://the-internet.herokuapp.com/
        driver.get("https://the-internet.herokuapp.com/");
        //Maximize page
        driver.manage().window().maximize();
        //Fullscreen.
        driver.manage().window().fullscreen();
        //Viewport
        Dimension size = new Dimension(375,812);
        driver.manage().window().setSize(size);
        System.out.println(driver.getTitle());
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }
    public static void main(String[] args){
        OpenChromeBrowser test = new OpenChromeBrowser();
        test.baseChromeTest();
    }
}
