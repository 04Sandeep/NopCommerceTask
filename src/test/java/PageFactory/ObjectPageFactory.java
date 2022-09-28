package PageFactory;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class ObjectPageFactory {
    WebDriver driver;
    private LoginPage loginPage;

    public ObjectPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
}

