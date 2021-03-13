package modules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest {
    @Test
    void validationCheckboxIsCheckbox(){
        //Step 1:
        WebDriver driver;
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        //Step 2:
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Step 3: Check on “checkbox1”
        check(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")));
        //Step 4
        isSelected(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")));
        //Step 5: Check on “checkbox2”
        check(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")));
        //Step 6
        isSelected(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")));

    }
    private void check(WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }

    private void uncheck(WebElement element){
        if(element.isSelected()){
            element.click();
        }
    }
    private boolean isSelected(WebElement element){
        return element.isSelected();
    }
}
