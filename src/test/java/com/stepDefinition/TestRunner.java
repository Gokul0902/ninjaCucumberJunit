package com.stepDefinition;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resource",
		glue={"com.stepDefinition","hooks"},
		publish=true,
		plugin={"pretty","html:target/reports/ninjaLoginreport.html"})
public class TestRunner {

}
