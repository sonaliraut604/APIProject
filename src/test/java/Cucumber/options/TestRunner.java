package Cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features" ,glue= {"StepDefinations"},
plugin={"json:target/jsonReport/cucumber-report.json"},
tags= "@AddPlace"

		
		)

public class TestRunner {

	

}
