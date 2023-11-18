package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConfigReader;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleAPITestSteps {
    private Response response;
    private String bearerToken;


    @Given("I have a bearer token from config file")
    public void setBearerTokenFromConfig() {
        bearerToken = ConfigReader.getProperty("bearerToken");
    }

    @Given("I have the base URI from config file")
    public void setBaseURIFromConfig() {
        String baseURI = ConfigReader.getProperty("baseURI");
        RestAssured.baseURI = baseURI;
    }

    @When("I send a GET request with bearer token to endpoint")
    public void sendGetRequestWithBearerTokenToEndpoint() {
        String endpoint = ConfigReader.getProperty("getPatientEndpoint");

        response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void verifyResponseContent(String expectedContent) {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains(expectedContent));
    }
}

