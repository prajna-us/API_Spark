Feature: User Feature
Background: 
	Given User sets Authoization to Bearer Token

   @01PostRequestWithValidCredentials
   Scenario: Check if user able to create a user with valid endpoint and request body (non-existing values)
    Given User creates request for the userlogin API endpoint
    When User sends HTTPS Request and  request Body with Required Field  
    Then User receives 201 Created Status with response body

    @02PostRequestWithInvalidCredentials
    Scenario: Check if user able to create a user with valid password and invalid email
    Given User creates request for the userlogin API endpoint
    When User sends HTTPS Request and Body with valid password and invalid email 
    Then User receives 400 Bad Request Status with message body
    
    @03PostRequestWithInvalidCredentials
    Scenario: Check if user able to create a user with Invalid password and valid email
    Given User creates request for the userlogin API endpoint
    When User sends HTTPS Request and  request Body with invalid password and valid email 
    Then User receives 400 Bad Request Status with message body
    
    @04PostRequestWithInvalidCredentials
    Scenario: Check if user able to create a user with invalid password and invalid email
    Given User creates request for the userlogin API endpoint
    When User sends HTTPS Request and  request Body with invalid password and invalid email 
    Then User receives 400 Bad Request Status with message body
    
    @05PostRequestWithMissingFields
    Scenario: Check if user able to create a user with missing fields
    Given User creates request for the userlogin API endpoint
    When User sends HTTPS Request and request Body with missing mandatory fields
    Then User receives 400 Bad Request Status with message body
    
    @06GetRequestLogout
    Scenario: Check if user able to logout with valid API
    Given User creates GET Request for the logout API with User endpoint
    When User sends HTTPS Request
    Then User receives 200 OK Status with response  Logout successful     