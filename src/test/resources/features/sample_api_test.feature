Feature: Sample API Test
  Scenario: Verify GET request
    Given I have a bearer token from config file
    Given I have the base URI from config file
    When I send a GET request with bearer token to endpoint
    Then the response status code should be 200
#    And the response should contain "title"
