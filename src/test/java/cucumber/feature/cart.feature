Feature: Shopping functionality on SauceDemo website

  Scenario: Validate product sorting
    Given I am logged in to the SauceDemo website
    When I check the number of items on the products page
    And I select sorting by price (low to high)
    Then I should verify the first item has the lowest price
    And I should verify the last item has the highest price