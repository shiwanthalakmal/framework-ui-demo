Feature: As a user of the puppy adoption site
  I want to access demo admin panel
  So i can buy a puppy via adoption page

  Background:
    Given I am on the puppy adoption home page

  @Regression
  Scenario: Verify the puppy adoption complete flow
    Then I should see page header title
    And I should see puppy view page button
    When I adopt selected puppy
    Then I continue adoption completion flow
    And I fill all necessary registration details
    Then I submit the place order