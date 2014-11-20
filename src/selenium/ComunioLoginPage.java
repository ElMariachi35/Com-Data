package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComunioLoginPage extends Page {
    private WebElement userNameInput;
    private WebElement passwordInput;
    private WebElement loginButton;

    public ComunioTeamNewsPage login(String userName, String password) {
        navigateTo("http://www.comunio.de");
        userNameInput = getDriver().findElement(By.xpath(".//*[@id='login-ubox']/input"));
        passwordInput = getDriver().findElement(By.xpath(".//*[@id='login-pwbox']/input"));
        loginButton = getDriver().findElement(By.xpath(".//*[@id='login-box-wrapper']/a"));
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ComunioTeamNewsPage(getDriver());
    }

}
