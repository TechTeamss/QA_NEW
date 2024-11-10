Feature: Shopping functionality on SauceDemo website

  Scenario: Login with accepted usernames
    Given I am on the SauceDemo login page
    When I log in with username "<username>" and password "<password>"
    Then I should see the products page if login is successful
    And I should verify login success or failure