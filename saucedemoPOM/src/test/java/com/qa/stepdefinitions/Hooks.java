package com.qa.stepdefinitions;

import com.qa.util.DriverFactory;

import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setUp() {
		DriverFactory.initDriver();
	}

	/*
	 * @After public void tearDown() { DriverFactory.quitDriver(); }
	 */
}
