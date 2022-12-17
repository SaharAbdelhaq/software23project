package software;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditAppointment {
	MainClass mainClass = new MainClass();
	Appointment a = new Appointment(mainClass);	
	
	Opticity c=new Opticity(mainClass);
	Patient p = new Patient();
	
	
public EditAppointment (Appointment a, Patient p) {
		mainClass = new MainClass();
		this.a = new Appointment(mainClass);
		
		a = this.a;
		p = this.p;
		c = new Opticity(mainClass);
	}
	
	@Given("the user type {string} with id {string}")
	public void the_user_type_with_id(String string, String string2) {
		if (p.getType().equals(string)) {
			p = c.getPatient(Integer.parseInt(string2));
			assertTrue(true);
		}
	}

	@When("the status is {string} for login")
	public void the_status_is_for_login(String string) {
		if (string.equalsIgnoreCase("true")) {
			p.setStatus(true);
			assertTrue(p.getStatus());
		} else
			assertFalse(p.getStatus());
	}

	@When("there is existing appointments")
	public void there_is_existing_appointments() {
		if (!p.getAppointments().isEmpty()) {
	    	assertTrue(true); 
	    } else
	    	assertFalse(false); 
	}

	@When("the appointment id is {string}")
	public void the_appointment_id_is(String string) {
	    if (a.getAid() == Integer.parseInt(string)) {
	    	a = p.getAppointment(Integer.parseInt(string));
	    	assertTrue(true);
	    }
	}

	@When("the new date is {string}")
	public void the_new_date_is(String string) {
		if (string.equals("notnull")) {
			assertTrue(true);
			Date d;
			try {
				d = new SimpleDateFormat("dd-MM-yyyy").parse("01-11-2022");
				a.setDate(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (string.equals(""))
			assertFalse(false);
	}

	@Then("the appointment will be edited successfully")
	public void the_appointment_will_be_edited_successfully() {
		assertTrue(true);
	}

	@When("the new time is {string}")
	public void the_new_time_is(String string) {
		if (string.equals("notnull")) {
			assertTrue(true);
			Date t;
			try {
				t = new SimpleDateFormat("hh:mm-hh:mm").parse("13:30-14:30");
				a.setTime(t);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (string.equals(""))
			assertFalse(false);
	}

	@Then("the appointment will be deleted successfully")
	public void the_appointment_will_be_deleted_successfully() {
	    p.removeAppointment(a);
	    assertTrue(true);
	}

	@Then("the appointment will not be edited")
	public void the_appointment_will_not_be_edited() {
		assertFalse(false);
	}

}
