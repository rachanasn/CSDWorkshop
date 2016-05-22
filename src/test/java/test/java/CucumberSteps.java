package test.java;

import main.java.Patient;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CucumberSteps {
	
	@Given("^patient enter all required details$")
	public void patient_enter_all_required_details() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   // throw new PendingException();
	    Patient patient = new Patient();
	    patient.setId("1");
	    patient.setName("AAA");
	    patient.setDoctorName("BBB");
	    patient.setVisitDate("20/5/2016");
	    patient.setVital("120");    
	    
	}

	@When("^click on submit$")
	public void click_on_submit() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^system display \"([^\"]*)\"$")
	public void system_display(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   // throw new PendingException();
	}

}
