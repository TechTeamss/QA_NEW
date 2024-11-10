Feature: Shopping functionality on SauceDemo website

  Scenario: Add and remove items from the cart
    Given I have logged in and on the products page
    When I add three items to the cart
    Then I should verify the correct number of items in the cart
    And I remove one item from the cart
    Then I should verify the item is removed
    And I should verify the change in the number of items in the cart