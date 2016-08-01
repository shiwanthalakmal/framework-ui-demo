package com.framework.qa.test.behaviour.testPlans;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
        ,glue={"com.framework.qa.test.behaviour.stepDefinition"}
        ,monochrome = true
        ,tags = {"@Regression"}
        ,format = {"pretty","html:target/html","json:target/cucumber.json"}
)
public class BAT_HomeCukes extends AbstractTestNGCucumberTests{
}
