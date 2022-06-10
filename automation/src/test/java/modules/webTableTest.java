package modules;

import objects.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.pageWebTable;

import java.util.List;

public class webTableTest extends TestController {
    public static Person toPerson(WebElement row) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        String lastName = cells.get(0).getText();
        String firstName = cells.get(1).getText();
        String email = cells.get(2).getText();
        String dueMoney = cells.get(3).getText().replace("$", "");
        String website = cells.get(4).getText();
        return new Person(firstName, lastName, email, Float.parseFloat(dueMoney), website);
    }

    @Test(dataProvider = "dataMaxDue")
    void personWhoHasMaxDue(String name, boolean expectation) {
        pageWebTable webTable = new pageWebTable(driver);
        webTable.open();
        float maxDue = webTable.getMaxDueMoney();
        Assert.assertEquals(webTable.getResult(name, maxDue), expectation);
    }

    @DataProvider
    Object[][] dataMaxDue() {
        return new Object[][]{
                new Object[]{"Jason Doe", true},
                new Object[]{"Frank Bach", false},
                new Object[]{"John Smith", false},
                new Object[]{"Tim Conway", false}
        };
    }
}
