Feature: Sample API Test
  Scenario: Verify GET request
    Given I have the base URI "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response should contain "title"
