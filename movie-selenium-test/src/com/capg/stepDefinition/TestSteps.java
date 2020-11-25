package com.capg.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {

	@Given("^Navigate to movie management login page$")
	public void navigate_to_movie_management_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:/Users/bhanu/Desktop/capg softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	  driver.get("http://localhost:4200/login");
	  driver.close();
	}

	@When("^User enter valid link$")
	public void user_enter_valid_link() throws Throwable {
	
	    throw new PendingException();
	}

	@Then("^Show home page$")
	public void show_home_page() throws Throwable {
	    
	    throw new PendingException();
	}
}