package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",

        //when you set dryRun to TRUE ,it stops actual execution
        //dryRun=true,
        //it will quickly scan all the gherkin steps whether they are implemented or not
        //when we set dryRun to FALSE,it starts execution again
        dryRun = false,

        //tags are for running specific test casenow
        tags = "@sprint1",

       //to remove irrelavant information from console, you need to set monochrome to true
        monochrome = true,
       //pretty plugin prints the steps in the console to increase readability
        //to generate the reports we plugin of runner class
        //when we generate any report this should be under target foldr
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
                "rerun:target/failed.txt"}


)
public class SmokeRunner {
}
