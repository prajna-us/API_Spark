package stepDifinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.LoggerLoad;
import utilities.ReadProperties;

import static org.junit.Assert.assertEquals;

public class MorbiditySD {


    private String bearerToken;
    private Response response;


    @Given("the user has set Authorization to Bearer Token")
    public void the_user_has_set_authorization_to_bearer_token() {

        //log file entry
        LoggerLoad.info("Reading token...");
        ReadProperties.loadConfig();

        //reading token from properties file.
        bearerToken = ReadProperties.getProperty("bearerToken");
        System.out.println(bearerToken);

    }

    @When("User creates a GET https request for the API endpoint to get all morbidities")
    public void user_creates_a_get_https_request_for_the_api_endpoint_to_get_all_morbidities() {

        //log file entry
        LoggerLoad.info("Reading GET endpoint...");

        //reading properties file.
        RestAssured.baseURI = ReadProperties.getProperty("baseURL");

        //reading GET endpoint from properties file
        String endpoint = ReadProperties.getProperty("Get_All_Morbidity");

        System.out.println(endpoint);

        //log file entry
        LoggerLoad.info("Get all Morbidity...");

        //Making the GET call by passing the auth token
        response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .get(endpoint);


        // Log the response body
        response.body().print();


    }

    @Then("Response status code should be {int} OK with response body")
    public void response_status_code_should_be_ok_with_response_body(int expectedStatusCode) {


        //log file entry
        LoggerLoad.info("Asserting response status code...");

        //Asserting 200 status code
        assertEquals(expectedStatusCode, response.getStatusCode());

        // Log the response body
        response.body().print();

    }

    @When("User creates GET request for the  morbidity API endpoint")
    public void user_creates_get_request_for_the_morbidity_api_endpoint() {

        //log file entry
        LoggerLoad.info("Reading GET endpoint...");

        //reading properties file.
        RestAssured.baseURI = ReadProperties.getProperty("baseURL");

        //reading GET endpoint from properties file
        String endpoint = ReadProperties.getProperty("Get_Morbidity_By_FastingGlucose");

        System.out.println(endpoint);

        //log file entry
        LoggerLoad.info("Get all Morbidity for Fasting Glucose...");

        //Making the GET call by passing the auth token
        response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .get(endpoint);


        // Log the response body
        response.body().print();


    }


    @When("User creates GET request for the  morbidity API endpoint with invalid name")
    public void invalidName() {


        //log file entry
        LoggerLoad.info("Reading GET endpoint...");

        //reading properties file.
        RestAssured.baseURI = ReadProperties.getProperty("baseURL");

        //reading GET endpoint from properties file
        String endpoint = ReadProperties.getProperty("Get_Morbidity_By_InvalidName");

        System.out.println(endpoint);

        //log file entry
        LoggerLoad.info("Get all Morbidity for Fasting Glucose...");

        //Making the GET call by passing the auth token
        response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .get(endpoint);


        // Log the response body
        response.body().print();

    }


    @Then("Response status code should be {int}  with response body")
    public void response_status_code_should_be_with_response_body(int expectedStatusCode) {


        //log file entry
        LoggerLoad.info("Asserting response status code...");

        //Asserting 200 status code
        assertEquals(expectedStatusCode, response.getStatusCode());

        // Log the response body
        response.body().print();

    }


}
