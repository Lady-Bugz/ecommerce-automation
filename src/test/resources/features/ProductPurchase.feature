Feature: Product Purchase Functionality

  Background:
    Given user is navigated to the application

  @smoke
  Scenario: Basic product purchase flow
    * user click on product
    * add to cart button is visible


  @e2e @positive
  Scenario: Successful purchase process
    *  user searches for a product
    *  user hovers over the product and clicks add to cart
    *  user proceeds to checkout from the pop-up displayed
    *  user fills in details
    *  user unchecks and checkmarks boxes
    *  user completes the checkout process


