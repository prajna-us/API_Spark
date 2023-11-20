package stepDifinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import utilities.LoggerLoad;
import utilities.ReadJson;
import utilities.ReadProperties;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class PatientSD {

    private final ReadJson readJson = new ReadJson();
    private RequestSpecification requestSpec;

    private Response response;
    private String bearerToken;

    private int patientId;

    private String requestBody;


    @Given("User creates POST Request for the PatientAPI endpoint")
    public void user_creates_POST_Request_for_the_PatientAPI_endpoint() {

        //log file entry
        LoggerLoad.info("Setting baseURI for RestAssured...");

        //reading properties file.
        RestAssured.baseURI = ReadProperties.getProperty("baseURL");

        requestSpec = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .contentType(ContentType.MULTIPART);
    }

    @When("User sends HTTPS Request and  request Body with mandatory , additional  field")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_additional_field() {

        //log file entry
        LoggerLoad.info("Reading POST endpoint...");

        String endpoint = ReadProperties.getProperty("Create_New_Patient");

        LoggerLoad.info("Making POST call to create patient...");


        //Reading test data
        JSONObject testData = readJson.setUpTestData();
        JSONObject patientInfo = testData.getJSONObject(ReadProperties.getProperty("CreatePatient"));


        //reading reprot file...
        File file = new File(patientInfo.getString("ReportFileLoc"));


        // Convert patientInfo to JSON string
        String patientInfoJson = "{" +
                "\"FirstName\":\"" + patientInfo.getString("FirstName") + "\"," +
                "\"LastName\":\"" + patientInfo.getString("LastName") + "\"," +
                "\"ContactNumber\":" + patientInfo.getString("ContactNumber") + "," +
                "\"Email\":\"" + patientInfo.getString("Email") + "\"," +
                "\"Allergy\":\"" + patientInfo.getString("Allergy") + "\"," +
                "\"FoodCategory\":\"" + patientInfo.getString("FoodCategory") + "\"," +
                "\"DateOfBirth\":\"" + patientInfo.getString("DateOfBirth") + "\"" +
                "}";

        // Send the POST request with form parameters
        response = requestSpec
                .multiPart("patientInfo", patientInfoJson)
                .multiPart("file", file)
                .post(endpoint);

        // Log the response body
        response.body().print();

    }

    @Then("User receives  Created Status {int} with response body")
    public void user_receives_Created_Status_with_response_body(int expectedStatusCode) {

        LoggerLoad.info("Asserting response status code...");
        assertEquals(expectedStatusCode, response.getStatusCode());

        patientId = response.then().extract().path("patientId");

        try {
            ReadProperties.storeInConfig("patientId", String.valueOf(patientId));

        } catch (IOException E) {

        }



    }

    @When("User sends HTTPS Request and  request Body with missing  mandatory field")
    public void user_sends_HTTPS_Request_and_request_Body_with_missing_additional_field() {


        //log file entry
        LoggerLoad.info("Reading POST endpoint...");

        String endpoint = ReadProperties.getProperty("Create_New_Patient");

        LoggerLoad.info("Making POST call to create patient...");

        //Reading test data
        JSONObject testData = readJson.setUpTestData();
        JSONObject patientInfo = testData.getJSONObject(ReadProperties.getProperty("CreatePatient"));


        //reading reprot file...
        File file = new File(patientInfo.getString("ReportFileLoc"));


        // Send the POST request with form parameters
        response = requestSpec
                .multiPart("file", file)
                .post(endpoint);

        // Log the response body
        response.body().print();



    }

    @Then("User receives {int} Bad Request Status with message and boolean success details")
    public void user_receives_Bad_Request_Status_with_message_and_boolean_success_details(int expectedStatusCode) {

        LoggerLoad.info("Asserting response status code...");
        assertEquals(expectedStatusCode, response.getStatusCode());


    }

    @Given("User sets Authoization to Bearer Token")
    public void user_sets_authoization_to_bearer_token() {

        //log file entry
        LoggerLoad.info("Reading token...");

        //reading token from properties file.
        bearerToken = ReadProperties.getProperty("bearerToken");


    }


    @Given("User creates GET Request for the  API endpoint")
    public void user_creates_GET_Request_for_the_API_endpoint() {

        //log file entry
        LoggerLoad.info("Setting baseURI for RestAssured...");

        //reading get url from properties file
        String baseURL = ReadProperties.getProperty("baseURL");

        //setting URI for RestAssured
        RestAssured.baseURI = baseURL;


    }

    @When("User sends HTTPS Request")
    public void user_sends_HTTPS_Request() {

//        Get_Patients_Morbidity_Details
        //log file entry
        LoggerLoad.info("Reading GET endpoint...");

        //reading GET endpoint from properties file
        String endpoint = ReadProperties.getProperty("Get_Patients_Morbidity_Details") + ReadProperties.getProperty("patientId");

        System.out.println("patientId   " + ReadProperties.getProperty("patientId"));
        System.out.println(endpoint);

        //log file entry
        LoggerLoad.info("Making Get all Patients call...");

        //Making the GET call by passing the auth token
        response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .get(endpoint);

    }

    @When("User sends HTTPS Request for patients")
    public void user_sends_HTTPS_Request_for_patients() {

        //log file entry
        LoggerLoad.info("Reading GET endpoint...");

        //reading GET endpoint from properties file
        String endpoint = ReadProperties.getProperty("Get_All_Patients");

        //log file entry
        LoggerLoad.info("Making Get all Patients call...");

        //Making the GET call by passing the auth token
        response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .get(endpoint);


    }


    @Given("User creates PUT Request for the  PatientAPI endpoint")
    public void user_creates_PUT_Request_for_the_PatientAPI_endpoint() {

    }


    @When("User sends HTTPS Request and  request Body with mandatory , additional  field and updates First Name field only")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_additional_field_and_updates_First_Name_field_only() {

    }


    @When("User sends HTTPS Request and  request Body with mandatory , additional  field and updates Last Name field only")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_additional_field_and_updates_Last_Name_field_only() {

    }


    @When("User sends HTTPS Request and  request Body with mandatory , additional  field and updates  Contact Number field  only")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_additional_field_and_updates_Contact_Number_field_only() {

    }


    @When("User sends HTTPS Request and  request Body with mandatory , additional  field and updates email field only")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_additional_field_and_updates_email_field_only() {

    }


    @When("User sends HTTPS Request and  request Body with mandatory , additional  field and updates Allergy field")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_additional_field_and_updates_Allergy_field() {

    }


    @When("User sends HTTPS Request and  request Body with mandatory , additional  field and updates Food category with valid values")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_additional_field_and_updates_Food_category_with_valid_values() {

    }


    @When("User sends HTTPS Request and  request Body with mandatory , additional  field and updates Date of Birth field")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_additional_field_and_updates_Date_of_Birth_field() {

    }


    @Then("User receives {int} Not Found Status with response body")
    public void user_receives_Not_Found_Status_with_response_body(Integer int1) {

    }


    @When("User sends HTTPS Request and  request Body with mandatory patientId field for existing patient")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_patientId_field_for_existing_patient() {

    }

    @Then("User receives {int} OK Status with response body")
    public void user_receives_OK_Status_with_response_body(int expectedStatusCode) {

        //log file entry
        LoggerLoad.info("Asserting response status code...");

        //Asserting 200 status code
        assertEquals(expectedStatusCode, response.getStatusCode());

        // Log the response body
        response.body().print();

    }

    @Given("User creates DELETE Request for the PatientAPI endpoint")
    public void user_creates_DELETE_Request_for_the_PatientAPI_endpoint() {

    }

    @When("User sends HTTPS Request and  request Body with mandatory patientId field for non-existing patient")
    public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_patientId_field_for_non_existing_patient() {

    }


}
