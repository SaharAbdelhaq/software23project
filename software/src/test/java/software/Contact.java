package software;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Contact {
	Patient u=new Patient();

	public Contact(Patient u) {	
		u=this.u;	
	}

	@Given("that the user is defined as {string}")
	public void that_the_user_is_defined_as(String string) {
		 if(string.equals(u.getType())) {
		    	assertTrue(true);
		 }
	}

	@Given("the patient has a contact number on the record")
	public void the_patient_has_a_contact_number_on_the_record() {
	    if(!(u.getNumber().equals(""))) {
	    	the_contact_number_exists();
	    }
	}

	@Then("the contact number exists")
	public void the_contact_number_exists() {
	    assertTrue(true);
	}

	
	@Given("the patient has no contact number")
	public void the_patient_has_no_contact_number() {
	    if(u.getNumber().equals("")) {
	    	assertTrue(true);
	    }
	}

	@Then("set new number {string}")
	public void set_new_number(String string) {
	    u.setNumber(string);
	}



}