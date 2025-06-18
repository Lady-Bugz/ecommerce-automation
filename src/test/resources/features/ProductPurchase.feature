Feature: Product Purchase Functionality

  Background:
    When user searches for a product
    And user adds a product to cart

  @smoke
  Scenario: User can search and add product to cart
    Then user verifies that cart contains product

  @e2e @positive
  Scenario: User completes order placement successfully
    And user navigates to the checkout page
    And user fills in checkout details
    And user unchecks and checkmarks boxes
    Then user submits order


