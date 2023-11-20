package stepDifinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.LoggerLoad;
import utilities.ReadProperties;

public class UserSD {

    private Response response;
    private String bearerToken;

    //	@Given ("User sets Authoization to Bearer Token")
//	public void user_sets_authoization_to_bearer_token () {
//
//		bearerToken = ReadProperties.getProperty("bearerToken");
//
//
//	}
    @Given("User creates request for the userlogin API endpoint")
    public void user_creates_request_for_the_userlogin_API_endpoint() {


    }

    @When("User sends HTTPS Request and  request Body with Required Field")
    public void user_sends_HTTPS_Request_and_request_Body_with_Required_Field() {

    }

    @Then("User receives {int} Created Status with response body")
    public void user_receives_Created_Status_with_response_body(Integer int1) {

    }


    @When("User sends HTTPS Request and Body with valid password and invalid email")
    public void user_sends_HTTPS_Request_and_Body_with_valid_password_and_invalid_email() {

    }

    @Then("User receives {int} Bad Request Status with message body")
    public void user_receives_Bad_Request_Status_with_message_body(Integer int1) {

    }


    @When("User sends HTTPS Request and  request Body with invalid password and valid email")
    public void user_sends_HTTPS_Request_and_request_Body_with_invalid_password_and_valid_email() {

    }


    @When("User sends HTTPS Request and  request Body with invalid password and invalid email")
    public void user_sends_HTTPS_Request_and_request_Body_with_invalid_password_and_invalid_email() {

    }


    @When("User sends HTTPS Request and request Body with missing mandatory fields")
    public void user_sends_HTTPS_Request_and_request_Body_with_missing_mandatory_fields() {

    }


    @Given("User creates GET Request for the logout API with User endpoint")
    public void user_creates_GET_Request_for_the_logout_API_with_User_endpoint() {

    }



    @Then("User receives {int} OK Status with response  Logout successful")
    public void user_receives_OK_Status_with_response_Logout_successful(Integer int1) {

    }


}
