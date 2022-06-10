package pages;

import org.openqa.selenium.WebDriver;

public abstract class PageController {
    protected WebDriver driver;

    public PageController(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract void open();
}
