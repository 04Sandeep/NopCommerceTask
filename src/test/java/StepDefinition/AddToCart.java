package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;

public class AddToCart extends BaseClass{

    @Given("^User goes to NopCommerce website$")
    public void User_goes_to_NopCommerce_website()
    {
        initialization();
    }

    @When("^user enter their valid login credentials$")
    public void  user_enter_their_valid_login_credentials()
    {
        objectPageFactory.getAddToCartComputerProduct().userLogin();
    }

    @Then("^user adding the products to cart$")
    public void  user_adding_the_products_to_cart() throws IOException {
        objectPageFactory.getAddToCartComputerProduct().addToCart();
    }

    @And("^verify the buy product$")
    public void verify_the_buy_product()
    {
        objectPageFactory.getAddToCartComputerProduct().verification1();
    }

    @And("^user will logout the page$")
    public void user_will_logout_the_page()
    {
        objectPageFactory.getAddToCartComputerProduct().userLogout();
    }
}
