package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;

public class RegisteredAUser extends BaseClass{

        @Given("^navigate to NopCommerce website")
        public void navigate_to_NopCommerce_website()
        {
            initialization();
        }

        @When("^user go to Signup for registering$")
        public void user_go_to_Signup_for_registering()
        {
        objectPageFactory.getRegisteringAUser().signup();
        }

        @And("^user is entering registration details$")
        public void user_is_entering_registration_details() throws IOException {
            objectPageFactory.getRegisteringAUser().registeringAUser();
       }

        @Then("^verifying the registered user$")
        public void verifying_the_registered_user()
        {
        objectPageFactory.getRegisteringAUser().verify();
        }

    }



