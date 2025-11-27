Feature: SauceDemo Login

  Scenario: Successful login with standard_user
    Given user is on saucedemo login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then the products page should be displayed

  Scenario: Invalid login shows error
    Given user is on saucedemo login page
    When user logs in with username "locked_out_user" and password "secret_sauce"
    Then login should fail with message containing "locked out"
