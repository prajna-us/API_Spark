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

import static org.junit.Assert.assertEquals;

public class UserSD {

    private final ReadJson readJson = new ReadJson();
    private String bearerToken;
    private RequestSpecification requestSpec;
    private Response response;

    @Given("User sets Authoization to Bearer Token for login")
    public void user_sets_authoization_to_bearer_token_for_login() {

        LoggerLoad.info("Reading token...");
        ReadProperties.loadConfig();
        bearerToken = ReadProperties.getProperty("bearerToken");


    }

    @Given("User creates request for the userlogin API endpoint")
    public void user_creates_request_for_the_userlogin_API_endpoint() {

        //log file entry
        LoggerLoad.info("Setting baseURI for RestAssured...");

        //reading properties file.
        RestAssured.baseURI = ReadProperties.getProperty("baseURL");

        requestSpec = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .header("accept", "application/json")
                .header("Content-Type", ContentType.JSON);

    }

    @When("User sends HTTPS Request and  request Body with Required Field")
    public void user_sends_HTTPS_Request_and_request_Body_with_Required_Field() {

        //log file entry
        LoggerLoad.info("Reading POST endpoint...");

        String endpoint = ReadProperties.getProperty("user_PostEndpoint");

        LoggerLoad.info("Making POST call for patient login...");


        //Reading test data
        JSONObject testData = readJson.setUpTestData();
        JSONObject patientInfo = testData.getJSONObject(ReadProperties.getProperty("PatientLogin"));

        // Convert patientInfo to JSON string
        String patientInfoJson = "{" +
                "\"password\":\"" + patientInfo.getString("password") + "\"," +
                "\"userLoginEmail\":\"" + patientInfo.getString("userLoginEmail") + "\"" +
                "}";

        System.out.println(patientInfoJson);

        // Send the POST request with form parameters
        response = requestSpec
                .body(patientInfoJson)
                .post(endpoint);

        // Log the response body
        response.body().print();

    }

    @Then("User receives {int} Created Status with response body")
    public void user_receives_Created_Status_with_response_body(int expectedStatusCode) {


        LoggerLoad.info("Asserting response status code...");
        assertEquals(expectedStatusCode, response.getStatusCode());


    }


    @When("User sends HTTPS Request and Body with valid password and invalid email")
    public void user_sends_HTTPS_Request_and_Body_with_valid_password_and_invalid_email() {

        //log file entry
        LoggerLoad.info("Reading POST endpoint...");

        String endpoint = ReadProperties.getProperty("user_PostEndpoint");

        LoggerLoad.info("Making POST call for patient login...");


        //Reading test data
        JSONObject testData = readJson.setUpTestData();
        JSONObject patientInfo = testData.getJSONObject(ReadProperties.getProperty("PatientLogin"));

        // Convert patientInfo to JSON string
        String patientInfoJson = "{" +
                "\"password\":\"" + patientInfo.getString("password") + "\"," +
                "\"userLoginEmail\":\"" + "stringgmail.com" + "\"" +
                "}";

        System.out.println(patientInfoJson);

        // Send the POST request with form parameters
        response = requestSpec
                .body(patientInfoJson)
                .post(endpoint);

        // Log the response body
        response.body().print();

    }

    @Then("User receives {int} Bad Request Status with message body")
    public void user_receives_Bad_Request_Status_with_message_body(int expectedStatusCode) {

        LoggerLoad.info("Asserting response status code...");
        assertEquals(expectedStatusCode, response.getStatusCode());

    }


    @When("User sends HTTPS Request and  request Body with invalid password and valid email")
    public void user_sends_HTTPS_Request_and_request_Body_with_invalid_password_and_valid_email() {

//log file entry
        LoggerLoad.info("Reading POST endpoint...");

        String endpoint = ReadProperties.getProperty("user_PostEndpoint");

        LoggerLoad.info("Making POST call for patient login...");


        //Reading test data
        JSONObject testData = readJson.setUpTestData();
        JSONObject patientInfo = testData.getJSONObject(ReadProperties.getProperty("PatientLogin"));

        // Convert patientInfo to JSON string
        String patientInfoJson = "{" +
                "\"password\":\"" + "test1" + "\"," +
                "\"userLoginEmail\":\"" + patientInfo.getString("userLoginEmail") + "\"" +
                "}";

        System.out.println(patientInfoJson);

        // Send the POST request with form parameters
        response = requestSpec
                .body(patientInfoJson)
                .post(endpoint);

        // Log the response body
        response.body().print();

    }


    @When("User sends HTTPS Request and  request Body with invalid password and invalid email")
    public void user_sends_HTTPS_Request_and_request_Body_with_invalid_password_and_invalid_email() {


//log file entry
        LoggerLoad.info("Reading POST endpoint...");

        String endpoint = ReadProperties.getProperty("user_PostEndpoint");

        LoggerLoad.info("Making POST call for patient login...");

        // Convert patientInfo to JSON string
        String patientInfoJson = "{" +
                "\"password\":\"" + "test1" + "\"," +
                "\"userLoginEmail\":\"" + "stringgamil.com" + "\"" +
                "}";

        System.out.println(patientInfoJson);

        // Send the POST request with form parameters
        response = requestSpec
                .body(patientInfoJson)
                .post(endpoint);

        // Log the response body
        response.body().print();

    }


    @When("User sends HTTPS Request and request Body with missing mandatory fields")
    public void user_sends_HTTPS_Request_and_request_Body_with_missing_mandatory_fields() {


//log file entry
        LoggerLoad.info("Reading POST endpoint...");

        String endpoint = ReadProperties.getProperty("user_PostEndpoint");

        LoggerLoad.info("Making POST call for patient login...");

        // Convert patientInfo to JSON string
        String patientInfoJson = "";

        System.out.println(patientInfoJson);

        // Send the POST request with form parameters
        response = requestSpec
                .body(patientInfoJson)
                .post(endpoint);

        // Log the response body
        response.body().print();

    }


    @Given("User creates GET Request for the logout API with User endpoint")
    public void user_creates_GET_Request_for_the_logout_API_with_User_endpoint() {


        //log file entry
        LoggerLoad.info("Setting baseURI for RestAssured...");

        //setting URI for RestAssured
        RestAssured.baseURI = ReadProperties.getProperty("baseURL");


    }


    @When("User sends HTTPS logout Request")
    public void patient_logout() {

        //log file entry
        LoggerLoad.info("Reading GET endpoint...");

        //reading GET endpoint from properties file
        String endpoint = ReadProperties.getProperty("user_LogoutEndpoint");

        //log file entry
        LoggerLoad.info("Making Get all Patients call...");

        //Making the GET call by passing the auth token
        response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .get(endpoint);


    }

    @Then("User receives {int} OK Status with response  Logout successful")
    public void user_receives_OK_Status_with_response_Logout_successful(int expectedStatusCode) {

        LoggerLoad.info("Asserting response status code...");
        assertEquals(expectedStatusCode, response.getStatusCode());

    }


}
