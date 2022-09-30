package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = {"C:\\Users\\SandeepKaur\\IdeaProjects\\demo\\NopCommerceTask\\src\\test\\java\\Features\\03AddToCart.feature"},
                glue  = {"StepDefinition"},
                monochrome = true ,
                plugin = {"pretty","html:target/test-classes/cucumber-reports.html"}
        )


public class TestRunner {
}
