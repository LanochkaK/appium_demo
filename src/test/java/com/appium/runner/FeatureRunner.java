package com.appium.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {  "html:target/cucumber-report.html"},  //cucumber HTMl report

        features = "src/test/resources/features",
        glue = "com/appium/stepDefs",
        dryRun = true,
        tags = "@local"

)



public class FeatureRunner {
}


