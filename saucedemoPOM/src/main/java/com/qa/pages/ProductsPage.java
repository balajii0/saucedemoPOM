package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

	private By inventoryContainer = By.id("inventory_container");
	private By productsTitle = By.className("title");

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isLoaded() {
		try {
			return find(inventoryContainer).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getTitle() {
		return getText(productsTitle);
	}
}
