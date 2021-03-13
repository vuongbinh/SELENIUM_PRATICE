package modules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public static void validCredentials() {
        //Step 1:
        WebDriver driver;
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        //Step 2:
        driver.get("https://the-internet.herokuapp.com/login");
        //Step 3: Fill in username with tomsmith
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Step 4: Fill in password with SuperSecretPassword!
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Step 5: Click Login button
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
        //Step 6: And homepage is appear
        String currentURL = driver.getCurrentUrl();
//        Assert.assertEquals(currentURL,"https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(currentURL.contains("/secure"));
    }
    @Test(description = "Login with invalid password")
    public static void invalidCredentials() {
        //Step 1:
        WebDriver driver;
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        //Step 2:
        driver.get("https://the-internet.herokuapp.com/login");
        //Step 3: Fill in username with tomsmith
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Step 4: Fill in password with SuperSecretPassword!
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        //Step 5: Click Login button
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
        //Step 6: And homepage is appear
        String currentURL = driver.getCurrentUrl();
//        Assert.assertEquals(currentURL,"https://the-internet.herokuapp.com/secure");
        Assert.assertFalse(currentURL.contains("/secure"));
    }
}
