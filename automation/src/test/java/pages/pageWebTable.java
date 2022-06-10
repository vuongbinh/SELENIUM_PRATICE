package pages;

import modules.webTableTest;
import objects.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class pageWebTable extends PageController {
    static List<Person> personList;
    By row = By.xpath("//table[@id='table1']/tbody/tr");

    public pageWebTable(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(row);
        personList = rows
                .stream()
                .map(webTableTest::toPerson)
                .collect(Collectors.toList());
    }

    public float getMaxDueMoney() {
        return personList.stream()
                .max(Comparator.comparing(Person::getDueMoney))
                .orElseThrow(NoSuchElementException::new).getDueMoney();
    }

    public boolean getResult(String name, float dueMoney) {
        return personList.stream()
                .filter(person -> person.getDueMoney() == dueMoney)
                .anyMatch(person -> person.getFullName().contains(name));
    }

}
