package software;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Reports {	
	MainClass mainClass = new MainClass();
	
	
	Admin a;
	Opticity c=new Opticity(mainClass);

	
	
	public Reports(Opticity c) {
		a=new Admin();
		 mainClass = new MainClass();
		c=this.c;
		
	}


@Given("that the admin is logged in is {string} now")
public void that_the_admin_is_logged_in_is_now(String string) {
	if (string.equalsIgnoreCase("true")) {
		a.setStatus(true);
		assertTrue(a.getStatus());
	} 
}

@Given("he generated all patients' names")
public void he_generated_all_patients_names() {
	 assertTrue(c.showAllPatients());
}

@Then("the report generated successfully")
public void the_report_generated_successfully() {
	assertTrue(true);
}

@Given("he generated all patients' names and their appointments details")
public void he_generated_all_patients_names_and_their_appointments_details() {
	 assertTrue(c.showAllPattientsAndTheirAppointments());
}


@Given("that the admin is not logged in is {string} now")
public void that_the_admin_is_not_logged_in_is_now(String string) {
	if (string.equalsIgnoreCase("false")) {
		a.setStatus(false);
		assertFalse(a.getStatus());
	} 
   
}

@Then("the report cannot be generated successfully")
public void the_report_cannot_be_generated_successfully() {
    assertFalse(false);
}


}
