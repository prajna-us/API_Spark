package stepDifinitions;

import io.cucumber.java.en.*;

public class PatientSD {
	
	

@Given("User creates POST Request for the PatientAPI endpoint")
public void user_creates_POST_Request_for_the_PatientAPI_endpoint() {
	
}

@When("User sends HTTPS Request and  request Body with mandatory , additional  field")
public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_additional_field() {
  
}

@Then("User receives  Created Status {int} with response body")
public void user_receives_Created_Status_with_response_body(Integer int1) {

}

@When("User sends HTTPS Request and  request Body with missing  mandatory field")
public void user_sends_HTTPS_Request_and_request_Body_with_missing_additional_field() {
  
}

@Then("User receives {int} Bad Request Status with message and boolean success details")
public void user_receives_Bad_Request_Status_with_message_and_boolean_success_details(Integer int1) {

}



@Given("User creates GET Request for the  API endpoint")
public void user_creates_GET_Request_for_the_API_endpoint() {
 
}

@When("User sends HTTPS Request for patients")
public void user_sends_HTTPS_Request_for_patients() {
  
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
public void user_receives_OK_Status_with_response_body(Integer int1) {
  
}

@Given("User creates DELETE Request for the PatientAPI endpoint")
public void user_creates_DELETE_Request_for_the_PatientAPI_endpoint() {
  
}

@When("User sends HTTPS Request and  request Body with mandatory patientId field for non-existing patient")
public void user_sends_HTTPS_Request_and_request_Body_with_mandatory_patientId_field_for_non_existing_patient() {
 
}




}
