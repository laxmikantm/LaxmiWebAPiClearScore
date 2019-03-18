@cookieTest
Feature: Perform smoke test on opening of the Clear Score Home page & cookies

  As a user
  I should be able to open the clearScore homepage
  Also cookie for cookie_mandate should get set after first visit

  Scenario: First visit to Clear Score Home Page
    Given I am visiting the Clear Score website for first time
    When I visit the Clear Score site for first time
    Then Cookie mandate message should be shown

  Scenario: Accept cookie
    Given I am visiting the Clear Score website for first time
    When I visit the Clear Score site for first time
    And I accept cookie mandate message
    Then cookie mandate cookie is set
    And Cookie mandate message is no longer shown