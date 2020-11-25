package com.capg.test;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(value = Cucumber.class)
@CucumberOptions(features="feature" , glue= {"com.capg.stepDefinition"})
public class TestRunner {

	
}
