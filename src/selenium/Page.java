package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Page {

    private WebDriver driver;

    public Page() {
    }

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public Page(String url) {
        driver = new FirefoxDriver();
        driver.get(url);
    }

    protected void navigateTo(String url) {
        setDriver(new FirefoxDriver());
        getDriver().get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
