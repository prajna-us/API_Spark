package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleAPITestSteps {
    private Response response;

    @Given("I have the base URI {string}")
    public void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = RestAssured.get(endpoint);
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

