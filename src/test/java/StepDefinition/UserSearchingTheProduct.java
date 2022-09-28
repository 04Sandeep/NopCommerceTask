package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;

public class UserSearchingTheProduct extends BaseClass{

    @Given("^User redirect to Home Page and go to signup page")
    public void User_redirect_to_Home_Page_and_go_to_signup_pagee()
    {
        initialization();
        objectPageFactory.getRegisteringAUser().signup();
    }

    @When("^user enter valid login credentials$")
    public void user_enter_valid_login_credentials()
    {
        objectPageFactory.getSearchingAProduct().Login();
    }

    @Then("^user searching the products$")
    public void user_searching_the_products() throws IOException {
        objectPageFactory.getSearchingAProduct().searchingAPage();
    }

    @And("^verify the product")
    public void verify_the_product()
    {
        objectPageFactory.getSearchingAProduct().verifiction();
    }

    @And("^user logout the page$")
    public void user_logout_the_page()
    {
        objectPageFactory.getSearchingAProduct().logout();
    }
}
