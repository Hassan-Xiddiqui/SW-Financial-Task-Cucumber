Feature: E2E Test

  Scenario: Test Checkout
    Given User navigates to the Website
    Then User Login to the Website with valid creds
    And Change Dropdown from A-Z to Z-A
    And Add item to cart if the price is lower than $15.99
    Then Click on the Cart
    And Remove item if the price is greater than $9
    Then Click Check out
    Then Fill the form
    And Press the Continue Button
    Then Press the Finish Button
    And User will logout
    Then New User will Login to the Website