package com.qa.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import com.qa.util.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private WebDriver driver;
	private LoginPage loginPage;
	private ProductsPage productsPage;

	@Given("user is on saucedemo login page")
	public void openLoginPage() {
		driver = DriverFactory.driver;
		driver.get("https://www.saucedemo.com/");
		loginPage = new LoginPage(driver);
	}

	@When("user logs in with username {string} and password {string}")
	public void login(String user, String pass) {
		loginPage.enterUsername(user);
		loginPage.enterPassword(pass);
		productsPage = loginPage.clickLogin();
	}

	@Then("the products page should be displayed")
	public void verifyProductsPage() {
		assertTrue("Products page not loaded", productsPage.isLoaded());
	}

	@Then("login should fail with message containing {string}")
	public void verifyErrorMessage(String text) {
		String error = loginPage.getError();
		assertTrue("Expected error containing: " + text + " but was: " + error, error.contains(text));
	}
}
