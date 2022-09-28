package PageFactory;

import Pages.RegisteringAUser;
import org.openqa.selenium.WebDriver;

public class ObjectPageFactory {
    WebDriver driver;
    private RegisteringAUser registeringAUser;

    public ObjectPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public RegisteringAUser getRegisteringAUser() {
        if (registeringAUser == null) {
            registeringAUser = new RegisteringAUser(driver);
        }
        return registeringAUser;
    }
}

