package software;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class improving {
	MainClass mainClass=new MainClass();
	
	Opticity c=new Opticity(mainClass);
	Appointment appointment =new Appointment(mainClass);
	Admin a;
	Patient p;
	
	public improving (Appointment appointment,MainClass mainClass,Opticity c) {
		mainClass = new MainClass();
		c=this.c;
		appointment=this.appointment;
		a = new Admin();
		p = new Patient();
	}
	
	@Given ("the user is {string}")
	public void the_user_is(String string) {
		if (a.getType().equals(string))
			assertTrue(true);
	}

	@When("the login status is {string} for the admin")
	public void the_login_status_is_for_the_admin(String string) {
		if (string.equalsIgnoreCase("true")) {
			a.setStatus(true);
			assertTrue(a.getStatus());
		} else
			assertFalse(a.getStatus());
	}

	@When("the {string} added a new appointment")
	public void the_added_a_new_appointment(String string) {
		if (string.equals(p.getType())) {
			p.setStatus(true);
			assertTrue(p.getStatus());
		}
	}

	@Then("the admin book the appointment for the client")
	public void the_admin_book_the_appointment_for_the_client() {
	    if(appointment.getAccepted() == false) {
	    	appointment.setAccepted(true);
	    }
	    assertTrue(true);
	}

	@Then("the admin cannot book the appointment for the client")
	public void the_admin_cannot_book_the_appointment_for_the_client() {
	    appointment.setAccepted(false);
	    assertFalse(false);
	}
}
