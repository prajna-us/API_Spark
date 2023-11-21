Feature: Retrieve all Morbidities

  Background:
    Given the user has set Authorization to Bearer Token

  @01GetRequestForAllMorbidities
  Scenario: User retrieves all morbidities with a valid API and Bearer Token
    When User creates a GET https request for the API endpoint to get all morbidities
    Then Response status code should be 200 OK with response body

  @02GetRequestWithvalidMorbitityName
  Scenario: Check if user able to get morbidityName by passing valid morbitity name
    When User creates GET request for the  morbidity API endpoint
    Then Response status code should be 200 OK with response body

  @03GetRequestWithIvalidMorbitityName
  Scenario: Check if user able to get morbidityName by passing invalid morbitity name
    When User creates GET request for the  morbidity API endpoint with invalid name
    Then Response status code should be 404  with response body