package com.imdb.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com/imdb/steps"}, features = {"src/test/resources/features"}, plugin = {"pretty", "html:target/site/cucumber-pretty.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/cucumber.json"
},
        monochrome = true,
        publish = true

)
public class RunCucumberTest {
}
