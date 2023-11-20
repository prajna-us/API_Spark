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
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class PatientSD {

    private ReadJson readJson = new ReadJson();
    private RequestSpecification requestSpec;

    private Response response;
    private String bearerToken;

    private String requestBody;


    @Given("User creates POST Request for the PatientAPI endpoint")
    public void user_creates_POST_Request_for_the_PatientAPI_endpoint() {

        //log file entry
        LoggerLoad.info("Setting baseURI for RestAssured...");

        //reading properties file.
        String baseURL = ReadProperties.getProperty("baseURL");
        RestAssured.baseURI = baseURL;

        //Creating request body....NEED TO MOVE THIS TO EXCEL READER

//        requestBody = "\"patientInfo\",\"{\n" +
//                "  \\\"FirstName\\\": \\\"Rahul1\\\",\n" +
//                "  \\\"LastName\\\": \\\"Joshi\\\",\n" +
//                "   \\\"ContactNumber\\\": \\\"3169874561\\\",\n" +
//                "    \\\"Email\\\": \\\"mandarjoshi1978@gmail.com\\\",\n" +
//                "    \\\"Allergy\\\": \\\"Soy\\\",\n" +
//                "     \\\"FoodCategory\\\": \\\"Vegan\\\",\n" +
//                "      \\\"DateOfBirth\\\": \\\"1982-04-07\\\"\n" +
//                "\t\n" +
//                "}\"";




//        System.out.println(requestBody);


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

        System.out.println(bearerToken);
        System.out.println(requestBody);
        System.out.println(endpoint);


        //Making post call
//        response = RestAssured.given()
//                .header("Authorization", "Bearer " + bearerToken)
//                .contentType(ContentType.JSON)
//                .body(requestBody)
//                .post(endpoint);

//        {
//            "FirstName": "Rahul1",
//                "LastName": "Joshi",
//                "ContactNumber": "7855425107",
//                "Email": "mandarjoshi1977@gmail.com",
//                "Allergy": "Soy",
//                "FoodCategory": "Vegan",
//                "DateOfBirth": "1982-04-07"
//
//        }

//        File file = new File("src/test/resources/PatientReports/HyperThyroid_Report_final.pdf");
//
//
//        response = RestAssured.given()
//                .header("Authorization", "Bearer " + bearerToken)
//                .multiPart("FirstName", "Rahul1")
//                .multiPart("LastName", "Joshi")
//                .multiPart("ContactNumber", "7855425901")
//                .multiPart("Email", "mandarjoshi198@gmail.com")
//                .multiPart("Allergy", "Soy")
//                .multiPart("FoodCategory", "Vegan")
//                .multiPart("DateOfBirth", "1982-04-07")
//                .multiPart("file", file, "application/octet-stream")
//                .post(endpoint); // Replace with your endpoint
//
//        System.out.println(response.body().print());

        JSONObject testData = readJson.setUpTestData();
        JSONObject patientInfo = testData.getJSONObject(ReadProperties.getProperty("CreatePatient"));


        File file = new File("src/test/resources/PatientReports/HyperThyroid_Report_final.pdf");

//        //   .multiPart("file", file);
//        HashMap<String, Object> patientInfo = new HashMap<>();
//        patientInfo.put("FirstName", "John");
//        patientInfo.put("LastName", "Ras");
//        patientInfo.put("ContactNumber", "5680003421");
//        patientInfo.put("Email", "abcthu@gmail.com");
//        patientInfo.put("Allergy", "Soy");
//        patientInfo.put("FoodCategory", "Vegan");
//        patientInfo.put("DateOfBirth", "1990-07-02");

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

        // Log the request body
        System.out.println("Request Body: " + requestSpec.log().all().toString());

        // Log the response body
        response.body().print();


    }

    @Then("User receives  Created Status {int} with response body")
    public void user_receives_Created_Status_with_response_body(int expectedStatusCode) {

        LoggerLoad.info("Asserting response status code...");
        assertEquals(expectedStatusCode, response.getStatusCode());


    }

    @When("User sends HTTPS Request and  request Body with missing  mandatory field")
    public void user_sends_HTTPS_Request_and_request_Body_with_missing_additional_field() {

    }

    @Then("User receives {int} Bad Request Status with message and boolean success details")
    public void user_receives_Bad_Request_Status_with_message_and_boolean_success_details(Integer int1) {

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
