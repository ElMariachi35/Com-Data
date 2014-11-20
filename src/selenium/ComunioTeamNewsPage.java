package selenium;

import org.openqa.selenium.WebDriver;

public class ComunioTeamNewsPage extends Page {

    public ComunioTeamNewsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageSource() {
        return getDriver().getPageSource();
    }

    public void close() {
        getDriver().close();
    }

}
