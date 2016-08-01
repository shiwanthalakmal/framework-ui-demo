Feature: As a administrator of the puppy adoption site
  I want to access demo admin panel
  So i can update, delete and insert new puppy details

  Background:
    Given I am on the puppy adoption home page

  @Regression
  Scenario: Basic ui verification of the homepage
    Then I should see page header title
    And I should see puppy view page button

  @Regression
  Scenario: Verify the puppy adoption complete flow
    Then I should see page header title
    And I should see puppy view page button
    When I adopt selected puppy
    Then I continue adoption completion flow
    And I fill all necessary registration details
    Then I submit the place order
