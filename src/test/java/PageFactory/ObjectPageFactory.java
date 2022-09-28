package PageFactory;

import Pages.AddToCartComputerProduct;
import Pages.RegisteringAUser;
import Pages.SearchingAProduct;
import org.openqa.selenium.WebDriver;

public class ObjectPageFactory {
    WebDriver driver;
    private RegisteringAUser registeringAUser;
    private SearchingAProduct searchingAProduct;
    private AddToCartComputerProduct addToCart;

    public ObjectPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public RegisteringAUser getRegisteringAUser() {
        if (registeringAUser == null) {
            registeringAUser = new RegisteringAUser(driver);
        }
        return registeringAUser;
    }

    public SearchingAProduct getSearchingAProduct() {
        if(searchingAProduct == null)
        {
            searchingAProduct = new SearchingAProduct(driver);
        }
        return searchingAProduct;
    }

    public AddToCartComputerProduct getAddToCartComputerProduct() {
        if(addToCart == null)
        {
         addToCart= new AddToCartComputerProduct(driver);
        }
        return addToCart;
    }
}

