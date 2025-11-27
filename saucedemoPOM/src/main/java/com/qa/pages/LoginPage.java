package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.cssSelector("h3[data-test='error']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUsername(String user) {
		type(usernameField, user);
	}

	public void enterPassword(String pass) {
		type(passwordField, pass);
	}

	public ProductsPage clickLogin() {
		click(loginButton);
		return new ProductsPage(driver);
	}

	public String getError() {
		try {
			return getText(errorMessage);
		} catch (Exception e) {
			return "";
		}
	}
}
