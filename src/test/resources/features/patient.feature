Feature: Patient Feature

  Background:
    Given User sets Authoization to Bearer Token

  @01PostRequestWithValidCredentials
  Scenario: Check if user able to create a patient detail with valid endpoint and request body
    Given User creates POST Request for the PatientAPI endpoint
    When User sends HTTPS Request and  request Body with mandatory , additional  field
    Then User receives  Created Status 201 with response body

  @02PostRequestWithExistingValues
  Scenario: Check if user able to create a patient detail with valid endpoint and request body with existing values
    Given User creates POST Request for the PatientAPI endpoint
    When User sends HTTPS Request and  request Body with mandatory , additional  field
    Then User receives 400 Bad Request Status with message and boolean success details

  @03PostRequestWithMandatoryFields
  Scenario: Check if user able to create a patient detail with missing mandatory fields in request body
    Given User creates POST Request for the PatientAPI endpoint
    When User sends HTTPS Request and  request Body with missing  mandatory field
    Then User receives 400 Bad Request Status with message and boolean success details

  @04GetRequestAllPatients
  Scenario: Check if user able to retrieve all patients with valid API
    Given User creates GET Request for the  API endpoint
    When User sends HTTPS Request for patients
    Then User receives 200 OK Status with response body

#  @05GetRequestValidPatientId
#  Scenario: Check if user is able to retrieve patient using patientId with valid API
#    Given User creates GET Request for the  API endpoint
#    When User sends HTTPS Request
#    Then User receives 200 OK Status with response body

#  @06GetRequestInValidPatientId
#  Scenario: Check if user is able to retrieve patient using invalid patientId with valid API
#    Given User creates GET Request for the  API endpoint
#    When User sends HTTPS Request
#    Then User receives 404 Not Found Status with Response body

  @07GetRequestValidFileId
  Scenario: Check if user is able to retrieve patient file by fileId with valid API
    Given User creates GET Request for the  API endpoint
    When User sends HTTPS Request
    Then User receives 200 OK Status with response body

#  @08GetRequestInValidFileId
#  Scenario: Check if user is able to retrieve patient file by invalid fileId with valid API
#    Given User creates GET Request for the  API endpoint
#    When User sends HTTPS Request
#    Then User receives 404 Not Found Status with Response body
#
#  @09PutRequestUsingPatientIdAndPatientInfo
#  Scenario: Check if user able to update a patient detail by using patientId and patientInfo with valid endpoint
#  and request body
#    Given User creates PUT Request for the  PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory , additional  field
#    Then User receives 200 OK Status with response body
#
#  @10PutRequestUsingMandoryAditionalWithUpdatesFirstName
#  Scenario: Check if user able to update a patient detail by using patientId and patientInfo with valid endpoint
#  and request body
#    Given User creates PUT Request for the  PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory , additional  field and updates First Name field only
#    Then User receives 200 OK Status with response body
#
#  @11PutRequestUsingMandoryAditionalWithUpdatesLastName
#  Scenario: Check if user able to update a patient detail by using patientId and patientInfo with valid endpoint
#  and request body
#    Given User creates PUT Request for the  PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory , additional  field and updates Last Name field only
#    Then User receives 200 OK Status with response body
#
#  @12PutRequestUsingMandoryAditionalWithUpdateContactNum
#  Scenario: Check if user able to update a patient detail by using patientId and patientInfo with valid endpoint
#  and request body
#    Given User creates PUT Request for the  PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory , additional  field and updates  Contact Number field  only
#    Then User receives 200 OK Status with response body
#
#  @13PutRequestUsingMandoryAditionalWithUpdateEmail
#  Scenario: Check if user able to update a patient detail by using patientId and patientInfo with valid endpoint
#  and request body
#    Given User creates PUT Request for the  PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory , additional  field and updates email field only
#    Then User receives 200 OK Status with response body
#
#  @14PutRequestUsingMandoryAditionalWithUpdateAllergy
#  Scenario: Check if user able to update a patient detail by using patientId and patientInfo with valid endpoint
#  and request body
#    Given User creates PUT Request for the  PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory , additional  field and updates Allergy field
#    Then User receives 200 OK Status with response body
#
#
#  @15PutRequestUsingMandoryAditionalWithUpdateValidValues
#  Scenario: Check if user able to update a patient detail by using patientId and patientInfo with valid endpoint
#  and request body
#    Given User creates PUT Request for the  PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory , additional  field and updates Food category with valid values
#    Then User receives 200 OK Status with response body
#
#  @16PutRequestUsingMandoryAditionalWithUpdateValidUpdateDOB
#  Scenario: Check if user able to update a patient detail by using patientId and patientInfo with valid endpoint
#  and request body
#    Given User creates PUT Request for the  PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory , additional  field and updates Date of Birth field
#    Then User receives 200 OK Status with response body
#
#  @17PutRequestWrongBaseUrl
#  Scenario: Check if user able to update a patient detail by using wrong BaseURL with missing field in request body
#    Given User creates PUT Request for the  PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory , additional  field
#    Then User receives 404 Not Found Status with response body
#
#  @18DeleteRequestExistingPatient
#  Scenario: Check if user able to delete  a patient detail by using patientId  with valid endpoint and request body
#    Given User creates DELETE Request for the PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory patientId field for existing patient
#    Then User receives 200 OK Status with response body
#
#  @19DeleteRequestNonExistingPatient
#  Scenario: Check if user able to delete  a patient detail by using patientId  with valid endpoint and request body
#    Given User creates DELETE Request for the PatientAPI endpoint
#    When User sends HTTPS Request and  request Body with mandatory patientId field for non-existing patient
#    Then User receives 404 Not Found Status with response body

