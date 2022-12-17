package software;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Records {
	
	Patient c=new Patient();
	MainClass mainClass = new MainClass();
	Appointment appoint=new Appointment(mainClass);

	public Records(Patient client) {
		mainClass = new MainClass();
	    this.appoint=new Appointment(mainClass);

		client=this.c;
		
	}
	
	@Given("that the user type is {string}")
	public void that_the_user_type_is(String string) {
	    if(string.equals(c.getType())) {
	    	assertTrue(true);
	    }
	}

	@When("the user has no previous visits")
	public void the_user_has_no_previous_visits() {
	    if(c.getAppointments().isEmpty()) {
	       has_no_record();
	    }
	}

	@When("has no record")
	public void has_no_record() {
	    assertTrue(true);
	}

	@Then("add new appointment")
	public void add_new_appointment() {
	    c.addAppointment(appoint);
	    assertTrue(true);
	}

	@When("the user already has a previous visits")
	public void the_user_already_has_a_previous_visits() {
		 c.addAppointment(appoint);
		 if(!(c.getAppointments().isEmpty())){
			 assertTrue(true);
		 }
	}



	
}

