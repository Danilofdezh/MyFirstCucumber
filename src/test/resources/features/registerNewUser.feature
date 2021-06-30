Feature: Register new user

  As a web user
  I want to register in advantage shopping
  To be able to buy a product

  Scenario: Register Successful
    Given that a web user wants to register in advantage shopping online
    When he fills all the requested fields
    Then he should see him username in the homepage
